package exercicios01;

public class Ator extends Pessoa {

    private int qtdeOscarVencidos;

    public Ator(String nome, int idade, int qtdeOscarVencidos, Genero genero) {
        super(nome, idade, genero);
        this.qtdeOscarVencidos = qtdeOscarVencidos;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nIdade: %02d\nGenero: %s\nTotal de Oscar: %02d\n",
                super.getNome(),
                super.getIdade(),
                getGenero(),
                qtdeOscarVencidos);
    }
}
