import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	static Scanner sc;
	static ArrayList<Item> listaDeItens;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		listaDeItens = new ArrayList<Item>();
		int opcao = 0;
		
		String msgInicial = "Bem vindo à Livraria Sofia";
		
		System.out.println(msgInicial);
		System.out.println("----------------------------");
		
		do {
			System.out.println("Selecione uma opção:");
			System.out.println("1 - Cadastrar item");
			System.out.println("2 - Mostrar valores");
			System.out.println("0 - Encerrar");
			
			opcao = sc.nextInt();		
			System.out.println("----------------------------");
			
			if (opcao == 1) {			
				listaDeItens.add(cadastrarItem());			
			}
			else if(opcao == 2){
				mostrarValores();
			}
			else
				System.out.println("Opção inválida");
			
		} while (opcao != 0);		
		
	}
	
	static void mostrarValores(){
		for (Item item : listaDeItens) {
			System.out.println("Item: " + item.getTitulo());
			System.out.println("Preço: R$" + item.getPreco());			
			System.out.println("Preço com desconto: R$" + String.valueOf(calculaDesconto(item.getPreco(), item.getCodigo())));
			System.out.println("----------------------------");
		}
	}
	
	static double calculaDesconto(double preco, String cod){		
		if (cod.equals("1")) {			
			return (preco * 0.8);
		}
		else if (cod.equals("2")) {
			return (preco * 0.85);
		}
		else if (cod.equals("3")) {
			return (preco * 0.9);
		}
		else		
			return preco;
	}

	static Item cadastrarItem(){
		
		System.out.println("-- Cadastrar item --");
		
		Item novoItem = new Item();
		
		System.out.println("Digite o código do item: ");
		novoItem.setCodigo(sc.next());
		
		System.out.println("Digite o titulo: ");
		novoItem.setTitulo(sc.next());

		System.out.println("Digite o autor: ");
		novoItem.setAutor(sc.next());
		
		System.out.println("Digite a descrição: ");
		novoItem.setDescricao(sc.next());
		
		System.out.println("Digite a quantidade: ");
		novoItem.setQuantidade(sc.nextInt());
		
		System.out.println("Digite o preço: ");
		novoItem.setPreco(sc.nextDouble());
		
		return novoItem; 
	}
}
