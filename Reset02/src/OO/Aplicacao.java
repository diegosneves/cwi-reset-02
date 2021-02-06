package OO;

public class Aplicacao {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Comparador comparador = new Comparador();

        int valor = 6, valor2 = 3;

        System.out.printf("Somar: %d + %d é igual a %d\n", valor, valor2, calc.soma(valor, valor2));
        System.out.printf("Subtrair: %d - %d é igual a %d\n", valor, valor2, calc.subtrai(valor, valor2));
        System.out.printf("Multiplicar: %d * %d é igual a %d\n", valor, valor2, calc.multiplica(valor, valor2));
        System.out.printf("Dividir: %d / %d é igual a %d\n", valor, valor2, calc.divide(valor, valor2));

        System.out.printf("O valor %d é menor que %d? %b\n", valor, valor2, comparador.menorQue(valor, valor2));
    }
}
