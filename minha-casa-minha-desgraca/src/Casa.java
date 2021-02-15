public class Casa extends Imovel {
    private boolean patio;

    public Casa(Endereco endereco, double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    /**
     * Método que verifica se o objeto casa possui pátio.
     * @return - Retorna uma String "Com" caso o atributo seja true ou "Sem" caso o atributo seja false.
     */
    private String verificarSeTemPatio() {
        return patio ? "Com" : "Sem";
    }

    @Override
    public String apresentacao() {
        return String.format("Casa [%s] pátio localizado no\n\t\tEndereço: %s \n\t\tNo valor R$%,.2f",
                this.verificarSeTemPatio(), this.getEndereco().toString(), this.getValor());
    }
}
