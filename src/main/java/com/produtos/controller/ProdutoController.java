package com.produtos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.model.Produto;
import com.produtos.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos") //titulo da api
@CrossOrigin(origins="*") //qq dominio pode acessar essa api
public class ProdutoController {
	
	@Autowired
	ProdutoRepository produtoRepository;

	
	@GetMapping("/produtos") //lista todos
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto>listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}") //lista um produto por id
	@ApiOperation(value="Retorna um produto")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produto") //salvando Produto
	@ApiOperation(value="Salva um produto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);		
	}
	
	@DeleteMapping("/produto") //deletando produto
	@ApiOperation(value="Deleta um produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);		
	}
	
	@PutMapping("/produto") //atualizar produto
	@ApiOperation(value="Atualiza um produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
