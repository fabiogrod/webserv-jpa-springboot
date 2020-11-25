package com.ws.websrvcjpaspringboot.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.websrvcjpaspringboot.entidades.Usuario;
import com.ws.websrvcjpaspringboot.servicos.SrvcUsuario;

@RestController @RequestMapping(value = "/usuarios") public class RcrsUsuario {

	@Autowired private SrvcUsuario srvcUsuario;
	
	@GetMapping public ResponseEntity< List<Usuario> > pesquisar() {
		//Usuario usr = new Usuario(1L, "Thais Pinheiro", "thais@gmail.com", "99887-7665", "1234");
		
		List<Usuario> lista = srvcUsuario.pesquisar();		
		return ResponseEntity.ok().body(lista);		
	}
	
	@GetMapping(value="/{id}") public ResponseEntity<Usuario> pesquisarId(@PathVariable Long id) {
		Usuario usuario = srvcUsuario.pesquisarId(id);
		return ResponseEntity.ok().body(usuario);
	}
}
