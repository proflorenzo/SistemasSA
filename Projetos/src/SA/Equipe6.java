package SA;

import java.util.*;

public class Equipe6 {
Scanner entrada = new Scanner (System.in );
	public ArrayList <String> Maquinas = new ArrayList<>();
	public ArrayList <String> Setor = new ArrayList<>();
	 int qtdeLinhas = 8;
	 int qtdeColuna = 2;
	 int linhasYtilizadas = 0;
	 public double[][] smns = new double[qtdeLinhas][qtdeColuna];
	 
	
	public void cadastro() {
		System.out.println("Selecione o nome da máquina, 1- para Tear, 2- para Overlock, 3- para Cortadora");
		int mqn = entrada.nextInt();
		switch(mqn) {
		case 1: Maquinas.add("Tear"); break;
		case 2: Maquinas.add("Overlock"); break;
		case 3: Maquinas.add("Cortadora"); break;
		default: System.out.println("Erro, escolha uma opção correta..."); break;
		}
		System.out.println("1- para Poliester, 2- para Algodão, 3- para Misto: ");
		int opcao = 0;
		opcao = entrada.nextInt();
		entrada.nextLine();
		switch(opcao) {
		case 1: Setor.add("Poliester"); break;
		case 2: Setor.add("Algodão"); break;
		case 3: Setor.add("Misto"); break;
		}
		System.out.println("Cadastrado com sucesso!");
	}
	
	
	
	public void mostrarMqnSet() {
		System.out.print("Maquinas: ");
		System.out.println("  " + Maquinas);
		System.out.println("Setores: " + Setor);
	}
	
	
	
	public void regispdc(Scanner entrada) {
		if(linhasYtilizadas >= smns.length) {
			System.out.println("Impossivel escrever dados");
			return;
		}

		for(int i = 0; i < Maquinas.size(); i++) {

		        System.out.print("Quantidade de metros: ");
		        smns[i][0] = entrada.nextDouble();

		        System.out.print("Semana: ");
		        smns[i][1] = entrada.nextDouble(); 
		        linhasYtilizadas++;
			}
	}
	
	
	
	public void imprimirSmns() {  
	    for (int i = 0; i < linhasYtilizadas; i++) {
	        System.out.println("Máquina " + (Maquinas.get(i)) + ":");
	        System.out.println("  Quantidade de metros: " + smns[i][0]);
	        System.out.println("  Semana: " + smns[i][1]);
	        System.out.println();
	    }
	}
	
	
	
	public void buscarSetor() {
		System.out.println("Digite 1- para buscar por Poliester, 2- para Algodão, 3- para Misto");
		int setorConsulta = entrada.nextInt();
	String setorPadrao;

	switch (setorConsulta) {
	    case 1: setorPadrao = "Poliester"; break;
	    
	    case 2: setorPadrao = "Algodão"; break;
	    
	    case 3: setorPadrao = "Misto"; break;
	    
	    default: System.out.println("Setor inválido!"); return;
	}

	boolean encontrado = false;

	for (int i = 0; i < Setor.size(); i++) {
	    if (Setor.get(i).equalsIgnoreCase(setorPadrao)) {
	        System.out.println("Máquina: " + Maquinas.get(i));
	        System.out.println("Quantidade produzida: " + smns[i][0]);
	        System.out.println("Semana: " + smns[i][1]);
	        System.out.println("-----------------------------");
	        encontrado = true;
	    }
	}

	if (!encontrado) {
	    System.out.println("Nenhuma máquina encontrada nesse setor!");
	}
	}
	
	
	
	public void geral() {
		double soma = 0;
		for(int i = 0;i < 2;i++) {
			soma += smns[i][0] / Maquinas.size();
			if(soma <= 500) {
				System.out.println("ALERTA!!!!!!!!!! baixa produção detectada (produção média menor que 500m)");
				System.out.println("Produção: " + soma);
				return;
			}
			else if(soma > 500) {
				System.out.println("A produção média é: " + soma);
			}
		}
	}
	}
