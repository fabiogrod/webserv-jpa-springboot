package com.ws.websrvcjpaspringboot.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ws.websrvcjpaspringboot.entidades.Usuario;
import com.ws.websrvcjpaspringboot.repositorios.RptrUsuario;
import com.ws.websrvcjpaspringboot.servicos.excecoes.ExcecaoBD;
import com.ws.websrvcjpaspringboot.servicos.excecoes.ExcecaoRcrsNaoEncontrado;

//@Component
//@Repository 
@Service public class SrvcUsuario {

	@Autowired private RptrUsuario rptrUsuario;
	
	public List<Usuario> pesquisar() {
		return rptrUsuario.findAll();
	}
	
	public Usuario pesquisarId(Long id) {
		Optional <Usuario> optUsuario = rptrUsuario.findById(id);
		return optUsuario.orElseThrow(() -> new ExcecaoRcrsNaoEncontrado(id));
	}
	
	public Usuario inserir(Usuario usuario) {
		return rptrUsuario.save(usuario);
	}
	
	public void deletar(Long id) {
		try {			
			rptrUsuario.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ExcecaoRcrsNaoEncontrado(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new ExcecaoBD(e.getMessage());
		}		
//		catch(RuntimeException e) {
//			e.printStackTrace();
//		}
	}
	
	public Usuario atualizar(Long id, Usuario usuario) {
		Usuario entidade = rptrUsuario.getOne(id);
		atualizarDados(entidade, usuario);
		return rptrUsuario.save(entidade);
	}

	private void atualizarDados(Usuario entidade, Usuario usuario) {		
		entidade.setNome(usuario.getNome());
		entidade.setEmail(usuario.getEmail());
		entidade.setFone(usuario.getFone());
	}
}
