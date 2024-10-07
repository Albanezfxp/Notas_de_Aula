import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double valorHora = 15.00;
        int horasTrabalhadas = 40;
        double salario = valorHora * horasTrabalhadas;
        System.out.printf("Salário calculado: R$ %.2f%n", salario);

        System.out.println("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();
        System.out.println("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();
        
        if (numero1 > numero2) {
            System.out.println("O primeiro número é maior que o segundo.");
        } else if (numero1 < numero2) {
            System.out.println("O primeiro número é menor que o segundo.");
        } else {
            System.out.println("Os dois números são iguais.");
        }

        System.out.println("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();
        System.out.println("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();
        System.out.println("Digite a terceira nota: ");
        double nota3 = scanner.nextDouble();
        
        double media = (nota1 + nota2 + nota3) / 3;
        System.out.printf("Média: %.2f%n", media);
        
        if (media >= 70) {
            System.out.println("Situação: Aprovado.");
        } else if (media < 40) {
            System.out.println("Situação: Reprovado.");
        } else {
            System.out.println("Situação: Na final.");
        }

        scanner.close();
    }
}
