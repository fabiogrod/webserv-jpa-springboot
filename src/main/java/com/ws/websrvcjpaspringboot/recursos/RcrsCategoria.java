package com.ws.websrvcjpaspringboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.websrvcjpaspringboot.entidades.Categoria;
import com.ws.websrvcjpaspringboot.servicos.SrvcCategoria;

@RestController @RequestMapping(value = "/categorias") public class RcrsCategoria {

	@Autowired private SrvcCategoria srvcCategoria;
	
	@GetMapping public ResponseEntity< List<Categoria> > pesquisar() {
		//Categoria usr = new Categoria(1L, "Thais Pinheiro", "thais@gmail.com", "99887-7665", "1234");
		
		List<Categoria> lista = srvcCategoria.pesquisar();		
		return ResponseEntity.ok().body(lista);		
	}
	
	@GetMapping(value="/{id}") public ResponseEntity<Categoria> pesquisarId(@PathVariable Long id) {
		Categoria categoria = srvcCategoria.pesquisarId(id);
		return ResponseEntity.ok().body(categoria);
	}
}
