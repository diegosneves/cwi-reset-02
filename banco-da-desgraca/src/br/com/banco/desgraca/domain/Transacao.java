package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.TransacaoTipos;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Double valorTransacao;
    private LocalDate dataTransacao;
    private TransacaoTipos transacaoTipos;

    public Transacao(Double valorTransacao, LocalDate dataTransacao, TransacaoTipos transacaoTipos) {
        this.valorTransacao = valorTransacao;
        this.dataTransacao = dataTransacao;
        this.transacaoTipos = transacaoTipos;
    }

//    private String formatValorTransacao() {
//        //FIXME Verificar a necessidade deste método.
//        return DecimalFormat.getCurrencyInstance().format(this.valorTransacao);
//    }

//    private String formatDataTransacao() {
//        //FIXME Verificar a necessidade deste método.
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        return LocalDate.parse(dataTransacao.toString(), FORMATTER).toString();
//    }

    @Override
    public String toString() {
        return String.format("\t%s\t%s\t%s",
                this.transacaoTipos.getCharReferencia(),
                DecimalFormat.getCurrencyInstance().format(this.valorTransacao),
                dataTransacao.format(FORMATTER));
    }

}
