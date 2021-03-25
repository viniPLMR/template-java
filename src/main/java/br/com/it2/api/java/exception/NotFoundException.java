package br.com.it2.api.java.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public NotFoundException(String message) {
		super(message);
		this.status = HttpStatus.NOT_FOUND;
	}

}
