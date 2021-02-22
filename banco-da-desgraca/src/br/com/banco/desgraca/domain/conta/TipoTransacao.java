package br.com.banco.desgraca.domain.conta;

public enum TipoTransacao {
    //FIXME Verificar a possibilidade de manter esse enumerador ao invés da classe de mesmo nome.
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
