package com.ws.websrvcjpaspringboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ws.websrvcjpaspringboot.entidades.Pedido;
import com.ws.websrvcjpaspringboot.repositorios.RptrPedido;

//@Component
//@Repository 
@Service public class SrvcPedido {

	@Autowired private RptrPedido rptrPedido;
	
	public List<Pedido> pesquisar() {
		return rptrPedido.findAll();
	}
	
	public Pedido pesquisarId(Long id) {
		Optional <Pedido> optPedido = rptrPedido.findById(id);
		return optPedido.get();
	}
}
