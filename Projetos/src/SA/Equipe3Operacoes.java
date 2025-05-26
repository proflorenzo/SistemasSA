package SA;
import java.util.*;
public class Equipe3Operacoes {
	List <Integer> maquinas = new ArrayList <>();	//Lista das máquinas
	List <String> setores = new ArrayList <>();		//Lista dos setores, alinhada com a das máquinas
	int semana[][] = new int[8][6];					//Matriz da semana
	int dia = 0;									//Contador de dias
	int maquina = 1;								//Contador de máquinas
	
	Scanner entrada = new Scanner(System.in);
	public void menu() {			//Printa o menu
		System.out.println("---MENU---");
		System.out.println("1 - Cadastrar máquina");
		System.out.println("2 - Registrar produção do dia");
		System.out.println("3 - Visualizar relatório semanal");
		System.out.println("4 - Visualizar maquinas");
		System.out.println("5 - Encerrar sistema");
	}
	
	public void maquinas() {			//Printa as máquinas e seus setores 
		System.out.println("Máquinas: ");
		System.out.println(maquinas);
		System.out.println("Setores:");
		System.out.println(setores);
	}
	
	public void cadastrar() {
		int opcao = 0;
		if (maquina > 6) {		//Condição caso o usuário tente cadastrar mais que 6 máquinas
			System.out.println("Você atingiu o número limite de máquinas.");
			return;
		}
		System.out.println("Digite o setor da máquina " + maquina + "(limite de 6 máquinas)\n1- Algodão\n2- Poliéster\n3- Mistos");
		opcao = entrada.nextInt();			
		switch (opcao) {				//Adição à lista de setores de acordo com o que o usuário digitar
		case 1:
			setores.add("algodao");
			break;
		case 2:
			setores.add("poliester");
			break;
		case 3:
			setores.add("mistos");
			break;
		default:
			System.out.println("Você não digitou um setor válido, tente novamente.");
			return;
		}
		System.out.println("Máquina registrada com sucesso!");
		maquinas.add(maquina);
		maquina ++;					//Registra a máquina e seu setor, de acordo com a preferência do usuário
		
	}
	
	public void RegistrarProducao() {
		dia++;
		
		if (dia == 6) {
			System.out.println("Nova semana iniciada!");
			for (int i = 0;i < 6;i++) {
				for (int j = 0;j < 6;j++) {
					semana[i][j] = 0;
				}
			}
			dia = 1;
		}
			
		int p = 0;				
		for(int i = 0;i < maquinas.size();i++) {			//Registra a produção e manda direto para a matriz com o relatório semanal
			System.out.println("Digite a produção da máquina " + maquinas.get(i) + ": ");
			p = entrada.nextInt();
			if (p < 0) {
				System.out.println("Produção inválida, tente novamente.");	//Condição caso o usuário digite um número menor que 0
				i--;
				continue;
			}
			semana[dia][i] = p;
			p = 0;
		}
	}
	
	public void relatorio() {		//Faz a soma e a média da produção de cada dia da semana
		int soma = 0;
		int media = 0;
		for (int i = 0;i < 6;i++) {
			for (int j = 0;j < 6;j++) {
				soma += semana[j][i];
				if(semana[j][i] > 0) {
					media++;
				}
			}
			semana[6][i] = soma;
			if (media > 0) {
			semana[7][i] = semana[6][i] / media;
			}
			soma = 0;
			media = 0;
		}
		
		System.out.println("Relatório da semana por máquinas:\nLinha 1:Máquinas\nLinhas2-6: Dias da semana"
							+ "\nLinha 7: Soma da produção\n" + "Linha 8: Média produzida por cada máquina ");
		for (int i = 0;i < maquinas.size();i++) {					//Printa o relatório
			System.out.print(maquinas.get(i) + "       ");
		}
		
		for (int i = 0;i < semana.length;i++) {
			for(int j = 0;j < semana[i].length;j++) {
			System.out.print(semana[i][j] + "	");
			}
			System.out.println();
		}
		
		int somaA = 0; int somaP = 0; int somaM = 0;
		int mediaA = 0; int mediaP = 0; int mediaM = 0;
		
		for (int i = 0;i < setores.size();i++) {		//Faz a soma e média de cada setor, utilizando a lista de setores
			switch (setores.get(i)) {
			case "algodao":
				somaA += semana[6][i];
				mediaA++;
				break;
			case "poliester":
				somaP += semana[6][i];
				mediaP++;
				break;
			case "mistos":
				somaM += semana[6][i];
				mediaM++;
				break;
			}	
		}
		if(mediaA == 0) {			//Condicionais para que não ocorra divisão por 0
			mediaA = somaA;
		}else {
		mediaA = somaA / mediaA;
		}
		
		if(mediaP == 0) {
			mediaP = somaP;
		}else {
		mediaP = somaP / mediaP;
		}
		
		if(mediaM == 0) {
			mediaM = somaM;
		}else {
		mediaM = somaM / mediaM;
		}
		
		int opcao = 0;		
		while (opcao != 4) {				//Pergunta para o usuário o que ele quer visualizar
			System.out.println("Digite qual setor deseja consultar"
							+ "(1- Algodão, 2- Poliéster, 3- Mistos, 4- Sair): ");
			opcao = entrada.nextInt();
			switch(opcao) {
			case 1:
				System.out.println("Produção total do setor de algodão: " + somaA);
				System.out.println("Média da produção: " + mediaA);
				if (somaA < 400) {
					System.out.println("A produção de algodão está abaixo da média.");			//Avisos de produtividde
				}
				else if (somaA >= 400) {
					System.out.println("A produção de algodão está acima da média!");
				}
				break;
			case 2:
				System.out.println("Produção total do setor de algodão: " + somaP);
				System.out.println("Média da produção: " + mediaP);
				if (somaP < 400) {
					System.out.println("A produção de poliéster está abaixo da média.");
				}
				else if (somaP >= 400) {
					System.out.println("A produção de poliéster está acima da média!");
				}
				break;
			case 3:
				System.out.println("Produção total do setor de algodão: " + somaM);
				System.out.println("Média da produção: " + mediaM);
				if (somaA < 400) {
					System.out.println("A produção de mistos está abaixo da média.");
				}
				else if (somaA >= 400) {
					System.out.println("A produção de mistos está acima da média!");
				}
				break;
			case 4:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Digite uma opção válida.");
			}
		}
		
	}

}
