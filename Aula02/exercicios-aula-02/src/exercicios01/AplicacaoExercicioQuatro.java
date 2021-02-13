package exercicios01;

public class AplicacaoExercicioQuatro {



    public static void main(String[] args) {
        Diretor diretor = new Diretor("Fulano", 50, 20, Genero.MASCULINO);
        Filme filme1 = new Filme("O Livro de Eli", "Ótimo filme", 127, 2010, 6, diretor);
        Filme filme2 = new Filme("Clube da Luta", "Ótimo filme", 120, 2015, 1, diretor);
        Filme filme3 = new Filme("Batman vs Superman", "Ótimo filme", 120, 2015, 5, diretor);

        System.out.println();
        System.out.println(filme1.toString());
        System.out.println("\n");
        System.out.println(filme2.toString());
        System.out.println("\n");
        System.out.println(filme3.toString());

    }
}
