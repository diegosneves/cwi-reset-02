package exercicios01;

public class Ator extends Pessoa {

    private int qtdeOscarVencidos;

    public Ator(String nome, int idade, int qtdeOscarVencidos, Genero genero) {
        super(nome, idade, genero);
        this.qtdeOscarVencidos = qtdeOscarVencidos;
    }

}
