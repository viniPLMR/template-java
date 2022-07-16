package br.com.api.java.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.validation.ObjectError;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidationException {
	
	private LocalDateTime timestamp;
	
	private List<ObjectError> errors;
	
}
