package com.ws.websrvcjpaspringboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.websrvcjpaspringboot.entidades.Produto;
import com.ws.websrvcjpaspringboot.servicos.SrvcProduto;

@RestController @RequestMapping(value = "/produtos") public class RcrsProduto {

	@Autowired private SrvcProduto srvcProduto;
	
	@GetMapping public ResponseEntity< List<Produto> > pesquisar() {
		//Produto usr = new Produto(1L, "Thais Pinheiro", "thais@gmail.com", "99887-7665", "1234");
		
		List<Produto> lista = srvcProduto.pesquisar();		
		return ResponseEntity.ok().body(lista);		
	}
	
	@GetMapping(value="/{id}") public ResponseEntity<Produto> pesquisarId(@PathVariable Long id) {
		Produto produto = srvcProduto.pesquisarId(id);
		return ResponseEntity.ok().body(produto);
	}
}
