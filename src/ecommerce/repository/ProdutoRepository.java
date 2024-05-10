package ecommerce.repository;

import ecommerce.model.Produto;

public interface ProdutoRepository {
	
	public void listarTodos();
	public void cadastrar(Produto produto);
	public Produto buscaProdutoPorId(int id);
	
}
