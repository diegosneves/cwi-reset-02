package exercicios01;

public class Ator {

    private String nome;
    private int idade, qtdeOscarVencidos;
    private Genero genero;

    public Ator(String nome, int idade, int qtdeOscarVencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.qtdeOscarVencidos = qtdeOscarVencidos;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getQtdeOscarVencidos() {
        return qtdeOscarVencidos;
    }

    public void setQtdeOscarVencidos(int qtdeOscarVencidos) {
        this.qtdeOscarVencidos = qtdeOscarVencidos;
    }

    public String getGenero() {
        return genero.getDescricao();
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void exibirDados() {
        System.out.printf("Nome: %s\nIdade: %02d\nGenero: %s\n",
                this.nome,
                this.idade,
                getGenero());
    }
}
