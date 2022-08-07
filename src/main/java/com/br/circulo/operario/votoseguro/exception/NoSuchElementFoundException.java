package com.br.circulo.operario.votoseguro.exception;

public class NoSuchElementFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoSuchElementFoundException(String mensagem) {
		super(mensagem);
	}
}
