
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado.getSigla();
    }

    @Override
    public String toString() {
        return String.format("%s, complemento: %s, bairro: %s, cidade: %s - numero: %02d, estado: %s",
                this.logradouro,
                this.complemento,
                this.bairro,
                this.cidade,
                this.numero,
                getEstado());
    }
}
