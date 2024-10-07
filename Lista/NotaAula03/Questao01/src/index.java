import java.time.LocalDate;
import java.time.Period;

class Funcionario {
    protected String nome;
    protected LocalDate nasc;
    protected double salario;

    public Funcionario(String nome, LocalDate nasc, double salario) {
        this.nome = nome;
        this.nasc = nasc;
        this.salario = salario;
    }

    public void informarSalario() {
        System.out.printf("Salário: R$ %.2f\n", salario);
    }

    public int calcularIdade() {
        return Period.between(nasc, LocalDate.now()).getYears();
    }
}

class Gerente extends Funcionario {
    private String projeto;

    public Gerente(String nome, LocalDate nasc, double salario, String projeto) {
        super(nome, nasc, salario);
        this.projeto = projeto;
    }

    public void informarProjeto() {
        System.out.println("Gerenciando o projeto: " + projeto);
    }
}

class Programador extends Funcionario {
    private String linguagem;

    public Programador(String nome, LocalDate nasc, double salario, String linguagem) {
        super(nome, nasc, salario);
        this.linguagem = linguagem;
    }

    public void informarLinguagem() {
        System.out.println("Linguagem principal: " + linguagem);
    }
}

public class TesteFuncionario {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Ana", LocalDate.of(1985, 6, 15), 8000.00, "Sistema Financeiro");
        Programador programador = new Programador("Carlos", LocalDate.of(1990, 11, 20), 5000.00, "Java");

        gerente.informarSalario();
        gerente.informarProjeto();
        System.out.println("Idade do gerente: " + gerente.calcularIdade() + " anos");

        System.out.println();

        programador.informarSalario();
        programador.informarLinguagem();
        System.out.println("Idade do programador: " + programador.calcularIdade() + " anos");
    }
}
