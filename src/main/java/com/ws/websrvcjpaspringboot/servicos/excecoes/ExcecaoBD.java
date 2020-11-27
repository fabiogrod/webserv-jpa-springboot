package com.ws.websrvcjpaspringboot.servicos.excecoes;

public class ExcecaoBD extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ExcecaoBD(String msg) {
		super(msg);
	}
}
