package br.com.banco.desgraca.domain;

/**
 * Enumerador contendo os tipos de transação disponivel(Saque, Despósito e Transferência).
 */
public enum TipoTransacao {

    SAQUE("-"),
    DEPOSITO("+"),
    TRANFERENCIA("-");

    private String charReferencia;

    TipoTransacao(String charReferencia) {
        this.charReferencia = charReferencia;
    }

    public String getCharReferencia() {
        return charReferencia;
    }
}
