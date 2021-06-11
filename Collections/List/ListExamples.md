## Exemplo do uso de List (java.util.List)

### Lista de Preenchimento Estático
Exemplo de Lista Estática na qual caso seja invocado o método add(), remove() ou set(), após a instanciação de valores, retornará erro.
```java
List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);

// Ou utilizando o método of() de List

List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
```

### Lista de Preenchimento Dinâmico
Exemplo de Lista com preenchimento dinâmico, na qual é possivel incluir valores e depois manipula-la caso haja necessidade. O *Diamond Operator* foi incluso na versão 7 enquanto o uso do *Generics* foi incluído no Java 5.
```java
List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
```

### Operadores de Manipulação de List
Segue os métodos da classe List que permite manipular os valores
```java
    List<Double> notas = new ArrayList<Double>(); //Generics(jdk 5) - Diamond Operator(jdk 7)

    // Adicionar valor a lista
    notas.add(7.0);

    // Exibir a posição do elemento na lista (Neste exemplo é informado um Objeto (7.0 do padrão Double))
    notas.indexOf(7D);

    // Incluir um elemento na lista passando a posição que deve ser alocado (add(ind, Object))
    notas.add(2, 2.4);

    // Substituir um elemento de uma posição por outro valor
    notas.set(notas.indexOf(7D), 8.7);

    // Verificar se uma lista tem um valor especifico
    notas.contains(7D);

    // Exibir o conteúdo de uma determinada posição ao informar seu índice
    notas.get(0)

    // Remover o valor informado da lista
    notas.remove(10.0);

    // Devolve a quantidade de elementos de uma lista
    Integer quantidadeNaLista = notas.size();

    // Verifica se a lista encontra-se vazia
    Boolean ListaVazia = notas.isEmpty();
```


