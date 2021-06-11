Colletions interagindo com List

### Utilizando métodos da Collections para manusiar as Lists
Utilizando alguns métodos para interajir com as Lists afim de descubrir seus valores
```java
    // Retornando o menor valor presente na Lista
    Collections.min(listaNumeros);

    // Retornando o maior valor presente na Lista
    Collections.max(listaNumeros);
```

### Iterando em uma List
Percorrer os valores de uma List para realizar uma operação utilizando o ITERATOR
```java
    Iterator<Double> iterator = notas.iterator();
    Double soma = 0D;

    while(iterator.hasNext()){
        Double valorEncontrado = iterator.next();
        soma += valorEncontrado;
    }
    System.out.println("O resultado é " + soma);
```

Realizando a mesma operação, mas utilizando o FOR EACH
```java
    List<Double> notas = new ArrayList<>(Arrays.asList( 8.9, 9.7, 9.9, 7.9, 8.5));
    Double soma = 0D;

    for(Double nota : notas){
        soma += nota;
    }
    System.out.println("O resultado é " + soma);
```

