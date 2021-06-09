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
Percorrer os valores de uma List para realizar uma operação
```java
    Iterator<Double> iterator = notas.iterator();
    Double soma = 0D;

    while(iterator.hasNext()){
        Double valorEncontrado = iterator.next();
        soma += valorEncontrado;
    }
    System.out.println("O resultado é " + soma);
```

