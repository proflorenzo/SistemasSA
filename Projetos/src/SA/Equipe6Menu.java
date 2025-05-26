package SA;
import java.util.*;
public class Equipe6Menu {
	public static void main(String[] args){
		Equipe6 Classe = new Equipe6();
		Scanner  entrada = new Scanner(System.in);
		int opcao =0;
		do {
		System.out.println("\n ---- MENU ---- ");
		System.out.println("1- Cadastrar Setor e Maquina: ");
		System.out.println("2- Cadastrar Produção: " );
		System.out.println("3- Mostrar Setores e Maquinas cadastrados: ");
		System.out.println("4- Gerar relatório ");
		System.out.println("5- Gerar média: ");
		System.out.println("6- Buscar por setor: ");
		System.out.println("7- SAIR ");
		System.out.println("Escolha uma opção: ");
		
		 opcao = entrada.nextInt();
		 entrada.nextLine();
		 
		switch(opcao) {
		case 1: Classe.cadastro(); break;
		
		case 2:	Classe.regispdc(entrada); break;
		
		case 3: Classe.mostrarMqnSet(); break;
		
		case 4: Classe.imprimirSmns();	break;
		
		case 5: Classe.geral();	break;
		
		case 6: Classe.buscarSetor(); break;
		
		case 7: System.out.println("Voce saiu "); System.exit(1);
		
		default: System.out.println("Escolha uma Opção correta "); break;
		}
	}while(opcao != 7);
		entrada.close();
	}
}
	
