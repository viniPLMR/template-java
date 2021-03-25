package br.com.it2.api.java.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.it2.api.java.dto.filter.ExampleFilter;
import br.com.it2.api.java.dto.request.ExampleRequest;
import br.com.it2.api.java.dto.response.ExampleResponse;
import br.com.it2.api.java.model.ExampleEntity;

@RestController
@RequestMapping("/example")
public class ExampleController extends GenericController<ExampleEntity, ExampleRequest, ExampleResponse, ExampleFilter> {

}
