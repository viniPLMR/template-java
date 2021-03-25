package br.com.it2.api.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.it2.api.java.dto.filter.ExampleFilter;
import br.com.it2.api.java.model.ExampleEntity;
import br.com.it2.api.java.repository.IGenericRepository;
import br.com.it2.api.java.repository.specification.ExampleSpecification;

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
