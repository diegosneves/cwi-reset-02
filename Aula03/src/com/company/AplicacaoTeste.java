package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumeradore.Genero;
import com.company.heranca.Diretor;

public class AplicacaoTeste {



    public static void main(String[] args) {
        Diretor diretor = new Diretor("Fulano", 60, 30, Genero.MASCULINO);
        Filme filme1 = new Filme("PI", "Aventura", 120, 2010, 4, diretor);
        Editora editora = new Editora("DC Comics2", "Rua x");

        filme1.reproduzir();
        System.out.println(editora.toString());


    }

}
