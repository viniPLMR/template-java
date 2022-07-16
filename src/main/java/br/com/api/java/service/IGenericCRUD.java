package br.com.api.java.service;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.api.java.model.GenericEntity;

@Component
public interface IGenericCRUD<Entity extends GenericEntity, Filter>{

	public Entity save(Entity entity);

	public Entity update(Entity entity);

	public Entity findById(Long id);

	public List<Entity> findAll();

	public List<Entity> findByFilter(Filter filter);

	public void delete(Long entity);

}
