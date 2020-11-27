package com.ws.websrvcjpaspringboot.servicos.excecoes;

public class ExcecaoRcrsNaoEncontrado extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExcecaoRcrsNaoEncontrado(Object id) {
		super("Recurso não encontrado. Id: " + id);
	}	
}
