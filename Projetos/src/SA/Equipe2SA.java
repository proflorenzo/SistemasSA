package SA;
import java.util.*;

public class Equipe2SA {

  
    public static class Maquina {
        int id;
        String setor;
        int alicatesProduzidos;
        int martelosProduzidos;
        int chavesFendaProduzidas;

        public Maquina(int id, String setor, int alicates, int martelos, int chaves) {
            this.id = id;
            this.setor = setor;
            this.alicatesProduzidos = alicates;
            this.martelosProduzidos = martelos;
            this.chavesFendaProduzidas = chaves;
        }

        public String identificação() {
            return "Máquina ID: " + id +
                   " | Alicates: " + alicatesProduzidos +
                   " | Martelos: " + martelosProduzidos +
                   " | Chaves de Fenda: " + chavesFendaProduzidas;
        }
    }
    static int Qtsetores;
    static int[][] ferramentas; 
    static ArrayList<String> nomeSetor = new ArrayList<>();
    static ArrayList<Integer> maquinasPSetor = new ArrayList<>();
    static ArrayList<Maquina> listaMaquinas = new ArrayList<>();
    
    public static String op1(Scanner entrada) {
        System.out.println("Quantos Setores vão existir?");
        Qtsetores = entrada.nextInt();
        entrada.nextLine();
        ferramentas = new int[3][Qtsetores];
        for (int e = 0; e < Qtsetores; e++) {
            String nome;
            while (true) {
                System.out.println("Nome do setor:");
                nome = entrada.nextLine();
                if (nomeSetor.contains(nome)) {
                    System.out.println("Setor já registrado, por favor informe um nome diferente.");
                } else {
                    break;
                }
            }
            nomeSetor.add(nome);

            System.out.println("Quantas máquinas vão ter no setor?");
            int maquinaPSetor = entrada.nextInt();
            entrada.nextLine();
            maquinasPSetor.add(maquinaPSetor);
        }
        return "Setor(es) Registrado(s)!";
    }
    public static String op2(Scanner entrada) {
        if (nomeSetor.isEmpty()) {
            return "Nenhum setor cadastrado!";
        }
        System.out.println("Setores disponíveis:");
        for (int i = 0; i < nomeSetor.size(); i++) {
            System.out.println((i + 1) + " - " + nomeSetor.get(i));
        }
        System.out.println("Selecione o setor para cadastrar máquinas (digite o número correspondente):");
        int setorEscolhido = entrada.nextInt();
        entrada.nextLine();
        
        if (setorEscolhido < 1 || setorEscolhido > nomeSetor.size()) {
            return "Setor inválido!";
        }
        
        String setor = nomeSetor.get(setorEscolhido - 1);
        int qtdMaquinas = maquinasPSetor.get(setorEscolhido - 1);
        int count = 0;
        for (Maquina m : listaMaquinas) {
            if (m.setor.equals(setor)) {
                count++;
            }
        }
        if (count >= qtdMaquinas) {
            return "Máquinas já cadastradas para este setor!";
        }
        System.out.println("Registrando máquinas para o setor: " + setor);
        for (int h = count; h < qtdMaquinas; h++) {
            int numM;
            while (true) {
                System.out.println("Registre o número de identificação da máquina:");
                numM = entrada.nextInt();
                boolean duplicado = false;
                for (Maquina m : listaMaquinas) {
                    if (m.id == numM) {
                        duplicado = true;
                        break;
                    }
                }
                if (duplicado) {
                    System.out.println("Esta identificação já foi registrada. Por favor, insira um número diferente.");
                } else {
                    break;
                }
            }            
            System.out.println("Quantos alicates a máquina produz semanalmente?");
            int Qtalicates = entrada.nextInt();
            System.out.println("Quantos martelos a máquina produz semanalmente?");
            int Qtmartelos = entrada.nextInt();
            System.out.println("Quantas chaves de fenda a máquina produz semanalmente?");
            int Qtchavesdefenda = entrada.nextInt();
            entrada.nextLine();
            Maquina novaMaquina = new Maquina(numM, setor, Qtalicates, Qtmartelos, Qtchavesdefenda);
            listaMaquinas.add(novaMaquina);
            int indiceSetor = nomeSetor.indexOf(setor);
            ferramentas[0][indiceSetor] += Qtalicates;
            ferramentas[1][indiceSetor] += Qtmartelos;
            ferramentas[2][indiceSetor] += Qtchavesdefenda;
        }
        return "Máquinas Registradas para o setor " + setor + "!";
    }
    
