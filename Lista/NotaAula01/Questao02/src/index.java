import java.util.Scanner;

public class SistemaControleProduto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Cadastro do Produto");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Tamanho/Peso: ");
        String tamanhoPeso = scanner.nextLine();
        
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        
        System.out.print("Valor: R$ ");
        double valor = scanner.nextDouble();
        
        System.out.print("Quantidade em estoque: ");
        int quantidadeEstoque = scanner.nextInt();
        
        System.out.println("\nRealizar Venda");
        System.out.print("Quantidade a vender: ");
        int quantidadeVenda = scanner.nextInt();
        
        if (quantidadeVenda <= quantidadeEstoque) {
            double valorTotal = valor * quantidadeVenda;
            quantidadeEstoque -= quantidadeVenda;
            
            System.out.println("Formas de pagamento:");
            System.out.println("1 - Pix, Espécie, Transferência ou Débito (5% de desconto)");
            System.out.println("2 - Crédito (3x sem juros)");
            int formaPagamento = scanner.nextInt();
            
            if (formaPagamento == 1) {
                double desconto = valorTotal * 0.05;
                valorTotal -= desconto;
                
                System.out.println("Pagamento em Espécie? (1-Sim, 2-Não): ");
                int pagamentoEspecie = scanner.nextInt();
                
                if (pagamentoEspecie == 1) {
                    System.out.print("Valor pago: R$ ");
                    double valorPago = scanner.nextDouble();
                    
                    if (valorPago >= valorTotal) {
                        double troco = valorPago - valorTotal;
                        System.out.printf("Troco: R$ %.2f%n", troco);
                    } else {
                        System.out.println("Valor insuficiente.");
                    }
                }
            } else if (formaPagamento == 2) {
                System.out.printf("Total a ser parcelado em 3x de: R$ %.2f%n", valorTotal / 3);
            }
            
            System.out.println("Venda realizada com sucesso!");
            System.out.printf("Estoque atual: %d unidades%n", quantidadeEstoque);
        } else {
            System.out.println("Estoque insuficiente.");
        }
        
        scanner.close();
    }
}
