package OO;

public class Aplicacao {

    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        Comparador comparador = new Comparador();

        Aluno aluno, aluno2;
        aluno = new Aluno("Fulano", 6.9);
        aluno2 = new Aluno("Ciclano", 8.9);

        int valor = 6, valor2 = 3;

        //Testes com o Class Calculadora
        System.out.println("\n====Testes com o Class Calculadora====\n");
        System.out.printf("Somar: %d + %d é igual a %d\n", valor, valor2, calc.soma(valor, valor2));
        System.out.printf("Subtrair: %d - %d é igual a %d\n", valor, valor2, calc.subtrai(valor, valor2));
        System.out.printf("Multiplicar: %d * %d é igual a %d\n", valor, valor2, calc.multiplica(valor, valor2));
        System.out.printf("Dividir: %d / %d é igual a %d\n", valor, valor2, calc.divide(valor, valor2));
        System.out.println("\n======================================\n");

        //Teste com a Class Comparadora
        System.out.println("\n====Teste com a Class Comparadora====\n");
        System.out.printf("O valor %d é menor que %d? %b\n", valor, valor2, comparador.menorQue(valor, valor2));
        System.out.println("\n=====================================\n");

        //Testes com a Class Aluno
        System.out.println("\n====Testes com a Class Aluno====\n");
        System.out.println(aluno.retornaDados());
        System.out.println();
        System.out.println(aluno2.retornaDados());
        System.out.println("\n=================================\n");
    }
}
