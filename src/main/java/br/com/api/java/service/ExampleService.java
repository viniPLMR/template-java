package br.com.api.java.service;

import java.util.List;

import br.com.api.java.dto.filter.ExampleFilter;
import br.com.api.java.model.ExampleEntity;
import br.com.api.java.repository.IGenericRepository;
import br.com.api.java.repository.specification.ExampleSpecification;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends GenericCRUD<ExampleEntity, ExampleFilter> {

	private final IGenericRepository<ExampleEntity> repository;
	
	public ExampleService(IGenericRepository<ExampleEntity> repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<ExampleEntity> findByFilter(ExampleFilter filter) {
		return repository.findAll(new ExampleSpecification(filter));
	}

}
