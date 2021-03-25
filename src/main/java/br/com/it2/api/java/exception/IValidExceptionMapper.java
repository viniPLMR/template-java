package br.com.it2.api.java.exception;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.validation.BindException;

@Mapper(componentModel = "spring")
public interface IValidExceptionMapper {

	@Mapping(source = "allErrors", target = "errors")
	public ValidationException toValidException(BindException exception);

}
