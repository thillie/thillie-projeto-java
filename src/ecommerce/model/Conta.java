package ecommerce.model;

import java.util.ArrayList;

public class Conta {
	
	private int numero;
	private String nome;
	private ArrayList<Produto> carrinho = new ArrayList<Produto>();
	
	public Conta(int numero, String nome, ArrayList<Produto> carrinho) {
		super();
		this.numero = numero;
		this.nome = nome;
		this.carrinho = carrinho;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Produto> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(ArrayList<Produto> carrinho) {
		this.carrinho = carrinho;
	}
	
	public boolean remover(Produto produto) {
		
		if (!this.carrinho.contains(produto)) {
			System.out.println("\n O produto nao existe no seu carrinho!");
			return false;
		}
		
		this.carrinho.remove(produto);
		return true;
	}
	
	public void adicionar(Produto produto) {
		
		this.carrinho.add(produto);
	}
	
	public void visualizar() {
		
		System.out.println("\n\n****************************************************************");
		System.out.println("Dados da Conta: ");
		
		System.out.println("Numero da conta: "+ this.numero);
		System.out.println("Nome da conta: "+ this.nome);
		
		System.out.println("Dados do Carrinho: ");
		
		for (Produto produto : this.carrinho) {
			
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
