package SA;
import java.util.*;

public class Equipe9 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<String> maquinas = Arrays.asList("algodão", "poliéster", "produção mista");
        List<int[]> producao = new ArrayList<>();

        // Registrar nomes das máquinas
        Map<String, String> nomesMaquinas = new HashMap<>();
        for (String maquina : maquinas) {
            System.out.println("Insira o nome da máquina responsável pelo " + maquina + ":");
            nomesMaquinas.put(maquina, entrada.nextLine());
        }

        // Coletar dados de produção semanal
        for (String maquina : maquinas) {
            producao.add(obterProducao(entrada, maquina));
        }

        // Relatório interativo
        relatorio(entrada, maquinas, producao);

        entrada.close();
        System.out.println("Programa encerrado.");
    }

    public static int[] obterProducao(Scanner entrada, String tipo) {
        int[] producao = new int[5];
        String[] dias = {"segunda", "terça", "quarta", "quinta", "sexta"};

        for (int i = 0; i < 5; i++) {
            System.out.println("Qual a produção de " + tipo + " na " + dias[i] + "?");
            while (!entrada.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                entrada.next();
            }
            producao[i] = entrada.nextInt();
        }
        return producao;
    }

    public static void emitirAlerta(double media, String tipo) {
        if (media < 50.0) {
            System.out.println("ALERTA: A produtividade de " + tipo + " está abaixo de 50!");
        }
    }

    public static void relatorio(Scanner entrada, List<String> maquinas, List<int[]> producao) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha a informação necessária: ");
            for (int i = 0; i < maquinas.size(); i++) {
                System.out.println((i + 1) + "- Média semanal de " + maquinas.get(i));
            }
            System.out.println((maquinas.size() + 1) + "- Média geral da produção");

            while (!entrada.hasNextInt()) {
                System.out.println("Por favor, insira uma opção válida.");
                entrada.next();
            }
            int opcao = entrada.nextInt();

            if (opcao > 0 && opcao <= maquinas.size()) {
                double media = Arrays.stream(producao.get(opcao - 1)).average().orElse(0);
                System.out.printf("A média semanal de %s foi: %.2f\n", maquinas.get(opcao - 1), media);
                emitirAlerta(media, maquinas.get(opcao - 1));
            } else if (opcao == maquinas.size() + 1) {
                double mediaGeral = producao.stream().flatMapToInt(Arrays::stream).average().orElse(0);
                System.out.printf("A média geral de produção foi: %.2f\n", mediaGeral);
            } else {
                System.out.println("Opção inválida.");
            }

            System.out.println("Deseja consultar outra opção? (s/n)");
            if (!entrada.next().toLowerCase().equals("s")) {
                continuar = false;
            }
        }
    }
}
