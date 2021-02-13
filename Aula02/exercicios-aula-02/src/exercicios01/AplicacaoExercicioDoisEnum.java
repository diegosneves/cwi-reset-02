package exercicios01;

public class AplicacaoExercicioDoisEnum {

    public static void main(String[] args) {
        Diretor diretor = new Diretor("James Cameron", 58, 37, Genero.MASCULINO);
        Ator ator = new Ator("Fulana", 36, 3, Genero.FEMININO);

        System.out.println("\n===EXIBIR OS DADOS DO ENUM IMPLEMENTADO - EXERCICIO 02===\n");
        System.out.println("DADOS DO DIRETOR:");
        diretor.exibirDados();
        System.out.println("\n\nDADOS DO ATOR:");
        ator.exibirDados();

    }
}
