package com.ws.websrvcjpaspringboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ws.websrvcjpaspringboot.entidades.Categoria;
import com.ws.websrvcjpaspringboot.entidades.ItensPedido;
import com.ws.websrvcjpaspringboot.entidades.Pedido;
import com.ws.websrvcjpaspringboot.entidades.Produto;
import com.ws.websrvcjpaspringboot.entidades.Usuario;
import com.ws.websrvcjpaspringboot.entidades.enums.EstadoPedido;
import com.ws.websrvcjpaspringboot.repositorios.RptrCategoria;
import com.ws.websrvcjpaspringboot.repositorios.RptrItensPedido;
import com.ws.websrvcjpaspringboot.repositorios.RptrPedido;
import com.ws.websrvcjpaspringboot.repositorios.RptrProduto;
import com.ws.websrvcjpaspringboot.repositorios.RptrUsuario;

@Configuration @Profile("test") public class TesteConfig implements CommandLineRunner {

	@Autowired private RptrUsuario repositorioUsuario;
	@Autowired private RptrPedido repositorioPedido;
	@Autowired private RptrCategoria repositorioCategoria;
	@Autowired private RptrProduto repositorioProduto;
	@Autowired private RptrItensPedido repositorioItensPedido;

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
		
		Produto prod1 = new Produto( null, "O Senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto prod2 = new Produto( null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto prod3 = new Produto( null, "Macook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto prod4 = new Produto( null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto prod5 = new Produto( null, "Rails para leigos", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		repositorioProduto.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		prod1.getCategorias().add(cat2);
		prod2.getCategorias().add(cat1);
		prod2.getCategorias().add(cat3);
		prod3.getCategorias().add(cat3);
		prod4.getCategorias().add(cat3);
		prod5.getCategorias().add(cat2);
		
		repositorioProduto.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));
		
		ItensPedido itensp1 = new ItensPedido(ped1, prod1, 2, prod1.getPreco());
		ItensPedido itensp2 = new ItensPedido(ped1, prod3, 1, prod4.getPreco());
		ItensPedido itensp3 = new ItensPedido(ped2, prod3, 2, prod1.getPreco());
		ItensPedido itensp4 = new ItensPedido(ped3, prod5, 2, prod5.getPreco());
		
		repositorioItensPedido.saveAll(Arrays.asList(itensp1, itensp2, itensp3, itensp4));
	}
}
