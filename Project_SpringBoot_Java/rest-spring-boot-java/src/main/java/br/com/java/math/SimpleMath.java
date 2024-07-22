package br.com.java.math;

public class SimpleMath {
	
	// Adição
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	
	// Subtração
	public Double subtraction(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	
	// Multiplicação
	public Double multiplication(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	
	// Divisão
	public Double division(Double numberOne, Double numberTwo) {
		return numberOne / numberTwo;
	}
	
	// Média entre dois números
	public Double mean(Double numberOne, Double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}
	
	// Raiz Quadrada
	public Double squareRoot(Double numberOne) {
		return Math.sqrt(numberOne);
	}
}
