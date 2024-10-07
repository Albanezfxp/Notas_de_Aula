import java.util.Scanner;

class UberCorrida {
    double distancia;
    int tempoEspera;
    double tarifaBase;
    double fatorDemanda;

    UberCorrida(double distancia, int tempoEspera, double tarifaBase, double fatorDemanda) {
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.tarifaBase = tarifaBase;
        this.fatorDemanda = fatorDemanda;
    }

    double calcularValorCorrida() {
        return (distancia * 2) + (tempoEspera * 0.5) + (tarifaBase * fatorDemanda);
    }

    void exibirDetalhesCorrida() {
        System.out.printf("Distância: %.2f km%n", distancia);
        System.out.printf("Tempo de espera: %d min%n", tempoEspera);
        System.out.printf("Tarifa base: R$ %.2f%n", tarifaBase);
        System.out.printf("Fator de demanda: %.2f%n", fatorDemanda);
        System.out.printf("Valor final da corrida: R$ %.2f%n", calcularValorCorrida());
    }
}

public class SistemaUber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simulação de corrida de Uber");
        System.out.print("Digite a distância percorrida (km): ");
        double distancia = scanner.nextDouble();

        System.out.print("Digite o tempo de espera (min): ");
        int tempoEspera = scanner.nextInt();

        System.out.print("Digite a tarifa base: R$ ");
        double tarifaBase = scanner.nextDouble();

        System.out.print("Digite o fator de demanda: ");
        double fatorDemanda = scanner.nextDouble();

        UberCorrida corrida = new UberCorrida(distancia, tempoEspera, tarifaBase, fatorDemanda);
        corrida.exibirDetalhesCorrida();

        scanner.close();
    }
}
