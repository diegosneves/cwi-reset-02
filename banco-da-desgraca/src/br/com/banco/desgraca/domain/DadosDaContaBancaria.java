package br.com.banco.desgraca.domain;

/**
 * Enumerador usado para facilitar os calculos usando  as taxas definidas nas regras do enunciado.
 */
public enum DadosDaContaBancaria {
    CONTA_CORRENTE("CONTA CORRENTE", 0.0, 0.01, 0.0, 5.0),
    CONTA_POUPANCA("CONTA POUPANÇA", 0.02, 0.0, 0.005, 50.0),
    CONTA_DIGITAL("CONTA DIGITAL", 0.0, 0.01, 10.0, 10.0);

    private String tipoDeConta;
    private Double taxaSaque, taxaTranferenciaOutrasInstituicoes, taxaTranferenciaMesmaInstituicao, valorMinimoSaque;

    DadosDaContaBancaria(String tipoDeConta, Double taxaSaque, Double taxaTranferenciaOutrasInstituicoes, Double taxaTranferenciaMesmaInstituicao, Double valorMinimoSaque) {
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
