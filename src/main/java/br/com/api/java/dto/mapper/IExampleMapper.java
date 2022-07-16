package br.com.api.java.dto.mapper;

import org.mapstruct.Mapper;

import br.com.api.java.dto.request.ExampleRequest;
import br.com.api.java.dto.response.ExampleResponse;
import br.com.api.java.model.ExampleEntity;

@Mapper(componentModel = "spring")
public interface IExampleMapper extends IGenericMapper<ExampleEntity, ExampleRequest, ExampleResponse> {

}
