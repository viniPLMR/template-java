package br.com.api.java.exception.handlers;

import java.time.LocalDateTime;

import br.com.api.java.exception.NotContentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.api.java.exception.IValidExceptionMapper;
import br.com.api.java.exception.NotFoundException;
import br.com.api.java.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ErrorHandlingControllerAdvice {

	@Autowired
	IValidExceptionMapper mapper;
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ResponseEntity<String> handleNotFoundException(NotFoundException e) {
		log.error("NotFoundException: ", e);

		HttpStatus code = e.getStatus();

		return ResponseEntity.status(code).body(e.getMessage());
	}

	@ExceptionHandler(NotContentException.class)
	@ResponseBody
	public ResponseEntity<String> handleNoContentException(NotContentException e) {
		log.error("NotContentException: ", e);

		HttpStatus code = e.getStatus();

		return ResponseEntity.status(code).body(e.getMessage());
	}
	
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public ResponseEntity<?> handleBindException(BindException e) {
		ValidationException exception = mapper.toValidException(e);
		exception.setTimestamp(LocalDateTime.now());
		log.error("ValidException: ", exception.getErrors());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception);
	}

}
