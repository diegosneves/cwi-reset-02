package exercicios01;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private int qtdeDeFilmesProduzidos;

    public Diretor(String nome, LocalDate idade, int qtdeDeFilmesProduzidos, Genero genero) {
        super(nome, idade, genero);
        this.qtdeDeFilmesProduzidos = qtdeDeFilmesProduzidos;
    }

    @Override
    public String toString() {
        return String.format("\tNome: %s\n\tIdade: %02d\n\tGenero: %s\n\tTotal de Filmes dirigidos: %02d",
                super.getNome(),
                super.calculaIdade(),
                super.getGenero(),
                this.qtdeDeFilmesProduzidos);
    }
}
