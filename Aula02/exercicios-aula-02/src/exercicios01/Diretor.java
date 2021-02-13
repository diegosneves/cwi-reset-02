package exercicios01;

public class Diretor extends Pessoa {

    private int qtdeDeFilmesProduzidos;
    private Genero genero;

    public Diretor(String nome, int idade, int qtdeDeFilmesProduzidos, Genero genero) {
        super(nome, idade, genero);
        this.qtdeDeFilmesProduzidos = qtdeDeFilmesProduzidos;
    }

    @Override
    public String toString() {
        return String.format("\tNome: %s\n\tIdade: %02d\n\tTotal de Filmes dirigidos: %02d",
                super.getNome(),
                super.getIdade(),
                this.qtdeDeFilmesProduzidos);
    }
}
