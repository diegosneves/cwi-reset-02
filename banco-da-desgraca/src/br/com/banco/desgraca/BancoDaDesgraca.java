package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;

public class BancoDaDesgraca {

    public static void main(String[] args) {

        ContaBancaria cc1 = new ContaCorrente(123, InstituicaoBancaria.NUBANK);

        cc1.depositar(100.0);
        cc1.sacar(20.0);

        cc1.exibirExtrato(null , null);


    }

}
