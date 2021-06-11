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
Já para ordená-los em ordem alfabética, caso o elemento armazenado seja uma string, é possível utilizar o método estático da classe Collection (Sort) para esta função. Caso o elemento fosse numérico (int, double, float) ele ordenaria em ordem alfabética. Mas em nosso exemplo, é utilizado um Objeto, desta forma, é levado em consideração o primeiro atributo do objeto, neste caso o nome do gato (Nome), que é uma String. 
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