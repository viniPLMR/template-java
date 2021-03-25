package br.com.it2.api.java.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.it2.api.java.model.ExampleEntity;
import br.com.it2.api.java.repository.IExampleRepository;

@SpringBootTest
public class ExampleServiceTest {

	@Mock
	private IExampleRepository repository;
	
	private ExampleService service;
	
	@Before
	public void config() {
		MockitoAnnotations.initMocks(this);
		service = new ExampleService(repository);
	}
	
	@Test
	public void shouldCreate() {
		
		ExampleEntity entity = new ExampleEntity();
		entity.setId(1L);
		when(repository.save(any())).thenReturn(entity);
		
		ExampleEntity savedEntity = service.save(entity);
		assertThat(savedEntity).isNotNull();
		assertThat(savedEntity.getId()).isEqualTo(1L);
		assertThat(savedEntity.getName()).isNull();
		
	}
	
}
