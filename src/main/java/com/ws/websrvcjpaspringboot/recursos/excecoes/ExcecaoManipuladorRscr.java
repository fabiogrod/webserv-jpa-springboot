package com.ws.websrvcjpaspringboot.recursos.excecoes;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ws.websrvcjpaspringboot.servicos.excecoes.ExcecaoBD;
import com.ws.websrvcjpaspringboot.servicos.excecoes.ExcecaoRcrsNaoEncontrado;

@ControllerAdvice
public class ExcecaoManipuladorRscr {
	
	@ExceptionHandler(ExcecaoRcrsNaoEncontrado.class)
	public ResponseEntity<ErroPadrao> rscrNaoEncontrado(ExcecaoRcrsNaoEncontrado e, HttpServletRequest requisicao) {
		String erro = "Recurso não encontrado";
		
		HttpStatus estado = HttpStatus.NOT_FOUND;
		
		ErroPadrao err = new ErroPadrao(Instant.now(), estado.value(), erro, e.getMessage(), requisicao.getRequestURI());
		return ResponseEntity.status(estado).body(err);
	}
	
	@ExceptionHandler(ExcecaoBD.class)
	public ResponseEntity<ErroPadrao> bancoDados(ExcecaoBD e, HttpServletRequest requisicao) {
		String erro = "Erro do banco de dados";
		
		HttpStatus estado = HttpStatus.BAD_REQUEST;
		
		ErroPadrao err = new ErroPadrao(Instant.now(), estado.value(), erro, e.getMessage(), requisicao.getRequestURI());
		return ResponseEntity.status(estado).body(err);
	}
}
