package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Conta;
import ecommerce.model.Produto;
import ecommerce.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {
	
	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	
	@Override
	public void listarTodos() {
		for (var produto : listaProdutos) {
			produto.visualizar();
			
		}
		
	}
	
	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto: " + produto.getDescricao() + " foi criada com sucesso!");
	}
	
	@Override
	public Produto buscaProdutoPorId(int id) {
		
		for (Produto produto : listaProdutos) {
			
			if(id == produto.getId()) {
				return produto;
			}
			
		}
		
		return null;
	}
	
}
