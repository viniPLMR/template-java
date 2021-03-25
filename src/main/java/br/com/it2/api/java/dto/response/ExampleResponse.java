package br.com.it2.api.java.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleResponse extends GenericResponse {

	private Long id;
	
	private String name;
	
}
