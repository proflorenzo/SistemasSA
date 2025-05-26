package SA;
import java.util.*;
public class Equipe1 {
	static ArrayList<Integer> produçao = new ArrayList<>();
	static ArrayList<Integer> setorProduçao = new ArrayList<>();
	static ArrayList<String> diasSemana = new ArrayList<>(Arrays.asList("Segunda: ", "Terça: ","Quarta: ","Quinta: ","Sexta: "));
	static ArrayList<String> nomeSetor = new ArrayList<>();
	
	//variaveis
	static int Setores = 0;
	static int maquinas = 0;
	static int [][] matrix;
	static int produtoSetores = 0;
	static int valor = 0;
	static int valor1 = 0;
	static int nomear = 0;
	public static void informar(Scanner entrada) {
		
		System.out.println("Digite o numero de setores: ");
		Setores = entrada.nextInt();
		entrada.nextLine();
		while(nomear < Setores) {
			System.out.println("Digite qual peça você quer que o Setor fabrique: ");
			nomeSetor.add(entrada.nextLine());
			
			nomear += 1;
		}
		
		System.out.println("Digite o numero de maquinas por setor: ");
		maquinas = entrada.nextInt();
		produtoSetores = 0;
		valor = 0;
		valor1 = 0;
		matrix = new int[maquinas*Setores][5]; 
		
		for(int i = 0; i < Setores;i++) {
			System.out.println("Setor "+(i+1)+" " +nomeSetor.get(i));
			System.out.println(" ");
			for(int j = 0;j < maquinas; j++) {
				System.out.println("Produção maquina "+(j+1));
				for(int a = 0; a < 5;a++) {
					System.out.print(diasSemana.get(a));
					int produto = entrada.nextInt();
					valor += produto;
					matrix[valor1][a] = produto; 
				}
				valor1 = valor1+1;
				produçao.add(valor);
				
				produtoSetores += valor;
				valor = 0;
			}
			System.out.println();
			setorProduçao.add(produtoSetores);
			produtoSetores = 0;
		}
	}
	
	public static void executar(int maquinas, int Setores, int [][]matrix, Scanner entrada) {
		int d = 0;
		int opcao1 = 0;
		System.out.println("Selecione qual produção voce quer ver");
		System.out.println("1-Por maquinas");
		System.out.println("2-Por setor");
		System.out.println("3-Por dia");
		System.out.println("4-Voltar");
		
		opcao1 = entrada.nextInt();
		switch(opcao1) {
		
		//por maquina
		case 1: for(int h = 0; h < nomeSetor.size();h++) {
			System.out.println("Setor "+ nomeSetor.get(h));
			for(int t = 0; t < maquinas;t++) {
		
			System.out.println("Maquina "+(d+1)+" produção " + produçao.get(d));
			d++;
		}
	} break;
		
		//por setor
		case 2: for(int n = 0; n < setorProduçao.size();n++) {
			System.out.println("Produção do Setor "+(n+1) + " " +nomeSetor.get(n) );
			System.out.println("Produção: "+(setorProduçao.get(n)));
		} break;
		
		//por dia
		case 3: for (int b = 0; b < (maquinas*Setores);b++) {
			System.out.println("Maquina " +(b+1));
			for(int c = 0; c < 5;c++) {
				System.out.println("Produção " + diasSemana.get(c)+ matrix[b][c]);
				
			}
			
		} break;
		
		case 4:break;
		default: System.out.println("Opcão inválida"); break;
	}
		
	}
	public static void main(String [] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		do {
			System.out.println("-----Menu-----");
			System.out.println("1-Informar dados");
			System.out.println("2-Analizar dados");
			System.out.println("3-Sair");
			opcao = entrada.nextInt();
			switch (opcao){
			case 1: informar(entrada);break;
			case 2: executar(maquinas, Setores, matrix, entrada); break;
			case 3: System.out.println("Saindo..."); break;
			default: System.out.println("Opcão inválida"); break;
			}
		}while(opcao != 3);
		
	}
	
}
