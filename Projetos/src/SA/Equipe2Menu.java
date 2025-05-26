package SA;
import java.util.*;
public class Equipe2Menu {

	static ArrayList<String> nomeSetor = new ArrayList<>();
	public static String op1 (Scanner entrada) {
		
		System.out.println("Quantos Setores vão existir?");
		int Qtsetores = entrada.nextInt();
		System.out.println("Nome do setor(es) ");
		String nome = "";
		for(int e = 0; e <= Qtsetores; e++) {
			nome = entrada.nextLine();
			nomeSetor.add(nome);
		}
		for(int j = 1; j <= Qtsetores; j++) {
			System.out.println("Quantas máquinas vão ter no setor " + nomeSetor.get(j) + "?");
			int maquinasPSetor = entrada.nextInt();
			}
				
		
		return "Setor(es) Registrado!!";
	}
	public static String op2 (Scanner entrada) {
		System.out.println("Registre o numero de indentificação da máquina: ");
		int numM = entrada.nextInt();
		System.out.println("Quantos alicates a máquina produz semanalmente?");
		int Qtalicates = entrada.nextInt();
		System.out.println("Quantos martelos a máquina produz semanalmente?");	
		int Qtmartelos = entrada.nextInt();
		System.out.println("Quantas chaves de fenda a máquina produz semanalmente?");
		int Qtchavesdefenda = entrada.nextInt();
		
		
		
		
		System.out.println("Qual setor você quer registrar essa máquina? ");
		//nomeSetor 
		
		 
		
	}
	public static int op3 (Scanner entrada) {
		System.out.println("Em que setor está a máquina que você deseja saber a produção semanal?");
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bem-vindo!!");
		int opcao;
		do{
			System.out.println("-----MENU-----");
			System.out.println("1 - Definir setores e máquinas por setor");
			System.out.println("2 - Registrar  Máquina");
			System.out.println("3 - Conferir Produção por Máquina");
			System.out.println("4 - Conferir produção por setor");
			System.out.println("5 - Monitorar Produção Máquinas por Setor");
			System.out.println("6 - Monitorar por Tipo de Ferramenta");
			System.out.println("7 - Sair");
			opcao = entrada.nextInt();
			switch (opcao) {
				case 1: System.out.println(op1(entrada));
			}
		}while(opcao != 7);
	
		
	
		
	
	}

}
