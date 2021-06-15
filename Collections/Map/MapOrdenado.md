## Utilizando as Interfaces comparable e Comparator

Todo objeto que implemente Comparable ou Comparator pode ser ordenado por suas regras. Por padrão todas as classes Wrapper (Double, Integer, String, entre outras) implementam estas interfaces. Desta forma, podemos ordenar um Map a partir de sua chave utilizando estas classes.

No exemplo abaixo, temos um Map, do tipo **HashMap**, que apresenta um conjunto de carros e seus respectivos consumos por litro.
```java
    Map<String, Double> carrosPopulares = new HashMap<>(){{
        put("Gol", 14.4);
        put("Uno", 14.1);
        put("Mobi", 15.6;
        put("HB-20", 16.1);
        put("Kwid", 14.5);
    }}
```
> Mas a coleção *HashMap* não mantém a ordem de inserção, desta forma, ao imprimi-la seus elementos serão apresentados aleatoriamente.

Para que a coleção seja apresentada na mesma ordem em que os elementos foram inseridos utilize a **LinkedHashSet**.

Já por ordenar os elementos por uma ordem natural (alfabética, númerica ou por regra) utilize o **TreeMap**.

Abaixo ordenarei a coleção por modelo dos carros, desta forma, ordenarei pela chave do Map, que é uma *String*, passando em seu construtor a coleção HashMap anterior. A classe String implementa *Comparable* desta forma os elementos serão apresentados em ordem alfabética.
```java
    Map<String, Double> carrosPopularesTree = new TreeMap<>(carrosPopulares);
    carrosPopularesTree.forEach(System.out::println);
```

Agora utilizando uma classe implementaremos uma coleção Map para ordena-la. Desta forma, será criada uma classe de Livro com seus atributos, na qual ordenarei conforme o enumciado.
```java
class Livro {
    private String autor;
    private String nome;
    private Integer pagina;

    // Construtores com e sem argumento
    // Getter and Setters

}
```

E agora criando uma classe que implementa *Comparator* para criarmos nossa regra para ordenação, que será por nome do livro. Na qual receberá um tipo Map.Entry, pois ele irá comparar o **Value** do mapa, mas terá que percorrer sua chave. Desta forma, criamos a classe abaixo
```java
class CompararLivroPorNome implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> livro1, Map.Entry<String, Livro> livro2) {
        return livro1.getValue().getNome().compareToIgnoreCase(livro2.getValue().getNome());
    }
}
```
Agora criamos uma coleção Set que receberá um Map para comparação, do tipo **TreeMap** para ordenação
```java
    Map<String, Livro> meusLivros = new HashMap<>(){{
        put("Hawking, Stephen", new Livro ("Stephen Hawking", "Uma Breve História do Tempo", 243);
        put("Duhigg, Charles", new Livro ("Stephen Hawking", "O Poder do Hábito", 362);
        put("Harari, Yuval Noah", new Livro ("Yuval Noah Harari", "21 Lições para o Século 21", 412);
    }}

    // Ordenando por Chave (String)
    // Imprime a Chave (Autor) e Valor (Objeto (Livro) - Nome do Livro)
    Map<String, Livro> listarPorAutor = new TreeMap<>(meusLivros);
    for(Map.Entry<String, Livro> livro : meusLivros.entrySet()){
        System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
    }
    
    // Ordenando por Valor (Nome do Livro)
    // Passando no Construtor a Classe que implementa Comparator
    Set<Map.Entry<String, Livro>> meuLivroOrdenacao = new TreeSet<>(new CompararLivroPorNome());

    // Agora receber a coleção Mapp meusLivros passando o EntrySet() para percorrer toda a coleção
    meuLivroOrdenacao.addAll(meusLivros.entrySet());

    // E imprimindo a ordenação por Nome do Livro
    System.out.println(meuLivroOrdenacao);
```

