package exercicios01;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    private LocalDate idade;
    private Genero genero;

    public Pessoa(String nome, LocalDate idade, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getIdade() {
        return idade;
    }

    public void setIdade(LocalDate idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero.getDescricao();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer calculaIdade() {
        return LocalDate.now().compareTo(idade);
    }

    public void exibirDados() {
        System.out.printf("Nome: %s\nIdade: %02d\nGenero: %s\n",
                this.nome,
                calculaIdade(),
                getGenero());
    }
}
