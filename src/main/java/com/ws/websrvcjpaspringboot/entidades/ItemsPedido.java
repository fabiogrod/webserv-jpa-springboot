package com.ws.websrvcjpaspringboot.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ws.websrvcjpaspringboot.entidades.cp.ItemsPedidoCP;

@Entity @Table(name="pedido_items")
public class ItemsPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId private ItemsPedidoCP id;
	
	private Integer qtde;
	private Double preco;
	
	public ItemsPedido() {}

	public ItemsPedido(Pedido pedido, Produto produto,Integer qtde, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.qtde = qtde;
		this.preco = preco;
	}
	
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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
		ItemsPedido other = (ItemsPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
