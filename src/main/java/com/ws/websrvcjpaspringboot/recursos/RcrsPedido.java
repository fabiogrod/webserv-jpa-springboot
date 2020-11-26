package com.ws.websrvcjpaspringboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.websrvcjpaspringboot.entidades.Pedido;
import com.ws.websrvcjpaspringboot.servicos.SrvcPedido;

@RestController @RequestMapping(value = "/pedidos") public class RcrsPedido {

	@Autowired private SrvcPedido srvcPedido;
	
	@GetMapping public ResponseEntity< List<Pedido> > pesquisar() {
		//Pedido usr = new Pedido(1L, "Thais Pinheiro", "thais@gmail.com", "99887-7665", "1234");
		
		List<Pedido> lista = srvcPedido.pesquisar();		
		return ResponseEntity.ok().body(lista);		
	}
	
	@GetMapping(value="/{id}") public ResponseEntity<Pedido> pesquisarId(@PathVariable Long id) {
		Pedido pedido = srvcPedido.pesquisarId(id);
		return ResponseEntity.ok().body(pedido);
	}
}
