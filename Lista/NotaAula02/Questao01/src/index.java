import java.util.Scanner;

class Conta {
    String titular;
    double saldo;

    Conta(String titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    void exibirDados() {
        System.out.printf("Titular: %s | Saldo: R$ %.2f%n", titular, saldo);
    }
}

class ContaCorrente extends Conta {
    double chequeEspecial = 1000;

    ContaCorrente(String titular) {
        super(titular);
    }

    @Override
    void sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com cheque especial!");
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
        }
    }
}

class ContaPoupanca extends Conta {
    ContaPoupanca(String titular) {
        super(titular);
    }

    void calcularRendimento(double selic) {
        double rendimento;
        if (selic > 8.5) {
            rendimento = 0.005 * saldo;
        } else {
            rendimento = 0.007 * selic * saldo;
        }
        saldo += rendimento;
        System.out.printf("Rendimento calculado: R$ %.2f%n", rendimento);
    }
}

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular: ");
        String titular = scanner.nextLine();

        System.out.println("Selecione o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int tipoConta = scanner.nextInt();
        Conta conta = null;

        if (tipoConta == 1) {
            conta = new ContaCorrente(titular);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(titular);
        }

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMenu de opções:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir dados da conta");
            if (conta instanceof ContaPoupanca) {
                System.out.println("4 - Calcular rendimento");
            }
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.exibirDados();
                    break;
                case 4:
                    if (conta instanceof ContaPoupanca) {
                        System.out.print("Digite o valor da taxa Selic: ");
                        double selic = scanner.nextDouble();
                        ((ContaPoupanca) conta).calcularRendimento(selic);
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
