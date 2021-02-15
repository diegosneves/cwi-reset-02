/**
 * Representa a pessoa que está querendo fazer o financiamento. Deve ter um nome e um salário;
 */
public class Beneficiario {

    private String nome;
    private double salario;

    public Beneficiario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

}
