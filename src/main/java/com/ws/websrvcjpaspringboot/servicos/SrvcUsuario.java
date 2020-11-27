package com.ws.websrvcjpaspringboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ws.websrvcjpaspringboot.entidades.Usuario;
import com.ws.websrvcjpaspringboot.repositorios.RptrUsuario;

//@Component
//@Repository 
@Service public class SrvcUsuario {

	@Autowired private RptrUsuario rptrUsuario;
	
	public List<Usuario> pesquisar() {
		return rptrUsuario.findAll();
	}
	
	public Usuario pesquisarId(Long id) {
		Optional <Usuario> optUsuario = rptrUsuario.findById(id);
		return optUsuario.get();
	}
	
	public Usuario inserir(Usuario usuario) {
		return rptrUsuario.save(usuario);
	}
}
