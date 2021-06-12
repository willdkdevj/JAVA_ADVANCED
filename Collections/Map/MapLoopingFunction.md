## Exemplo de Funções para Percorrer um Map
As estruturas de looping são muito utilizadas para percorrer Map's para realizar operações.
Por exemplo, verificar em um Map qual é o modelo de carro mais econômico
```java
    /*
     * Obtém o maior valor em uma variável Double / 
     * O método values() retorna uma Collection que pode ser inserida em Collections.max() para obter o valor (VALUE)
     */
    Double consumoMaisEficiente = Collections.max(carrosPopulares.values());

    /*
     * Precisamos agora de uma variável especial para compara o valor com as chaves a fim de localizar o valor correspondente
     * o método entrySet() retorna uma lista Set mapeando todos as chaves e valores
     */
    Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();

    // Variável (String) para armazenar o modelo do carro de menor consumo (CHAVE)
    String modeloMaisEficiente = "";

    // Agora utilizando uma função For Each podemos verificar se os valores ao percorrer os valores do Set
    for (Map.Entry<String, Double> entry : entries) {

        // Agora com o objeto podemos pegar o valor (getValue()) e agregar o método de igualdade (equals()) para checar se os elementos são iguais
        if (entry.getValue().equals(consumoMaisEficiente)) {

            // Caso verdadeiro, descobrimos a CHAVE.
            modeloMaisEficiente = entry.getKey();
            System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
        }
    }
```

Agora interagindo com o Map a fim de apresentar a soma de **TODOS** os valores da coleção
```java
    // Cria um objeto Iterator
    Iterator<Double> iterator = carrosPopulares.values().iterator();
    Double soma = 0d;

    // Percorre o Map enquanto haver valores a serem retornados
    while(iterator.hasNext()){
        soma += iterator.next();
    }

    System.out.println("Exiba a soma dos consumos: " + soma);
```

Caso necessite encontrar um valor para **REMOVÊ-LO** do Map é necessário realizar novamente o looping
```java
    // Cria um objeto Iterator
    Iterator<Double> iterator = carrosPopulares.values().iterator();

    // Percorre o Map enquanto haver valores a serem retornados
    while(iterator.hasNext()){
        if(iterator.next().equals(15.4))
            iterator.remove;
    }

    System.out.println("Exiba os elementos presentes na lista: " + carrosPopulares);
```