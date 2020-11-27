package com.ws.websrvcjpaspringboot.recursos.excecoes;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant timestamp;
	private Integer estado;
	private String erro;
	private String msg;
	private String caminho;
	
	public ErroPadrao() {}

	public ErroPadrao(Instant timestamp, Integer estado, String erro, String msg, String caminho) {
		super();
		this.timestamp = timestamp;
		this.estado = estado;
		this.erro = erro;
		this.msg = msg;
		this.caminho = caminho;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
}
