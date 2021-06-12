## Ordenação de Elementos em List

Dadas as seguintes informações sobre meus gatos, crie uma lista e ordene esta lista exibindo:
> Nome - Idade - Cor

Objetos a serem criados:
* Gato 1 = nome: Jon, idade: 18, cor: preto
* Gato 2 = nome: Simba, idade: 6, cor: tigrado
* Gato 3 = nome: Jon, idade: 12, cor: amarelo

```java
    List<Gato> meusGatos = new ArrayList<>(){{
        add(new Gato("Jon", 12, "preto"));
        add(new Gato("Simba", 6, "tigrado"));
        add(new Gato("Jon", 18, "amarelo"));
    }};
```
### Para Listar Ordem que Foram Inseridos
Para realizar a listagem dos itens presentes em uma lista, não é necessário tomar nenhuma ação. É só chamar o método para imprimir
```java
    System.out.println("--\tOrdem de Inserção\t---");
    System.out.println(meusGatos);
```

### Para Mudar a Ordem Aleatoriamente
Para mudar a ordem sem seguir uma regra especifica podemos utilizar o método Shuffle da classe Collection para este fim
```java
    System.out.println("--\tOrdem aleatória\t---");
    Collections.shuffle(meusGatos);
    System.out.println(meusGatos);
```

### Para Mudar a Ordem Seguindo o Critério do Elemento ou do Primeiro Atributo do Objeto
Já para ordená-los em ordem alfabética, caso o elemento armazenado seja uma string, é possível utilizar o método estático da classe Collection (Sort) para esta função. Caso o elemento fosse numérico (int, double, float) ele ordenaria em ordem alfabética. Mas em nosso exemplo, é utilizado um Objeto, desta forma, esta classe deve implementar a interface *Comparable*, assim, conforme a lógica implementada no método **compareTo** será listado os objetos. 
```java
    System.out.println("--\tOrdem Natural (Nome)\t---");
    Collections.sort(meusGatos);
    System.out.println(meusGatos)
```

## Utilizando as Interfaces Comparable
É possível utilizar os demais atributos de uma classe para serem utilizados como regra para ordenação, mas para que seja possível realizar esta operação a classe do objeto a ser criado deve implementar a interface Comparable.

Conforme a classe implementa a interface Comparable, ela precisa sobreescrever o método **compareTo**, na qual retorna um *int*. A partir dela podemos implementar que sempre que a lista for invocada, os seus elementos estarão listados seguindo a ordem especificada no método.
```java
    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
```
Aqui estamos considerando o atributo *nome*, mas poderiamos utilizar qualquer outro atributo da classe para realizar esta regra de ordenação, conforme o exemplo abaixo
```java
    @Override
    public int compareTo(Gato gato) {
        return this.getIdade().compareTo(gato.getIdade());
    }
```
Neste caso se a idade (ou nome) retornar -1, quer dizer que é menor na ordem, se retornar 0 são iguais e se retornar 1 quer dizer que é maior.

## Utilizando a Interface Comparator
Para utilizar mais atributos de um objeto para refinar o comparativo entre objetos, pode-se utilizar a interface *Comparator*, isto não significa que não é possível fazer isto no *Comparable*, mas o código irá comparar somente um atributo por vez.

Com Comparator podemos criar uma classe especifica para comparar um determinado objeto. Por exemplo, é possível criar uma classe *ComparaIdadeGatos* que implementa Comparator do tipo **Gato** e utilizar um de seus atributos para serem comparados
```java
    class ComparaIdadeGatos implements Comparator<Gato> {
        @Override
        public int compare(Gato g1, Gato g2){
            return Integer.compare(g1.getIdade(), g2.getIdade());
        }
    }
```

Agora temos duas possibilidade de invocar nossa classe de comparação para permitir que a lista de gatos seja ordenada.
```
    System.out.println("---Ordem Idade---")
    /* 
     * Utilizando a Classe Collections passando como parâmetros a lista (List-Collection)
     * e um Comparator (ComparaIdadeGatos implementa um Comparator - Desta forma, é utilizado o fator de multípla-herança)
     */
    Collections.sort(meusGatos, new ComparaIdadeGatos());

    /*
     * Ou utilizando o método que a própria Collection permite que a List utilize diretamente
     * onde passamos como parâmetro um objeto do tipo Comparator ou que o implemente
     */
     meusgatos.sort(new ComparaIdadeGatos());
```

Desta forma, poderiamos realizar este mesmo procedimento com qualquer atributo da nossa classe utilizando esta lógica.

### Utilizando Mais de Um Atributo para Ordenar Objetos em uma List
Podemos utilizar mais de um atributo de um objeto para validar que eles realmente são totalmente diferente. No exemplo dos gatos é possível comparar entre todos os seus atributos para evidenciar suas diferenças.

Será criado uma classe ComparaNomeIdadeCorDosGatos que implementa **Comparator**.
```java
    class ComparaNomeIdadeCorDosGatos implements Comparator<Gato> {
        @Override
        public int compare(Gato g1, Gato g2){
            int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
            if(nome != 0) return nome;

            int idade = Integer.compare(g1.getIdade(), g2.getIdade());
            if(idade != 0) return idade;

            int cor = g1.getCor().compareToIgnoreCase(g2.getCor());

            return cor;
        }
    }
```

Desta forma, o objeto será ordenado por multiplos fatores de avaliação, para determinar se são totalmente iguais ou diferentes. Realizando a seguinte regra:
* Primeiro será determinado se os nomes são iguais, se são;
* Entra o segundo fator, se as idades são as mesmas, se são;
* Será avaliada se a cor é a mesma - se for - **Os gatos são iguais**.

Para isso invocamos o método **Sort** utilizando uma das duas formas passadas anteriormente.
