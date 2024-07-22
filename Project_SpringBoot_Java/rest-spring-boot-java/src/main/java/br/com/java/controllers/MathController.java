package br.com.java.controllers;

//import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.converter.NumberConverter;
import br.com.java.exceptions.UnsupportedMathOperationException;
import br.com.java.math.SimpleMath;

@RestController
public class MathController {
	
	private SimpleMath simpleMath = new SimpleMath();
	
	// Adição
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor verifique os NUMEROS enviados!");
		}
		
		return this.simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// Subtração
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor verifique os NUMEROS enviados!");
		}
		
		return this.simpleMath.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// Multiplicação
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor verifique os NUMEROS enviados!");
		}
		
		return this.simpleMath.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// Divisão
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(

			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor verifique os NUMEROS enviados!");
		}
		
		return this.simpleMath.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	// Média entre dois números
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor verifique os NUMEROS enviados!");
		}
		
		return this.simpleMath.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	// Raiz Quadrada
	@GetMapping("/squareRoot/{numberOne}")
	public Double squareRoot(
			@PathVariable(value = "numberOne") String numberOne) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Por favor verifique o NUMERO enviado!");
		}
		
		return this.simpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));
	}
	
}