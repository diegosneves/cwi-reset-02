package exercicios01;

public class AplicacaoExercicioTresHeranca {
    public static void main(String[] args) {
        Diretor diretor = new Diretor("James Cameron", 58, 37, Genero.MASCULINO);
        Ator ator = new Ator("Fulana", 36, 3, Genero.FEMININO);

        System.out.println("\n===EXIBIR OS DADOS APOS EXTENDS PESSOA - EXERCICIO 03===\n");
        System.out.println("DADOS DO DIRETOR:");
        diretor.exibirDados();
        System.out.println("\n\nDADOS DO ATOR:");
        ator.exibirDados();
    }
}
