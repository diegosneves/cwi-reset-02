package br.com.banco.desgraca.domain;

/**
 * Enumerador usado para facilitar os calculos usando  as taxas definidas nas regras do enunciado.
 */
public enum TaxasTransacoes {
    CC("CONTA CORRENTE", 0.0, 0.01, 0.0, 5.0),
    CP("CONTA POUPANÇA", 0.02, 0.0, 0.005, 50.0),
    CD("CONTA DIGITAL", 0.0, 0.01, 10.0, 10.0);

    private String tipoDeConta;
    private Double taxaSaque, taxaTranferenciaOutrasInstituicoes, taxaTranferenciaMesmaInstituicao, valorMinimoSaque;

    TaxasTransacoes(String tipoDeConta, Double taxaSaque, Double taxaTranferenciaOutrasInstituicoes, Double taxaTranferenciaMesmaInstituicao, Double valorMinimoSaque) {
        this.tipoDeConta = tipoDeConta;
        this.taxaSaque = taxaSaque;
        this.taxaTranferenciaOutrasInstituicoes = taxaTranferenciaOutrasInstituicoes;
        this.taxaTranferenciaMesmaInstituicao = taxaTranferenciaMesmaInstituicao;
        this.valorMinimoSaque = valorMinimoSaque;
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public Double getTaxaSaque() {
        return taxaSaque;
    }

    public Double getTaxaTranferenciaOutrasInstituicoes() {
        return taxaTranferenciaOutrasInstituicoes;
    }

    public Double getValorMinimoSaque() {
        return valorMinimoSaque;
    }
}
