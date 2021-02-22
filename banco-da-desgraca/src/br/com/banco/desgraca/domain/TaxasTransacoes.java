package br.com.banco.desgraca.domain;

/**
 * Enumerador para facilitar os calculos usando os atributos com os valores setados conforme as regras.
 */
public enum TaxasTransacoes {
    CC("Conta Corrente", 0.0, 0.01, 0.0, 5.0),
    CP("Conta Poupança", 0.02, 0.0, 0.005, 50.0),
    CD("Conta Digital", 0.0, 0.01, 10.0, 10.0);

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
