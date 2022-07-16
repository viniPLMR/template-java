package br.com.api.java.controller;

import br.com.api.java.dto.filter.ExampleFilter;
import br.com.api.java.dto.request.ExampleRequest;
import br.com.api.java.dto.response.ExampleResponse;
import br.com.api.java.model.ExampleEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController extends GenericController<ExampleEntity, ExampleRequest, ExampleResponse, ExampleFilter> {

}
