package br.com.api.java.steps;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.api.java.model.ExampleEntity;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ExampleSteps {

	ExampleEntity entity = new ExampleEntity();

	@Dado("que eu tenho uma entidade")
	public void que_eu_tenho_uma_entidade() {
		assertNotNull(entity);
	}

	@Quando("a entidade trabalhar")
	public void a_entidade_trabalhar() {
	    entity.work();
	}

	@Então("o conteudo da mensagem deve ser {string}")
	public void o_conteudo_da_mensagem_deve_ser(String string) {
	    assertEquals(string, entity.getMessage());
	}

}
