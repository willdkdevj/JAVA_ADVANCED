### Ordenação de Elementos em List

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

