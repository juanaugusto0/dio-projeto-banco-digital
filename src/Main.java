import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Banco Bradesco! Por favor, insira seu nome para criar uma nova conta:");
        String nome = scanner.nextLine();
        Banco bradesco = new Banco("Bradesco");
        Conta novaConta = new Conta(nome, bradesco);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha uma ação: \n1. Depositar \n2. Sacar \n3. Transferir \n4. Ver saldo \n5. Sair");
            int acao = scanner.nextInt();
            switch (acao) {
                case 1:
                    System.out.println("Insira o valor que deseja depositar:");
                    double deposito = scanner.nextDouble();
                    novaConta.depositar(deposito);
                    break;
                case 2:
                    System.out.println("Insira o valor que deseja sacar:");
                    double saque = scanner.nextDouble();
                    novaConta.sacar(saque);
                    break;
                case 3:
                    System.out.println("Insira o valor que deseja transferir:");
                    double transferencia = scanner.nextDouble();
                    if (transferencia > novaConta.getSaldo()) {
                        System.out.println("Saldo insuficiente");
                        break;
                    }
                    System.out.println("Insira o nome do destinatário: ");
                    String destinatario = scanner.next();
                    Conta contaDestinatario = new Conta(destinatario, bradesco);
                    novaConta.transferir(contaDestinatario, transferencia);
                    break;
                case 4:
                    System.out.println("Seu saldo é: " + novaConta.getSaldo());
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Ação inválida. Tente novamente.");
            }
        }
        scanner.close();
        System.out.println("Obrigado por usar o Banco Bradesco. Até mais!");
        System.out.println(bradesco.getContas());
    }
}
