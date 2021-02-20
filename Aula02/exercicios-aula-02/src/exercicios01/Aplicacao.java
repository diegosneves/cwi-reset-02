package exercicios01;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor = new Diretor("James Cameron", 58, 37, Genero.MASCULINO);
        Ator ator1 = new Ator("Fulana", 32, 3, Genero.FEMININO);
        Ator ator2 = new Ator("Ciclano", 36, 1, Genero.MASCULINO);
        Ator ator3 = new Ator("Beltrano", 48, 7, Genero.MASCULINO);

        List<Pessoa> elenco = new ArrayList<>();
        elenco.add(ator1);
        elenco.add(ator2);
        elenco.add(ator3);

        Filme avatar = new Filme("Avatar", "Ficçao Cientifica", 160, 2012, diretor, elenco);
        Filme gerraAoTerror = new Filme("Gerra ao Terror", "Ação", 140, 2014, diretor, elenco);

        System.out.println("=====================================");
        System.out.println("\t>> METODO toString() <<");
//        System.out.println(avatar.toString()); //Teste com o método toString()
        avatar.exibirCreditos();
        System.out.println("=====================================");
        System.out.println("\t>> METODO reproduzir() <<");
        avatar.reproduzir(); //Teste com o método reproduzir()

        System.out.println("\n\n=====================================");
        System.out.println("\t>> METODO toString() <<");
//        System.out.println(gerraAoTerror.toString()); //Teste com o método toString()
        gerraAoTerror.exibirCreditos();
        System.out.println("=====================================");
        System.out.println("\t>> METODO reproduzir() <<");
        gerraAoTerror.reproduzir(); //Teste com o método reproduzir()


    }
}
