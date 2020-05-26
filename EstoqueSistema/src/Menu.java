import java.util.Scanner;


public class Menu {
	static int op;


	public static void main(String[] args) {
		
		Estoque estoque = new Estoque();
		
		while (op != 9) {
			System.out.println("");
			System.out.println("|-----------------MENU PRINCIPAL------------------|");
		    System.out.println("|1: Cadastrar produto                             |");
		    System.out.println("|2: Alterar produto                               |");
		    System.out.println("|3: Excluir produto                               |");
		    System.out.println("|4: Aumentar estoque                              |");
		    System.out.println("|5: Remover estoque                               |");
		    System.out.println("|6: Listar estoque                                |");
		    System.out.println("|7: Fluxo de estoque                              |");
		    System.out.println("|8: Histórico do produto                          |");
		    System.out.println("|9: Encerrar atividade                            |");
		    System.out.println("--------------------------------------------------");
		    System.out.println("");
		    System.out.println("Selecione a opção desejada: ");
		 
		    Scanner sc0 = new Scanner(System.in);
		    op = sc0.nextInt();
		 
		    switch (op) {
		 
		    	case 1: 
		    		System.out.println("");
		    		System.out.println("Nome do produto: ");
		    		String nomeProduto = sc0.next();
		    		estoque.cadastrarProduto(nomeProduto, 0);
		    		break;
		
		    	case 2:
		    		System.out.println("");
		    		System.out.println("Nome do produto que deseja alterar: ");
		    		String antigoProduto = sc0.next();
		    		System.out.println("");
		    		System.out.println("Novo nome do produto: ");
		    		String novoProduto = sc0.next();
		    			estoque.alterarProduto(antigoProduto, novoProduto);	
		    		break;
		
		    	case 3: 
		    		System.out.println("");
		    		System.out.println("Nome do produto que deseja excluir: ");
		    		String excluiProduto = sc0.next();
		    		estoque.excluirProduto(excluiProduto);
		    		break;
		    		
		    	case 4:
		    		System.out.println("");
		    		System.out.println("Nome do produto que deseja aumentar o estoque: ");
		    		String aumentaProduto = sc0.next();
		    		System.out.println("");
		    		System.out.println("Quantidade do produto que deseja adicionar: ");
		    		int qtdAddProduto = sc0.nextInt();
		    		estoque.aumentarEstoque(aumentaProduto, qtdAddProduto);
		    		break;
		    		
		    	case 5:
		    		System.out.println("");
		    		System.out.println("Nome do produto que deseja reduzir o estoque: ");
		    		String diminuiProduto = sc0.next();
		    		System.out.println("");
		    		System.out.println("Quantidade do produto que deseja remover: ");
		    		int qtdRemProduto = sc0.nextInt();
		    		estoque.diminuirEstoque(diminuiProduto, qtdRemProduto);
		    		break;		    		
			 
		    	case 6:
		    		estoque.listarProdutos();
		    		break;
		    		
		    	case 7:
		    		estoque.fluxoEstoque();
		    		break;
		    		
		    	case 8:
		    		System.out.println("");
		    		System.out.println("Nome do produto: ");
		    		String fluxoProduto = sc0.next();
			    	estoque.historicoProduto(fluxoProduto);
		    		break;
		    		
		    	case 9:
		    		sc0.close();
		    		
		    				    }
		}
	}

}
