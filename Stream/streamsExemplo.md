##JAVA 8 - Streams

### Encontrar elemento em uma Lista ao informar o ID por parametro (Pode ser outros atributos do elemento)
```java
Elemento elemento = list.stream().filter(elem -> elem.getId().compareTo(id)) == 0).findFirst().get();
```

### Converter um objeto de uma lista em DTO através do Mapper onde no construtor de DTO deve existir um para construir o Objeto Model
```java
List<ObjDTO> listDTO = list.stream().map(ClassDTO::new).collect(Collectors.toList());
```

> Outro modo de fazer, só que mais verboso
```java
List<ObjDTO> listDTO = new ArrayList<>(); 

list.stream().forEach(model -> {
	ObjDTO dto = new ObjDTO(model);
	listDTO.add(dto);
});
```
> Caso exista uma instancia de Mapper
```java
List<ObjDTO> listDTO = list.stream().map(mapper::toDTO).collect(Collectors.toList()).
```
