package SA;
import java.util.*;

public class Equipe7 {
	static ArrayList<Integer> qtdpecas = new ArrayList<>();
	static ArrayList<Integer> qtdMaquinas = new ArrayList<>();
	static ArrayList<Integer> maisProdutivo = new ArrayList<>();
	static ArrayList<Integer> peças1 = new ArrayList<>();
	static ArrayList<Integer> peças2 = new ArrayList<>();
	static ArrayList<Integer> peças3 = new ArrayList<>();
	static int quantidade;
	static int pecas;
	

	public static void cadastrar(Scanner scan){
		int maquinas;
		quantidade ++;
		System.out.println("Setor " + quantidade + "\n");
		System.out.println("Qual a quantidade de máquinas desse setor:");
		maquinas = scan.nextInt();
		if (maquinas <= 0) {
			System.out.println("Valor inváldio");
			quantidade --; 
			return;
		}
		qtdMaquinas.add(maquinas);
		
		int produção = 0;
		for (int j = 0 ; j < maquinas; j++){	// loop para cada máquina de cada setor
			
			System.out.println("Quantas peças a máquina " + (j + 1) + " produziu: ");
			pecas = scan.nextInt();
			if (pecas < 0) {
				System.out.println("Error");
				j--;
				continue;
			}
				qtdpecas.add(pecas);
				while(true) {
					System.out.println("Qual o tipo de peças produzidas na máquina "+ (j+1) + "? [1-Grande 2-Média 3-Pequena]");
					int op = scan.nextInt();
					switch (op) {
					case 1: 
						peças1.add(pecas);
						break;
					case 2: 
						peças2.add(pecas);
						break;
					case 3: 
						peças3.add(pecas);
						break;
					default:
						System.out.println("Opção inválida, tente novamente");
						continue;
					}	
					break;
			    }
            produção += pecas;
		}
		maisProdutivo.add(produção);
	}
	
	public static void relatórioGeral() {
	    if (quantidade == 0) {
	        System.out.println("Nenhum setor cadastrado");
	    } else {
	        int pecas = 0; // Variável para as peças produzidas em cada máquina
	        int maiorProdução = 0; // Variável para armazenar o maior nível de produção
	        List<Integer> setoresMaisProdutivos = new ArrayList<>(); // Lista para armazenar os setores mais produtivos
	        // Primeiro loop para encontrar o maior nível de produção
	        for (int i = 0; i < maisProdutivo.size(); i++) {
	            if (maisProdutivo.get(i) > maiorProdução) {
	                maiorProdução = maisProdutivo.get(i);
	                setoresMaisProdutivos.clear(); // Limpa a lista se um novo maior for encontrado
	                setoresMaisProdutivos.add(i); // Adiciona o setor atual
	            } else if (maisProdutivo.get(i) == maiorProdução) {
	                setoresMaisProdutivos.add(i); // Adiciona o setor atual em caso de empate
	            }
	        }
	        System.out.println("Maior produção: " + maiorProdução);
	        // Segundo loop para gerar o relatório de cada máquina de cada setor
	        for (int i = 0; i < quantidade; i++) {
	            if (setoresMaisProdutivos.contains(i)) {
	                if (setoresMaisProdutivos.size() > 1) {
	                    System.out.println("\nSetor " + (i + 1) + ": *Um dos mais produtivos*\n");
	                } else {
	                    System.out.println("\nSetor " + (i + 1) + ": *O mais produtivo*\n");
	                }
	            } else {
	                System.out.println("\nSetor " + (i + 1) + ":\n");
	            }
	            for (int j = 0; j < qtdMaquinas.get(i); j++) {
	                if (qtdpecas.get(pecas) < 10) { // Verificação da quantidade de peças
	                    System.out.println("Máquina " + (j + 1) + " produziu: " + qtdpecas.get(pecas) + " *Abaixo do limite*");
	                } else {
	                    System.out.println("Máquina " + (j + 1) + " produziu: " + qtdpecas.get(pecas));
	                }
                    pecas++;
	            }
	        }

		System.out.println("\nProdução por tipo de peça: \n");	//Essa parte mostra a produção por tipo de peça
		int total1 = 0;
		int total2 = 0;
		int total3 = 0;
				for (int i = 0; i < peças1.size(); i++) {
					total1 += peças1.get(i);
				}for (int i = 0; i < peças2.size(); i++) {
					total2 += peças2.get(i);
				}for (int i = 0; i < peças3.size(); i++) {
					total3 += peças3.get(i);
				}
			System.out.println("Prudução de peças grandes: " + total1);
			System.out.println("Prudução de peças médias: " + total2);
			System.out.println("Prudução de peças pequenas: " + total3);
		}
	}
		
	
	public static void relatórioPeças(){
		if (quantidade == 0 ) {
			System.out.println("Nenhum setor cadastrado");
		}else {
			System.out.println("\nProdução por tipo de peça: \n");
			int total1 = 0;
			int total2 = 0;
			int total3 = 0;
					for (int i = 0; i < peças1.size(); i++) {
						total1 += peças1.get(i);
					}for (int i = 0; i < peças2.size(); i++) {
						total2 += peças2.get(i);
					}for (int i = 0; i < peças3.size(); i++) {
						total3 += peças3.get(i);
					}
				System.out.println("Prudução de peças grandes: " + total1);
				System.out.println("Prudução de peças médias: " + total2);
				System.out.println("Prudução de peças pequenas: " + total3);
		}
	}
	public static void main(String[] args) { 
		Scanner scan = new Scanner(System.in);
			while (true) {		//loop de repetição
				System.out.println("\n----Menu---- \n1- Cadastro de setores \n2- Relátório Geral\n3- Produção apenas por tipo de peças \n4- Sair");
		int opcao = scan.nextInt();
				switch(opcao){
			case 1:
				cadastrar(scan);
				break;
			case 2:
				relatórioGeral();
				break;
			case 3:	
				relatórioPeças();
				break;
			case 4:
				scan.close();
				System.exit(1);
				break;
			default:
				System.out.println("Opção Inválida");
			}
		}
	}
}
