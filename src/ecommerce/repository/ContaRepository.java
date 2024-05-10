package ecommerce.repository;

import ecommerce.model.Conta;
import ecommerce.model.Produto;

public interface ContaRepository {
	
	//CRUD da Conta
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void listarTodosProdutosCarrinho(int numero);
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	public void visualizar(Conta conta);
	
	//Métodos Bancários
	public void remover(int numero, Produto produto);
	public void adicionar(int numero, Produto produto);
	
}
