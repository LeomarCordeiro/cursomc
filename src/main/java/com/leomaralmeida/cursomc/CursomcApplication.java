package com.leomaralmeida.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leomaralmeida.cursomc.domain.Categoria;
import com.leomaralmeida.cursomc.domain.Cidade;
import com.leomaralmeida.cursomc.domain.Cliente;
import com.leomaralmeida.cursomc.domain.Endereco;
import com.leomaralmeida.cursomc.domain.Estado;
import com.leomaralmeida.cursomc.domain.Produto;
import com.leomaralmeida.cursomc.domain.enums.TipoCliente;
import com.leomaralmeida.cursomc.repositories.CategoriaRepository;
import com.leomaralmeida.cursomc.repositories.CidadeRepository;
import com.leomaralmeida.cursomc.repositories.ClienteRepository;
import com.leomaralmeida.cursomc.repositories.EnderecoRepository;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	
	
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
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));

		Endereco ed1 = new Endereco(null, "Rua das Flores", "22B", "Casa", "Jardim Tomé", "87144-000", cli1, c1); 
		Endereco ed2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2); 
		
		
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3)); 
		estadoRepository.saveAll(Arrays.asList(est1, est2)); 
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3)); 
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(ed1, ed2));
		
		
		
	}

}

