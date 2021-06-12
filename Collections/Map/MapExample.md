## Caracteristicas da Interface Map de Collections

O Map possui caracteristicas de semelhante de List e distinta de Set, como por exemplo:
* Estrutura de **Chave e Valor**;
* As chaves são únicas, mas os valores podem ser repetidos;

* **Não** permite elementos **duplicados**;
* **Não** possuí **índice** (metódo get());

**HashMap** - Ordem os elementos inseridos fica **Aleatória** (performance alta);
**LinkedHashMap** - Mantém a ordem de inserção dos elementos (performance alta);
**TreeMap** - Ela mantém a ordem numérica, alfabética ou de suas implementações (Comparable/Comparator) (performance baixa).

* *HashMap* e *LinkedHashMap* permite chaves nulas, já o TreeMap não permite;
* Quanto a Estrutura de Dados (Data Structure) o HashMap utiliza *list of Buckets*, já o LinkedHashMap utiliza *Doubly Linked List* e o TreeMap utiliza Red-Black Tree;

### Exemplo Utilizando Um Problema
Para entender melhor o funcionamento dos Map's utilizaremos um problema para simular a necessidade de obter valores do consumo de um veículo.

Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
* Modelo = gol - Consumo = 14,4km/l
* Modelo = uno - Consumo = 15,6 km/l
* Modelo = mobi - Consumo = 16,1 km/l
* Modelo = hb20 - Consumo = 14,5 km/l
* Modelo = kwid - Consumo = 15,6 km/l

Agora vamos mapear este valores para um MAP a fim de interagir com este valores e solucionar um problema.
Primeiramente, vamos aplicar os valores obtidos em um MAP
```java
    Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
```

Agora vamos acessar um valor de um veículo, que foi passado como chave, e mudar seu valor
```java
    System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
    carrosPopulares.put("gol", 15.2);
    System.out.println(carrosPopulares);
```

Agora vamos verificar se um determinado tipo de carro está em nossa coleção, na qual retornará um valor **BOOLEAN** (TRUE/FALSE)
```java
    System.out.println("Confira se o modelo tucson está no dicionário: " + carrosPopulares.containsKey("tucson"));
```

Agora vamos buscar uma determinada chave na coleção e apresentar o seu valor
```java
    System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno"));
```

Agora vamos inserir as chaves em uma Lista Set e exibir seus valores;
```java
    System.out.println("Exiba os modelos: ");
    Set<String> modelos = carrosPopulares.keySet();
    System.out.println(modelos);
```
Agora vamos repetir o procedimento, mas agora apresentando os valores presentes no MAP
```java
    System.out.println("Exiba os consumos dos carros: ");
    Collection<Double> consumos = carrosPopulares.values();
    System.out.println(consumos);
```

