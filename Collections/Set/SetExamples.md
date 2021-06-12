## Caracteristicas da Interface Set
O Set possui caracteristicas de difere de List como:
* **Não** permite elementos **duplicados**;
* **Não** possuí **índice** (metódo get());

**HashSet** - Ordem os elementos inseridos fica **Aleatória** (performace alta);
**LinkedHashSet** - Mantém a ordem de inserção dos elementos;
**TreeSet** - Ela mantém a ordem numérica, alfabética ou de suas implementações (Comparable/Comparator) (performance baixa).

Com o Set não é possível realizar buscas por índice, visto que, não há métodos para pesquisa.

Já para saber se existe um elemento no Set é possível utilizar o método **contains()**;

## Comparação entre Elementos de uma Lista Hash
Ao utilizarmos uma coleção que implementa os tipos **Hash** podemos implementar na classe que será armazenada por esta lista *hash* os métodos **equals()** e **hashcode()**, que são herdados na **super** classe *Object*.

```java
class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    // Construtores com e sem parâmetros

    // Métodos Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public String toString() {
        return "[" +
                "Nome= " + nome + " | " +
                "Genero= " + genero + " | " +
                "Tempo do Episodio= " + tempoEpisodio +
                " minutos]";
    }

}
```

Agora podemos criar a lista com HashSet para visualizar seus elementos.
```java    
    Set<Serie> minhasSeries = new HashSet<>(){{
        add(new Serie("got", "fantasia", 60));
        add(new Serie("dark", "drama", 60));
        add(new Serie("that '70s show", "comédia", 25));
    }};
    
    System.out.println("--\tOrdem aleatória\t--");
    for (Serie serie: minhasSeries) 
    System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());
```

Agora para visualizarmos conforme a ordem de inserção utilizamos o *LinkedHashSet*.
```java    
    Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
        add(new Serie("got", "fantasia", 60));
        add(new Serie("dark", "drama", 60));
        add(new Serie("that '70s show", "comédia", 25));
    }};

    System.out.println("--\tOrdem inserção\t--");
    for (Serie serie: minhasSeries1) System.out.println(serie.getNome() + " - "
            + serie.getGenero() + " - " + serie.getTempoEpisodio());
```

Agora para ordenarmos seguindo uma ordem pré-estabelecida pelo objeto, na qual irá verificar a regra imposta na implementação dos métodos de Comparable ou de Comparator, utilizamos o *TreeSet*. Desta forma, o elemento da lista obrigatoriamente deve implementar estas interfaces para ordenar seus elementos em uma ordem pré-estabelecida.

Então a classe Serie deve implementar Comparable (por exemplo) e implementar o método compareTo() para ordenar os objetos Serie.
```java
class Serie implements Comparable<Serie>{
    // Atributos privados
    // Construtores com e sem argumentos
    // Métodos Getters and Setters
    // Sobrescrição do método toString()

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }
}
```

Com a implentação do método compareTo() na classe Serie é possível ordernar os objetos na ordem natural referente ao Tempo do Episódio de cada serie.
```java
    System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
    Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
    for (Serie serie: minhasSeries2) System.out.println(serie.getNome() + " - "
            + serie.getGenero() + " - " + serie.getTempoEpisodio());

    System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
    Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
    minhasSeries3.addAll(minhasSeries);
    for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - "
            + serie.getGenero() + " - " + serie.getTempoEpisodio());
```
> Mas há uma observação: Caso no comparação ocorra parâmetros iguais o set irá eliminar o objeto - Pois Set não permite valores repetidos.

### Utilizando a Interface Comparator
Agora para comparar utilizando a interface **Comparator** podemos criar uma classe que avalie mais de um atributo da classe para realizar a comparação entre os objetos.

```java
    class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}
```

E ao adicionar nossa lista Set a uma lista TreeSet utilizando o método addAll(), onde em seus elementos que são objetos da classe Serie que implementa Comparator, podemos passá-los como parãmetros para realizar a ordenação seguindo a regra imposta no método compare().
```java
    System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
    Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
    minhasSeries3.addAll(minhasSeries);
    for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - "
            + serie.getGenero() + " - " + serie.getTempoEpisodio());
```