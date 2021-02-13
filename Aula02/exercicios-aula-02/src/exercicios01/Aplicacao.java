package exercicios01;

public class Aplicacao {

    public static void main(String[] args) {
        Diretor diretor = new Diretor("James Cameron", 58, 37, Genero.MASCULINO);
        Ator ator = new Ator("Fulana", 36, 3, Genero.FEMININO);
        Filme avatar = new Filme("Avatar", "Ficçao Cientifica", 160, 2012, diretor);
        Filme gerraAoTerror = new Filme("Gerra ao Terror", "Ação", 140, 2014, diretor);

        System.out.println("=====================================");
        System.out.println(avatar.toString()); //Teste com o método toString()
        System.out.println("=====================================");

        avatar.reproduzir(); //Teste com o método reproduzir()

        System.out.println("\n\n=====================================");
        System.out.println(gerraAoTerror.toString()); //Teste com o método toString()
        System.out.println("=====================================");

        gerraAoTerror.reproduzir(); //Teste com o método reproduzir()

        System.out.println("===EXIBIR OS DADOS DO ENUM IMPLEMENTADO - EXERCICIO 02===");
        System.out.println("Dados do Diretor:");
        diretor.exibirDados();
        System.out.println("\n\nDados do Ator:");
        ator.exibirDados();

    }
}
