package br.com.api.java.dto.mapper;

import java.util.List;

import br.com.api.java.dto.request.GenericRequest;
import br.com.api.java.dto.response.GenericResponse;
import br.com.api.java.model.GenericEntity;

public interface IGenericMapper<Entity extends GenericEntity, Request extends GenericRequest, Response extends GenericResponse> {

	public Entity toEntity(Request request);
	
	public Entity toEntity(Long id);
	
	public Entity toEntity(Request request, Long id);
	
	public Response toResponse(Entity entity);
	
	public List<Response> toResponse(List<Entity> entityList);
	
}