    public static String op3(Scanner entrada) {
        if (listaMaquinas.isEmpty()) {
            return "Nenhuma máquina registrada!";
        }

        System.out.println("Digite o número da máquina que deseja conferir:");
        int numMaquina = entrada.nextInt();
        entrada.nextLine();

        for (Maquina maquina : listaMaquinas) {
            if (maquina.id == numMaquina) {
                System.out.println("\nProdução da máquina " + numMaquina + ":");
                System.out.println(maquina.identificação());
                return "Produção conferida com sucesso!";
            }
        }
        return "Máquina não encontrada!";
    }
    
    public static String op4(Scanner entrada) {
        if (nomeSetor.isEmpty()) {
            return "Nenhum setor registrado!";
        }
        
        System.out.println("Setores disponíveis:");
        for (int i = 0; i < nomeSetor.size(); i++) {
            System.out.println((i + 1) + " - " + nomeSetor.get(i));
        }
        System.out.println("Selecione o setor (digitando o número correspondente):");
        int setorSelecionado = entrada.nextInt();
        entrada.nextLine();
        if (setorSelecionado < 1 || setorSelecionado > nomeSetor.size()) {
            return "Setor inválido!";
        }
        String setorEscolhido = nomeSetor.get(setorSelecionado - 1);
        System.out.println("\nProdução das máquinas do setor: " + setorEscolhido);
        boolean encontrada = false;
        for (Maquina maquina : listaMaquinas) {
            if (maquina.setor.equals(setorEscolhido)) {
                System.out.println(maquina.identificação());
                encontrada = true;
            }
        }
        if (!encontrada) {
            return "Nenhuma máquina registrada neste setor!";
        }
        return "Produção do setor conferida com sucesso!";
    }

    public static String op5(Scanner entrada) {
        if (nomeSetor.isEmpty()) {
            return "Nenhum setor registrado!";
        }  

        System.out.println("Informe o setor que deseja saber sobre as máquinas:");
        String setorDesejado = entrada.nextLine();

        int indiceSetor = nomeSetor.indexOf(setorDesejado);
        if (indiceSetor == -1) {
            return "Setor não encontrado!";
        }

        System.out.println("\nProdução total do setor " + setorDesejado + ":");
        System.out.println("  Total de Alicates: " + ferramentas[0][indiceSetor]);
        System.out.println("  Total de Martelos: " + ferramentas[1][indiceSetor]);
        System.out.println("  Total de Chaves de Fenda: " + ferramentas[2][indiceSetor]);

        return "Produção conferida com sucesso!";
    }
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bem-vindo!!");
        int opcao;
        do {
            System.out.println("\n-----MENU-----");
            System.out.println("1 - Definir setores e máquinas por setor");
            System.out.println("2 - Registrar Máquina");
            System.out.println("3 - Conferir Produção por Setor");
            System.out.println("4 - Monitorar Produção de Máquinas por Setor");
            System.out.println("5 - Monitorar por Tipo de Ferramenta");
            System.out.println("6 - Sair");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1: 
                    System.out.println(op1(entrada));
                    break;
                case 2:
                    System.out.println(op2(entrada));
                    break;
                case 3:
                    System.out.println(op3(entrada));
                    break;
                case 4:
                    System.out.println(op4(entrada));
                    break;
                case 5:
                    System.out.println(op5(entrada));
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);
    }
}
