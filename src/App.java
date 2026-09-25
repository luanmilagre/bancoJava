import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        int conta = 12345;
        int senha = 12345678;
        int tentativaSenha = 0;

        double saldo = 2500.00;

        boolean acessoLiberado = false;

        Scanner scanner = new Scanner(System.in);

        // LOGIN
        while (tentativaSenha < 3) {

            System.out.println("Digite o número da conta:");
            int contaDigitada = scanner.nextInt();

            System.out.println("Digite a senha da conta:");
            int senhaDigitada = scanner.nextInt();

            tentativaSenha++;

            if (conta == contaDigitada && senha == senhaDigitada) {

                System.out.println("Bem-vindo, acesso liberado!");
                acessoLiberado = true;
                break;

            } else {

                System.out.println("Conta ou senha incorreta, tente novamente.");
            }
        }

        if (!acessoLiberado) {
            System.out.println("Número máximo de tentativas atingido. Acesso bloqueado!");
            scanner.close();
            return;
        }

        // MENU
        int opcao;

        do {
            System.out.println();
            System.out.println("-------------------------");
            System.out.println("        BANCO JAVA");
            System.out.println("-------------------------");
            System.out.println("Saldo disponível: R$ " + saldo);
            System.out.println("-------------------------");
            System.out.println("1 - Saque");
            System.out.println("2 - Depósito");
            System.out.println("3 - Transferência");
            System.out.println("4 - Sair");
            System.out.println("-------------------------");
            System.out.println("Digite a opção desejada:");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Digite o valor do saque:");
                    double valorSaque = scanner.nextDouble();

                    if (valorSaque <= saldo) {
                        saldo -= valorSaque;
                        System.out.println("Saque realizado com sucesso!");
                        System.out.println("Novo saldo: R$ " + saldo);
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 2:
                    System.out.println("Digite o valor do depósito:");
                    double valorDeposito = scanner.nextDouble();

                    if (valorDeposito > 0) {
                        saldo += valorDeposito;
                        System.out.println("Depósito realizado com sucesso!");
                        System.out.println("Novo saldo: R$ " + saldo);
                    } else {
                        System.out.println("Valor de depósito inválido.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o valor da transferência:");
                    double valorTransferencia = scanner.nextDouble();

                    if (valorTransferencia <= saldo && valorTransferencia > 0) {
                        saldo -= valorTransferencia;
                        System.out.println("Transferência realizada com sucesso!");
                        System.out.println("Novo saldo: R$ " + saldo);
                    } else {
                        System.out.println("Saldo insuficiente ou valor inválido.");
                    }
                    break;

                case 4:
                    System.out.println("Obrigado por utilizar o Banco Java!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}