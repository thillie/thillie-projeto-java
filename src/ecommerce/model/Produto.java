package ecommerce.model;

import ecommerce.controller.ProdutoController;

public class Produto {
	
	private int id;
	private String descricao;
	private double preco;
	private String marca;
	private int quantidadeItem;
	private String categoria;
	
	public Produto(int id, String descricao, double preco, String marca, int quantidadeItem, String categoria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.marca = marca;
		this.quantidadeItem = quantidadeItem;
		this.categoria = categoria;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(int quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void visualizar() {
		
		System.out.println("***************************************************************");
		System.out.println("ID: " + this.id);
		System.out.println("Descricao: " + this.descricao);
		System.out.println("Preco: " + this.preco);
		System.out.println("Marca: " + this.marca);
		System.out.println("Quantidade em estoque: " + this.quantidadeItem);
		System.out.println("Categoria: " + this.categoria);

	}
	
}
