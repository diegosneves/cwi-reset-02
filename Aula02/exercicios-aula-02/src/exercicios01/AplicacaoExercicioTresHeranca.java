package exercicios01;

import java.time.LocalDate;

public class AplicacaoExercicioTresHeranca {
    public static void main(String[] args) {
        LocalDate dataNascimento1 = LocalDate.parse("1982-09-02");
        Diretor diretor = new Diretor("James Cameron", dataNascimento1, 37, Genero.MASCULINO);
        Ator ator = new Ator("Fulana", dataNascimento1, 3, Genero.FEMININO);

        System.out.println("\n===EXIBIR OS DADOS APOS EXTENDS PESSOA - EXERCICIO 03===\n");
        System.out.println("DADOS DO DIRETOR:");
        diretor.exibirDados();
        System.out.println("\n\nDADOS DO ATOR:");
        ator.exibirDados();
    }
}
