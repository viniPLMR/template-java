package br.com.it2.api.java.service;

import java.util.List;

import br.com.it2.api.java.exception.NotContentException;
import br.com.it2.api.java.exception.NotFoundException;
import br.com.it2.api.java.model.GenericEntity;
import br.com.it2.api.java.repository.IGenericRepository;

public abstract class GenericCRUD<Entity extends GenericEntity, Filter>
		implements IGenericCRUD<Entity, Filter> {

	private final IGenericRepository<Entity> repository;

	public GenericCRUD(IGenericRepository<Entity> repository) {
		this.repository = repository;
	}

	@Override
	public Entity save(Entity entity) {
		return repository.save(entity);
	}

	@Override
	public Entity update(Entity entity) {
		if (entity.getId() != null) {
			findById(entity.getId());
			return repository.save(entity);
		} else {
			throw new NotFoundException("Entity not found");
		}
	}

	@Override
	public Entity findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Entity not found"));
	}

	@Override
	public List<Entity> findAll() {
		List<Entity> entities = repository.findAll();
		if (!entities.isEmpty())
			return entities;
		throw new NotContentException("No content");
	}

	@Override
	public void delete(Long id) {
		repository.delete(findById(id));
	}

}
