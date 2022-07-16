package br.com.api.java.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class NotContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final HttpStatus status;

	public NotContentException(String message) {
		super(message);
		this.status = HttpStatus.NO_CONTENT;
	}

}
