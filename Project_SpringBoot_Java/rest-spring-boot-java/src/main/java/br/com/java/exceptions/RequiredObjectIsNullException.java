package br.com.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RequiredObjectIsNullException() {
		super("Nao e permitido persistir um objeto nulo!");
	}
	
	public RequiredObjectIsNullException(String message) {
		super(message);
	}

}
