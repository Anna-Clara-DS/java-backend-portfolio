import java.util.Scanner;

public class UsuarioVisao {
    private UsuarioControlador controlador;
    private Scanner scanner;

    public UsuarioVisao(UsuarioControlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== SISTEMA BANCÁRIO =====");
            System.out.println("1. Listar contas");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> listarUsuarios();
                case 2 -> realizarDeposito();
                case 3 -> realizarSaque();
                case 4 -> realizarTransferencia();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private void listarUsuarios() {
        System.out.println("\n=== Contas Cadastradas ===");
        for (UsuarioModelo u : controlador.listarUsuarios()) {
            System.out.println(u);
        }
    }

    private void realizarDeposito() {
        System.out.print("Número da conta: ");
        String conta = scanner.next();
        System.out.print("Valor do depósito: ");
        double valor = scanner.nextDouble();

        if (controlador.depositar(conta, valor)) {
            System.out.println("Depósito efetuado!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private void realizarSaque() {
        System.out.print("Número da conta: ");
        String conta = scanner.next();
        System.out.print("Valor do saque: ");
        double valor = scanner.nextDouble();

        if (controlador.sacar(conta, valor)) {
            System.out.println("Saque efetuado!");
        } else {
            System.out.println("Erro ao sacar!");
        }
    }

    private void realizarTransferencia() {
        System.out.print("Conta de origem: ");
        String origem = scanner.next();
        System.out.print("Conta de destino: ");
        String destino = scanner.next();
        System.out.print("Valor da transferência: ");
        double valor = scanner.nextDouble();

        if (controlador.transferir(origem, destino, valor)) {
            System.out.println("Transferência realizada!");
        } else {
            System.out.println("Erro na transferência!");
        }
    }
}
