# template-java
Neste projeto java eu quis fazer um "controlador de specification" usando as
próprias reflections do java para poder controlar e gerar demandas de consultas
assim tenho uma entidade pai com id (pois precisa ter um atributo definido caso
necessidade de trocar o nome do id usar anotações que está comentado do
ExampleEntity `@AttributeOverride(name = "id", column = @Column(name = "newId"))`).


####Detalhes do projeto
######Projeto configurado com Spring e banco MySql, estou deixando uma imagem docker no projeto, estava com ele em pé no azure devops mas acabei tirando por não usar o projeto mais.

#Subindo o projeto
Basta rodar a imagem docker que vai subir um MySql trocar o usuario e senha q se encontram no `application.properties`
o projeto está rodando na porta padrão `localhost:8080` temos um swagger para poder testar
futuras api`s e testes.

# PECULIARIDADES DO PROJETO E COMO MONTAR SUA SPECIFICATION GENÉRICA
##Como montar sua specification
Vamos seguir o fluxo natural das coisas.
* criar sua controller colocar as anotações `@RestController` e `@RequestMapping` e ela vai extender da controller genérica que já contém alguns métodos como `save, findById, findAll(passando um filtro também genérico), update e delete`(oq nao te impede de sobreescrevelos ou alteralos) e para criar sua Controller voce vai passar para ela `Entity, Request, Response, Filter`, onde o `Request` so e usado no `update` e no `save` e o`Response` vai ser retorno em todos passando pelo mapper genérico, para o `Filter` pode criar um POJO com o sufixo Filter e passar ele (obs: os nomes no filter tem que ser exatamente iguais os que estão na base).

##Cricacao da specification
* crie uma specification que herde da sua genérica e passe sua entidade e seu filtro, logo em seguida de um `@Override` no método `toPredicate` e siga a mesma implementação da specification de exemplo logo após você ira chamar ela no seu `findAll(specification)` como no exemplo da service

##Como a specification funciona `generateBasicPredicate()`
todos os atributos do `Filter` e da `Entity` sao passados para arrays de Fields com o método `getClassFields()` então passam por uma lista de repetição para poder adicionar somente os campos que existem nos dois tanto no filter como na entity para ai entao ir para a criação da specification em primeiro lugar precisamos deixar a field de forma que possa ser consultada então colocamos como `field.setAccessible(true)` e vamos as validações, verificamos se ela é uma string um booleano (caso seja vemos se e verdadeiro ou falso) e outros casos tratamos com a mesma criteria, para verificar se e um texto usamos o método `verifyText(field)`, que nos retorna um bolean, para verificar se é um boolean `verifyBoolean()`

###Para adicionamos na specification
* em caso de texto colocamos `add(predicate, criteriaBuilder.like(root.get(fields[i].getName()), "%" + field + "%"));add(predicate, criteriaBuilder.like(root.get(fields[i].getName()), "%" + field + "%"));`
* boleano verdadeiro `add(predicate, criteriaBuilder.isTrue(root.get(fields[i].getName())));`
* boleano falso `add(predicate, criteriaBuilder.isFalse(root.get(fields[i].getName())));`
* outros casos `add(predicate, criteriaBuilder.trim(root.get(fields[i].getName())).in(field.toString()));`
  sempre passando o nome da coluna q vamos comparar
