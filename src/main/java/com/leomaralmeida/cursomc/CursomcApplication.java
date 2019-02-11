package com.leomaralmeida.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leomaralmeida.cursomc.domain.Categoria;
import com.leomaralmeida.cursomc.domain.Cidade;
import com.leomaralmeida.cursomc.domain.Estado;
import com.leomaralmeida.cursomc.domain.Produto;
import com.leomaralmeida.cursomc.repositories.CategoriaRepository;
import com.leomaralmeida.cursomc.repositories.CidadeRepository;
import com.leomaralmeida.cursomc.repositories.EstadoRepository;
import com.leomaralmeida.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	@Autowired
	private ProdutoRepository  produtoRepository; 
	
	@Autowired
	private CidadeRepository cidadeRepository; 
	
	@Autowired
	private EstadoRepository estadoRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório"); 
		
		Produto p1 = new Produto(null, "Computador", 1500.00); 
		Produto p2 = new Produto(null, "Impressora", 800.00); 
		Produto p3 = new Produto(null, "Mouse", 80.00); 
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2)); 
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p1.getCategorias().addAll(Arrays.asList(cat2));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1); 
		Cidade c2 = new Cidade(null, "São Paulo", est2); 
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3)); 
		estadoRepository.saveAll(Arrays.asList(est1, est2)); 
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3)); 
		
		
	}

}

