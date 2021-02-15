public class PropostaFinanciamento {
    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */

    private Beneficiario beneficiario;
    private Imovel imovel;
    private int prazoDePagamento; //Prazo de Pagamentos deve ser expresso em meses.

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovel, int prazoDePagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovel;
        this.prazoDePagamento = prazoDePagamento;
    }

    public void validarProposta() {
        if(imovel.getEndereco().getEstado().equals("SP")){
            validarParametrosDaRegra(65);
        } else if (imovel.getEndereco().getEstado().equals("RJ")){
            validarParametrosDaRegra(60);
        } else {
            validarParametrosDaRegra(50);
        }
    }

    /**
     * Método para auxiliar o método validarProposta(), validando as regras de negocio.
     * @param porcentagem - Valor informando a porcentagem desejada
     */
    private void validarParametrosDaRegra(double porcentagem) {
        if ((beneficiario.getSalario() * prazoDePagamento) >= (imovel.getValor() * (porcentagem /100.0))) {
            imprimirPropostaAprovada();
        } else {
            imprimirPropostaNegada();
        }
    }

    private void imprimirPropostaAprovada(){
        System.out.printf("Parabéns %s!!! seu financiamento em %02dx para o %s foi APROVADO.\n", beneficiario.getNome(), prazoDePagamento, imovel.apresentacao());
    }

    private void imprimirPropostaNegada(){
        System.out.printf(" %s! Infelizmente seu financiamento em %02dx para o %s foi NEGADO.\n", beneficiario.getNome(), prazoDePagamento, imovel.apresentacao());
    }
}
