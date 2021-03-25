package br.com.it2.api.java.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.it2.api.java.dto.mapper.IGenericMapper;
import br.com.it2.api.java.dto.request.GenericRequest;
import br.com.it2.api.java.dto.response.GenericResponse;
import br.com.it2.api.java.exception.ValidationException;
import br.com.it2.api.java.model.GenericEntity;
import br.com.it2.api.java.service.GenericCRUD;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Generic CRUD")
public class GenericController<Entity extends GenericEntity, Request extends GenericRequest, Response extends GenericResponse, Filter> {

	@Autowired
	private GenericCRUD<Entity, Filter> service;

	@Autowired
	private IGenericMapper<Entity, Request, Response> mapper;

	@PostMapping
	@ApiOperation(value = "Save")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiResponses({ @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 422, message = "Unprocessable Entity", response = ValidationException.class) })
	public ResponseEntity<Response> save(@Valid @RequestBody Request entityRequest) {
		Entity entity = service.save(mapper.toEntity(entityRequest));
		return ResponseEntity.status(HttpStatus.CREATED).header(HttpHeaders.LOCATION, entity.getId().toString())
				.body(mapper.toResponse(entity));
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Find by ID")
	@ApiResponses({ @ApiResponse(code = 404, message = "Not fount") })
	public ResponseEntity<Response> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(mapper.toResponse(service.findById(id)));
	}

	@GetMapping
	@ApiOperation(value = "Find by filter")
	@ApiResponses({ @ApiResponse(code = 204, message = "No content", response = Null.class) })
	public ResponseEntity<List<Response>> findAll(@Valid Filter filter) {
		return ResponseEntity.ok(mapper.toResponse(service.findByFilter(filter)));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No content"),
			@ApiResponse(code = 404, message = "Not found"),
			@ApiResponse(code = 422, message = "Unprocessable Entity", response = ValidationException.class) })
	public ResponseEntity<Void> update(@Valid @RequestBody Request request, @PathVariable("id") Long id) {
		service.update(mapper.toEntity(request, id));
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping
	@ApiOperation(value = "Delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiResponses(value = { @ApiResponse(code = 204, message = "No content"),
			@ApiResponse(code = 404, message = "Not found") })
	public ResponseEntity<Void> delete(@RequestParam Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
