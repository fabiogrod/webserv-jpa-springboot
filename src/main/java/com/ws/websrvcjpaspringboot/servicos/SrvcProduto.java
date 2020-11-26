package com.ws.websrvcjpaspringboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ws.websrvcjpaspringboot.entidades.Produto;
import com.ws.websrvcjpaspringboot.repositorios.RptrProduto;

//@Component
//@Repository 
@Service public class SrvcProduto {

	@Autowired private RptrProduto rptrProduto;
	
	public List<Produto> pesquisar() {
		return rptrProduto.findAll();
	}
	
	public Produto pesquisarId(Long id) {
		Optional <Produto> optProduto = rptrProduto.findById(id);
		return optProduto.get();
	}
}
