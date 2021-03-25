package br.com.it2.api.java.dto.mapper;

import org.mapstruct.Mapper;

import br.com.it2.api.java.dto.request.ExampleRequest;
import br.com.it2.api.java.dto.response.ExampleResponse;
import br.com.it2.api.java.model.ExampleEntity;

@Mapper(componentModel = "spring")
public interface IExampleMapper extends IGenericMapper<ExampleEntity, ExampleRequest, ExampleResponse> {

}
