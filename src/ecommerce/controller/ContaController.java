package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Conta;
import ecommerce.model.Produto;
import ecommerce.repository.ContaRepository;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null)
			visualizar(conta);
		else
			System.out.println("\nA Conta número: " + numero + "não foi encontrada!");
		
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
			
		}
		
	}
	
	@Override
	public void listarTodosProdutosCarrinho(int numero) {
		
		for (Produto produto : buscarNaCollection(numero).getCarrinho()) {
			
			System.out.println("***************************************************************");
			System.out.println("ID: " + produto.getId());
			System.out.println("Descricao: " + produto.getDescricao());
			System.out.println("Preco: " + produto.getPreco());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Quantidade em estoque: " + produto.getQuantidadeItem());
			System.out.println("Categoria: " + produto.getCategoria());
			
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if (buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\nA Conta número: " + conta.getNumero() + " não foi emcontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\nA Conta número: " + numero + " foi deletada com sucesso!");
		} else
			System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
		
	}

	@Override
	public void remover(int numero, Produto produto) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			
			if (conta.getCarrinho().contains(produto) == true)
				conta.getCarrinho().remove(produto);
				System.out.println("\nO Produto: " + produto.getDescricao() + "foi removido do carrinho com sucesso!");
			
		}else
			System.out.println("\nA Conta Número: " + numero + "não foi encontrada!");
		
	}

	@Override
	public void adicionar(int numero, Produto produto) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			conta.getCarrinho().add(produto);
			System.out.println("\nO Produto: " + produto.getDescricao() + "foi adicionado ao carrinho com sucesso!");	
		}else
			System.out.println("\nA Conta Número: " + numero + "não foi encontrada!");
		
	}

	public int gerarNumero() {
		return ++ numero;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		
		return null;
	}
	
	@Override
	public void visualizar(Conta conta) {
		
		System.out.println("\n\n****************************************************************");
		System.out.println("Dados da Conta: ");
		
		System.out.println("Numero da conta: "+ conta.getNumero());
		System.out.println("Nome da conta: "+ conta.getNome());
		
		System.out.println("Dados do Carrinho: ");
		
		for (Produto produto : conta.getCarrinho()) {
			
			System.out.println("***************************************************************");
			System.out.println("ID: " + produto.getId());
			System.out.println("Descricao: " + produto.getDescricao());
			System.out.println("Preco: " + produto.getPreco());
			System.out.println("Marca: " + produto.getMarca());
			System.out.println("Quantidade em estoque: " + produto.getQuantidadeItem());
			System.out.println("Categoria: " + produto.getCategoria());
			
		}

	}

}