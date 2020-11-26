package com.ws.websrvcjpaspringboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ws.websrvcjpaspringboot.entidades.Categoria;
import com.ws.websrvcjpaspringboot.repositorios.RptrCategoria;

//@Component
//@Repository 
@Service public class SrvcCategoria {

	@Autowired private RptrCategoria rptrCategoria;
	
	public List<Categoria> pesquisar() {
		return rptrCategoria.findAll();
	}
	
	public Categoria pesquisarId(Long id) {
		Optional <Categoria> optCategoria = rptrCategoria.findById(id);
		return optCategoria.get();
	}
}
