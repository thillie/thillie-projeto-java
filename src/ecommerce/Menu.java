package ecommerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.ContaController;
import ecommerce.controller.ProdutoController;
import ecommerce.model.Conta;
import ecommerce.model.Produto;
import ecommerce.util.Cores;

public class Menu {
	
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		
		ContaController contas = new ContaController();
		ProdutoController produtos = new ProdutoController();
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino, valor;
		String titular;
		float saldo, limite;
		
		System.out.println("\nCriar Contas\n");
		
		Produto pp1 = new Produto(
				1,
				"Notebook Gamer Acer Predator Helios Neo PHN16-71-74UE, Intel Core i7 de 13ª Geração, 16GB de RAM, 1TB SSD, NVIDIA GeForce RTX 4060 e Tela de 16” WUXGA 165Hz", 
				7899.25, 
				"Acer", 
				15, 
				"Notebooks"
		);
		produtos.cadastrar(pp1);
		
		Produto pp2 = new Produto(
				2,
				"Placa de Vídeo RX7600 ASUS Dual Radeon, 8GB GDDR6 - 90YV0IH2-M0NA00", 
				1598.99, 
				"Asus", 
				5, 
				"Placas de Video"
		);
		produtos.cadastrar(pp2);
		
		Produto pp3 = new Produto(
				3,
				"Monitor Gamer KBM! GAMING MG320 27' Led, Curvo, 180Hz, Full Hd, 1ms, Adaptive Sync, Hdmi/Displayport, Ajuste De Ângulo - KGMG32027PT", 
				849.99, 
				"KBM!", 
				7, 
				"Monitores"
		);
		produtos.cadastrar(pp3);
		
		while (true) {
			
			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND
					+ "***************************************************************");
			System.out.println();
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("                     Loja Touch                       ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("                                                      ");
			System.out.println("            1 - Criar Conta                           ");
			System.out.println("            2 - Listar todas as Contas                ");
			System.out.println("            3 - Buscar Conta por Número               ");
			System.out.println("            4 - Atualizar Dados da Conta              ");
			System.out.println("            5 - Apagar Conta                          ");
			System.out.println("            6 - Remover Produto                       ");
			System.out.println("            7 - Adicionar Produto                     ");
			System.out.println("            8 - Sair                                  ");
			System.out.println("                                                      ");
			System.out.println("******************************************************");
			System.out.println("Entre com a opção desejada:                           ");
			System.out.println("                                                      "+ Cores.TEXT_RESET);
			
			try {
			
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if (opcao == 8) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);	
			}
			
			switch (opcao) {
			case 1: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar Conta \n\n");
				
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();
				
				contas.cadastrar(new Conta(contas.gerarNumero(), titular, new ArrayList<Produto>()));
				
				keyPress();
				break;
			}
			
			case 2: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as Contas\n\n");
				contas.listarTodas();
				
				keyPress();
				break;
			}
			
			case 3: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			}
			
			case 4: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					contas.atualizar(new Conta(numero, titular, contas.buscarNaCollection(numero).getCarrinho()));
					
				}else {
					System.out.println("A Conta não foi encontrada!");
						
				}
					
				keyPress();
				break;
			}
				
			case 5: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a Conta\n\n");
				
				System.out.println("Digite o número da Conta: ");
				numero = leia.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			}
			
			case 6: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Remover\n\n");
				
				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();
				
				do {
					
					contas.listarTodosProdutosCarrinho(numero);
					
					System.out.println("\n\nDigite o ID do produto que deseja remover do carrinho: ");
					valor = leia.nextInt();
					
				}while(valor <= 0);
				
				contas.remover(numero, produtos.buscaProdutoPorId((valor)));
				
				keyPress();
				break;
			}
			
			case 7: {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Adicionar\n\n");
				
				System.out.println("Digite o Número da Conta: ");
				numero = leia.nextInt();
						
				do {
					
					System.out.println("Produtos disponíveis na loja\n\n");
					produtos.listarTodos();
					
					System.out.println("\n\nDigite o ID do produto que deseja adicionar ao carrinho: ");
					valor = leia.nextInt();
				}while(valor <= 0);
				
				contas.adicionar(numero, produtos.buscaProdutoPorId(valor));
				
				keyPress();
				break;
			}
			
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida\n" + Cores.TEXT_RESET);
				
				keyPress();
				break;
				}}
			}
			
			public static void sobre() {
				System.out.println("\n********************************************************");
				System.out.println("Projeto Desenvolvido por: Thilliê");
				System.out.println("Generation Brasil - thillie.souza@genstudents.org");
				System.out.println("https://github.com/thillie");
				System.out.println("********************************************************");
			} 
			
			public static void keyPress() {
				
				try {
					
					System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
					System.in.read();
			
				} catch (IOException e) {
					
					System.out.println("Você pressionou uma tecla diferente de enter!");
				
				}
			}

}