package br.com.api.java.dto.filter;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExampleFilter {

	@Length(min = 2)
	private String name;
	
	private String xxx;
	
	private Boolean active;
	
}
