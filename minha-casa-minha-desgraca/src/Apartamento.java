public class Apartamento extends Imovel {

    private int andar;

    public Apartamento(Endereco endereco, double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    @Override
    public String apresentacao() {
        return String.format("Apartamento no [%dº andar] localizado no\n\t\tEndereço: %s \n\t\tNo valor R$%,.2f",
                this.andar, this.getEndereco().toString(), this.getValor());
    }
}
