package com.ws.websrvcjpaspringboot.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ws.websrvcjpaspringboot.entidades.enums.EstadoPedido;

// Se a classe tiver um nome de uma palavra reservada do MySQL ocorrerá um erro
// sendo necessária a indicação pela anotação @Table(name="nome da tabela")

@Entity public class Pedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;	
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern= "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
	private Instant momento;
	
	private Integer estadoPedido;
	
	@ManyToOne @JoinColumn(name = "idcliente") private Usuario cliente;

	@OneToMany (mappedBy="id.pedido") private Set<ItensPedido> itens = new HashSet<>();
	
	@OneToOne(mappedBy="pedido", cascade=CascadeType.ALL) private Pagamento pagamento;
	
	public Pedido() {}
	
	public Pedido(Long id, Instant momento,EstadoPedido estadoPedido, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setEstadoPedido(estadoPedido);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public EstadoPedido getEstadoPedido() {
		return EstadoPedido.estadoPed(estadoPedido);
	}

	public void setEstadoPedido(EstadoPedido estadoPedido) {
		
		if(estadoPedido != null) {
			this.estadoPedido = estadoPedido.getCodigo();			
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Set<ItensPedido> getItens() {
		return itens;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
