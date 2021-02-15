
/**
 * Representa endereços genéricos. Deve ter o logradouro, número, complemento, bairro, cidade e estado (unidade federativa);
 */

public class Endereco {

    private String logradouro, complemento, bairro, cidade;
    private int numero;
    private UnidadeFederativa estado;

    public Endereco(String logradouro, String complemento, String bairro, String cidade, int numero, UnidadeFederativa estado) {
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.estado = estado;
    }

    public String getEstado() {
        return estado.getSigla();
    }

    @Override
    public String toString() {
        return String.format("%s, Complemento: %s, Bairro: %s, Cidade: %s - Numero: %02d, UF: %s",
                this.logradouro,
                this.complemento,
                this.bairro,
                this.cidade,
                this.numero,
                getEstado());
    }
}
