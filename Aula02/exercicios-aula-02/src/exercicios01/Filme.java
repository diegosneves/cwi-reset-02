package exercicios01;

import java.util.List;

public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int anoDeLancamento;
    private int notaDeAvaliacao;
    private List <Pessoa> elenco;

    public Filme(String nome, String descricao, int duracao, int anoDeLancamento, int notaDeAvaliacao, List<Pessoa> elenco) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        validarValorDaAvaliacao(nome, notaDeAvaliacao);
        this.elenco = elenco;
    }

    public Filme(String nome, String descricao, int duracao, int anoDeLancamento, List<Pessoa> elenco) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoDeLancamento = anoDeLancamento;
        validarValorDaAvaliacao(nome);
        this.elenco = elenco;
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
        //TODO Modificar para informar dados do Diretor
        System.out.printf("Nome do Filme: %s\nDescrição: %s\nDuração: %02d min\n",
                this.nome,
                this.descricao,
                this.duracao);
    }

    public void exibirCreditos() {
        //TODO Modificar para melhorar as informacoes(formatação) da tela.
        for(Pessoa ator : elenco){
            System.out.println(ator.toString());
        }
    }

    @Override
    public String toString() {
        //TODO Modificar para informar dados do Diretor
        return String.format("Nome do Filme: %s\nDescrição: %s\nDuração: %02d min\nAno de Lançamento: %04d\nAvaliação: Nota %02d\nDiretor do Filme:\n%s",
                this.nome,
                this.descricao,
                this.duracao,
                this.anoDeLancamento,
                this.notaDeAvaliacao);
    }
}
