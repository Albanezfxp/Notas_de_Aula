class Animal {
    protected String nome;
    protected String raca;

    public Animal(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public void caminha() {
        System.out.println(nome + " está caminhando.");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }

    public void late() {
        System.out.println(nome + " está latindo!");
    }
}

class Gato extends Animal {
    public Gato(String nome, String raca) {
        super(nome, raca);
    }

    public void mia() {
        System.out.println(nome + " está miando!");
    }
}

public class TesteAnimal {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Rex", "Pastor Alemão");
        Gato gato = new Gato("Mimi", "Siamês");

        cachorro.caminha();
        cachorro.late();

        System.out.println();

        gato.caminha();
        gato.mia();
    }
}
