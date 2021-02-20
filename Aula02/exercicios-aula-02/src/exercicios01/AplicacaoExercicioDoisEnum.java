package exercicios01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AplicacaoExercicioDoisEnum {

    public static void main(String[] args) {
        LocalDate dataNascimento1 = LocalDate.parse("1982-09-02");
        Diretor diretor = new Diretor("James Cameron", dataNascimento1, 37, Genero.MASCULINO);
        Ator ator = new Ator("Fulana", dataNascimento1, 3, Genero.FEMININO);

        System.out.println("\n===EXIBIR OS DADOS DO ENUM IMPLEMENTADO - EXERCICIO 02===\n");
        System.out.println("DADOS DO DIRETOR:");
        diretor.exibirDados();
        System.out.println("\n\nDADOS DO ATOR:");
        ator.exibirDados();

    }
}
