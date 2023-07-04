package com.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.dto.ResponseDTO;

@RestControllerAdvice
public class MyExceptionalHandler {

	@ExceptionHandler(value = CustomException.class)
	public ResponseEntity<ResponseDTO> handleCustomException(CustomException e) {

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage(e.getMessage());
		responseDTO.setCode(e.getHttpStatus());
		responseDTO.setStatus(false);

		return ResponseEntity.status(400).body(responseDTO);

	}
	

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public String exceptionHandlerException(Exception m) {
		return m.getMessage();
	}
}
