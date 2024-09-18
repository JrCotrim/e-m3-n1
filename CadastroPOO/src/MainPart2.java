import services.Acoes;
import java.util.Scanner;

public class MainPart2 {

    static Scanner input = new Scanner(System.in);
    static String tipoPessoa = "";
    static String acaoEscolhida = "";

    public static void main(String[] args) {
        while (true) {
            mostrarMenuAcoes();
            selecionarTipoPessoa();
            processarAcao();
        }
    }

    private static void processarAcao() {
        Acoes acoes = new Acoes(tipoPessoa, acaoEscolhida);
        acoes.executandoAcoes();
    }

    private static void selecionarTipoPessoa() {
        System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica:");

        while (true) {
            String escolhaPessoa = input.next();
            if (escolhaPessoa.equalsIgnoreCase("f") || escolhaPessoa.equalsIgnoreCase("j")) {
                if (escolhaPessoa.equalsIgnoreCase("f")) {
                    tipoPessoa = "f";  // Pessoa Física selecionada
                } else {
                    tipoPessoa = "j";  // Pessoa Jurídica selecionada
                }
                break;
            } else {
                System.out.println("Opção inválida! Escolha F para Física ou J para Jurídica.");
            }
        }
    }

    private static void mostrarMenuAcoes() {
        while (true) {
            System.out.println("");
            System.out.println("==========================================");
            System.out.println("1 - Adicionar nova pessoa");
            System.out.println("2 - Editar informações de pessoa");
            System.out.println("3 - Remover uma pessoa");
            System.out.println("4 - Buscar pessoa por ID");
            System.out.println("5 - Mostrar todas as pessoas");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Restaurar dados");
            System.out.println("0 - Sair do programa");
            System.out.println("==========================================");
            System.out.print("Escolha uma opção: ");
            
            int opcaoMenu = -1;
            try {
                opcaoMenu = input.nextInt();
            } catch (RuntimeException e) {
                opcaoMenu = -1;
                input.nextLine();  // Limpa o buffer de entrada
            }

            switch (opcaoMenu) {
                case 1:
                    acaoEscolhida = "I";  // Incluir nova pessoa
                    return;
                case 2:
                    acaoEscolhida = "A";  // Alterar dados
                    return;
                case 3:
                    acaoEscolhida = "R";  // Remover
                    return;
                case 4:
                    acaoEscolhida = "B";  // Buscar por ID
                    return;
                case 5:
                    acaoEscolhida = "S";  // Mostrar todos os registros
                    return;
                case 6:
                    acaoEscolhida = "P";  // Salvar os dados
                    return;
                case 7:
                    acaoEscolhida = "G";  // Restaurar dados
                    return;
                case 0:
                    acaoEscolhida = "E";  // Encerrar o programa
                    System.out.println("Encerrando o programa...");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
