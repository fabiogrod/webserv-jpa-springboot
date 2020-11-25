package com.ws.websrvcjpaspringboot.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ws.websrvcjpaspringboot.entidades.Usuario;

@RestController @RequestMapping(value = "/usuarios") public class RecursosUsuario {

	@GetMapping public ResponseEntity<Usuario> pesquisar() {
		Usuario usr = new Usuario(1L, "Thais Pinheiro", "thais@gmail.com", "99887-7665", "1234");
		return ResponseEntity.ok().body(usr);		
	}
}
