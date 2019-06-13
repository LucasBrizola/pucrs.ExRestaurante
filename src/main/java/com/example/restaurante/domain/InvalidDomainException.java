package com.example.restaurante.domain;

public class InvalidDomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidDomainException(String mensagem) {
		super(mensagem);
	}
}
