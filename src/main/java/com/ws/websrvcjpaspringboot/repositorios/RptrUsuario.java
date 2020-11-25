package com.ws.websrvcjpaspringboot.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ws.websrvcjpaspringboot.entidades.Usuario;

// classe herda registro da superclasse, não é necessária anotação @Repository
public interface RptrUsuario extends JpaRepository<Usuario, Long>{
	
}
