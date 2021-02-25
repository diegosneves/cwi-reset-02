package br.com.banco.desgraca.domain;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe Transacao registra as operações financeiras, tendo como atributos:
 * Valor da Transação
 * Data da Transação
 * Tipo da Transação(Saque, Depósito ou Transferência)
 */
public class Transacao {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Double valorTransacao;
    private LocalDate dataTransacao;
    private TipoTransacao tipoTransacao;

    public Transacao(Double valorTransacao, LocalDate dataTransacao, TipoTransacao tipoTransacao) {
        this.valorTransacao = valorTransacao;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }

    public LocalDate getDataTransacao() {
        return dataTransacao;
    }

    @Override
    public String toString() {
        return String.format("\t%s\t%s\t%s",
                this.tipoTransacao.getCharReferencia(),
                DecimalFormat.getCurrencyInstance().format(this.valorTransacao),
                dataTransacao.format(FORMATTER));
    }

}
