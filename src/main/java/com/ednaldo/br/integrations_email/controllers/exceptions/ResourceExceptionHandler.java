package com.ednaldo.br.integrations_email.controllers.exceptions;


import com.ednaldo.br.integrations_email.dto.StandardErrorDTO;
import com.ednaldo.br.integrations_email.services.exceptions.EmailException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<StandardErrorDTO> email(EmailException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardErrorDTO err = new StandardErrorDTO();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Email error");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}	
}
