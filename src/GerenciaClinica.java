import java.util.Scanner;

public class GerenciaClinica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FilaAtendimento fila = new FilaAtendimento();
        HistoricoAtendimento historico = new HistoricoAtendimento();

        int opcao = 0;

        System.out.println("°°°°°°°°°° Gerenciamento da Clínica°°°°°°°°°°°°");

        do {
            exibirMenu();
            opcao = lerInteiro(scanner, "Digite a opção: ");

            if (opcao == 1) {
                adicionarPaciente(scanner, fila);
            } else if (opcao == 2) {
                atenderPaciente(fila, historico);
            } else if (opcao == 3) {
                fila.mostrarFila();
            } else if (opcao == 4) {
                historico.mostrarHistorico();
            } else if (opcao == 5) {
                System.out.println("Encerrando o sistema...");
            } else {
                System.out.println("Opção inválida! Digite um número entre 1 e 5.");
            }
        }while (opcao != 5) ;
            System.out.println();

    }

    private static void exibirMenu() {
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        System.out.println("1. Adicionar novo paciente à fila");
        System.out.println("2. Atender próximo paciente");
        System.out.println("3. Exibir fila de atendimento");
        System.out.println("4. Exibir histórico de atendimentos");
        System.out.println("5. Sair");
        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.println(mensagem);
            if(scanner.hasNext()){
                valor= scanner.nextInt();
                valido = true;
            }else{
                System.out.println("Digite um número válido");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return valor;

    }

    private static void adicionarPaciente(Scanner scanner, FilaAtendimento fila){
        System.out.println("°°°°°°Novo paciente°°°°°°°°°");
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        int idade = lerInteiro(scanner, "Digite a idade do paciente: ");

        System.out.print("Digite o sintoma do paciente: ");
        String sintoma = scanner.nextLine();
        Paciente novoPaciente = new Paciente(nome, idade, sintoma);
        fila.adicionarPaciente(novoPaciente);

        System.out.println("Paciente adicionado à fila com sucesso");
    }

    private static void atenderPaciente(FilaAtendimento fila, HistoricoAtendimento historico){
        if(fila.estaVazia()){
            System.out.println("Não há pacientes na fila para atender");
            return;
        }
        Paciente pacienteAtendido = fila.atenderPaciente();
        historico.adicionarHistorico(pacienteAtendido);
        System.out.println("°°°°°°°Paciente Atendido°°°°°°°°°");
        System.out.println(pacienteAtendido.exibirInfo());
    }

}

