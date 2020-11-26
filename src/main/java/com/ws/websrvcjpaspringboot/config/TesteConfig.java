package com.ws.websrvcjpaspringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ws.websrvcjpaspringboot.entidades.Categoria;
import com.ws.websrvcjpaspringboot.entidades.Pedido;
import com.ws.websrvcjpaspringboot.entidades.Usuario;
import com.ws.websrvcjpaspringboot.entidades.enums.EstadoPedido;
import com.ws.websrvcjpaspringboot.repositorios.RptrCategoria;
import com.ws.websrvcjpaspringboot.repositorios.RptrPedido;
import com.ws.websrvcjpaspringboot.repositorios.RptrUsuario;

@Configuration @Profile("test") public class TesteConfig implements CommandLineRunner {

	@Autowired private RptrUsuario repositorioUsuario;
	@Autowired private RptrPedido repositorioPedido;
	@Autowired private RptrCategoria repositorioCategoria;

	@Override public void run(String... args) throws Exception {
		Usuario usr1 = new Usuario( null, "Jessica Serafina", "jessica@gmail.com", "999999999", "123456");
		Usuario usr2 = new Usuario( null, "Karina Abreu", "karina@gmail.com", "988888888", "123456");
		
		repositorioUsuario.saveAll(Arrays.asList(usr1, usr2));
		
		Pedido ped1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), EstadoPedido.PAGO, usr1);
		Pedido ped2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), EstadoPedido.AGUARDANDO_PAGAMENTO, usr2);
		Pedido ped3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), EstadoPedido.AGUARDANDO_PAGAMENTO, usr1);
		
		repositorioPedido.saveAll(Arrays.asList(ped1, ped2, ped3));
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		
		repositorioCategoria.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
}
