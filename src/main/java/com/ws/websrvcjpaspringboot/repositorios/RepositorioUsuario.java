package com.ws.websrvcjpaspringboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.websrvcjpaspringboot.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
	
}
