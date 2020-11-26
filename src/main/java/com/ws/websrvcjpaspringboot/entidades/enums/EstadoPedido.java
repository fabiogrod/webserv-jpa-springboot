package com.ws.websrvcjpaspringboot.entidades.enums;

public enum EstadoPedido {
	
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private int codigo;
	
	private EstadoPedido(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static EstadoPedido estadoPed (int codigo) {
		for (EstadoPedido estado : EstadoPedido.values()) {
			if (estado.getCodigo() == codigo)
			{
				return estado;
			}			
		}
		throw new IllegalArgumentException("Código inválido de estado de pedido");
	}
}
