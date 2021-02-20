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

    public Pessoa validarDiretorDoElenco() {
        for (Pessoa integranteDoElenco : elenco) {
            if(integranteDoElenco instanceof Diretor){
                return integranteDoElenco;
            }
        }
        return null;
    }

    public String dadosDoDiretor() {
        return (validarDiretorDoElenco() != null ? validarDiretorDoElenco().toString() : "Filme Sem Diretor!");
    }

    public void reproduzir() {
        System.out.println("=================FILME==================");
        System.out.printf("Nome do Filme: %s\nDescrição: %s\nDuração: %02d min\n\tDiretor do Filme: \n%s\n",
                this.nome,
                this.descricao,
                this.duracao,
                dadosDoDiretor());
    }

    public void exibirCreditos() {
        String diretor = "";
        System.out.println("=================ATORES==================");
        for(Pessoa ator : elenco){
            if (ator instanceof Diretor){
                diretor += ator.toString();
            } else {
                System.out.println(ator.toString());
            }
        }
        System.out.println("=================DIRETOR==================");
        System.out.println(diretor);
    }

    @Override
    public String toString() {
        return String.format("Nome do Filme: %s\nDescrição: %s\nDuração: %02d min\nAno de Lançamento: %04d\nAvaliação: Nota %02d\nDiretor do Filme:\n%s",
                this.nome,
                this.descricao,
                this.duracao,
                this.anoDeLancamento,
                this.notaDeAvaliacao,
                dadosDoDiretor());
    }
}
