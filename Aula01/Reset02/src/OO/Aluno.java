package OO;

public class Aluno {

    private String nome;
    private double notaFinal;

    public Aluno(String nome, double notaFinal) {
        this.nome = nome;
        this.notaFinal = notaFinal;
    }

    public Aluno(String nome) {
        this.nome = nome;
        notaFinal = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String validarAprovação() {
        return notaFinal >= 7.0 ? "Aprovado" : "Reprovado";
    }

    public String retornaDados() {
        return String.format("Nome: %s\nNota Final: %.1f\nSituação de Aprovação: %s", nome, notaFinal, validarAprovação());
    }
}
