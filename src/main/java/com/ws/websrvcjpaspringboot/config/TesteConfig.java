package com.ws.websrvcjpaspringboot.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ws.websrvcjpaspringboot.entidades.Usuario;
import com.ws.websrvcjpaspringboot.repositorios.RptrUsuario;

@Configuration @Profile("test") public class TesteConfig implements CommandLineRunner {

	@Autowired private RptrUsuario repositorioUsuario;

	@Override public void run(String... args) throws Exception {
		Usuario usr1 = new Usuario( null, "Jessica Serafina", "jessica@gmail.com", "999999999", "123456");
		Usuario usr2 = new Usuario( null, "Karina Abreu", "karina@gmail.com", "988888888", "123456");
		
		repositorioUsuario.saveAll(Arrays.asList(usr1, usr2));
	}
}
