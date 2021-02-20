package exercicios01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AplicacaoExercicioQuatro {



    public static void main(String[] args) {
        LocalDate dataNascimento1 = LocalDate.parse("1982-09-02");

        List<Pessoa> elenco = new ArrayList<>();
        elenco.add(new Diretor("Fulano", dataNascimento1, 20, Genero.MASCULINO));

        Filme filme1 = new Filme("O Livro de Eli", "Ótimo filme", 127, 2010, 6, elenco);
        Filme filme2 = new Filme("Clube da Luta", "Ótimo filme", 120, 2015, 1, elenco);
        Filme filme3 = new Filme("Batman vs Superman", "Ótimo filme", 120, 2015, 5, elenco);

        System.out.println();
        System.out.println(filme1.toString());
        System.out.println("\n");
        System.out.println(filme2.toString());
        System.out.println("\n");
        System.out.println(filme3.toString());

    }
}
