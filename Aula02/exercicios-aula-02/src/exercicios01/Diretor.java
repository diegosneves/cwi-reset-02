package exercicios01;

public class Diretor {

    private String nome;
    private int idade;
    private int qtdeDeFilmesProduzidos;

    public Diretor(String nome, int idade, int qtdeDeFilmesProduzidos) {
        this.nome = nome;
        this.idade = idade;
        this.qtdeDeFilmesProduzidos = qtdeDeFilmesProduzidos;
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

    public int getQtdeDeFilmesProduzidos() {
        return qtdeDeFilmesProduzidos;
    }

    public void setQtdeDeFilmesProduzidos(int qtdeDeFilmesProduzidos) {
        this.qtdeDeFilmesProduzidos = qtdeDeFilmesProduzidos;
    }

    @Override
    public String toString() {
        return "Diretor{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", qtdeDeFilmesProduzidos=" + qtdeDeFilmesProduzidos +
                '}';
    }
}
