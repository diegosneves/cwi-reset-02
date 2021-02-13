package exercicios01;

public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int anoDeLancamento;
    private int notaDeAvaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int anoDeLancamento, int notaDeAvaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        validarValorDaAvaliacao(nome, notaDeAvaliacao);
        this.diretor = diretor;
    }

    public Filme(String nome, String descricao, int duracao, int anoDeLancamento, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        validarValorDaAvaliacao(nome);
        this.diretor = diretor;
    }

    private void validarValorDaAvaliacao(String nome, int notaDaAvaliacao) {
        if (nome.equals("Clube da Luta")) {
            this.notaDeAvaliacao = 5;
        } else if (nome.equals("Batman vs Superman")) {
            this.notaDeAvaliacao = 1;
        } else if(notaDaAvaliacao >= 1 && notaDaAvaliacao <= 5) {
            this.notaDeAvaliacao = notaDaAvaliacao;
        } else {
            this.notaDeAvaliacao = 3;
        }
    }

    private void validarValorDaAvaliacao(String nome) {
        if (nome.equals("Clube da Luta")) {
            this.notaDeAvaliacao = 5;
        } else if (nome.equals("Batman vs Superman")) {
            this.notaDeAvaliacao = 1;
        } else {
            this.notaDeAvaliacao = 3;
        }
    }

    public void reproduzir() {
        System.out.printf("Nome do Filme: %s\nDescrição: %s\nDuração: %02d min\nDiretor:\n\tNome: %s\n",
                this.nome,
                this.descricao,
                this.duracao,
                this.diretor.getNome());
    }

    @Override
    public String toString() {
        return String.format("Nome do Filme: %s\nDescrição: %s\nDuração: %02d min\nAno de Lançamento: %04d\nAvaliação: Nota %02d\nDiretor do Filme:\n%s",
                this.nome,
                this.descricao,
                this.duracao,
                this.anoDeLancamento,
                this.notaDeAvaliacao,
                this.diretor.toString());
    }
}
