$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/example.feature");
formatter.feature({
  "name": "Exemplo",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenario({
  "name": "Exemplo",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@teste1"
    }
  ]
});
formatter.step({
  "name": "que eu tenho uma entidade",
  "keyword": "Dado "
});
formatter.match({
  "location": "br.com.it2.api.java.steps.ExampleSteps.que_eu_tenho_uma_entidade()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a entidade trabalhar",
  "keyword": "Quando "
});
formatter.match({
  "location": "br.com.it2.api.java.steps.ExampleSteps.a_entidade_trabalhar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "o conteudo da mensagem deve ser \"Hello world\"",
  "keyword": "Então "
});
formatter.match({
  "location": "br.com.it2.api.java.steps.ExampleSteps.o_conteudo_da_mensagem_deve_ser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});