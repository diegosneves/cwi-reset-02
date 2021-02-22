package exercicios01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestaHashMap {

    public static void main(String[] args) {
        LocalDate dataNascimento1 = LocalDate.parse("1982-09-02");
        LocalDate dataNascimento2 = LocalDate.parse("1985-07-30");
        LocalDate dataNascimento3 = LocalDate.parse("2014-09-17");

        Diretor diretor = new Diretor("James Cameron", dataNascimento1, 37, Genero.MASCULINO);
        Ator ator1 = new Ator("Fulana", dataNascimento2, 3, Genero.FEMININO);
        Ator ator2 = new Ator("Ciclano", dataNascimento1, 1, Genero.MASCULINO);
        Ator ator3 = new Ator("Beltrano", dataNascimento3, 7, Genero.MASCULINO);

        List<Pessoa> elenco = new ArrayList<>();
        elenco.add(diretor);
        elenco.add(ator1);
        elenco.add(ator2);
        elenco.add(ator3);

        Filme avatar = new Filme("Avatar", "Ficçao Cientifica", 160, 2012, elenco);

        System.out.println(avatar.agruparElencoPorIdade());
    }

}
