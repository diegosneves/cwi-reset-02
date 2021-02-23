package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;

public class BancoDaDesgraca {

    public static void main(String[] args) {

        ContaBancaria cc1 = new ContaCorrente(123, InstituicaoBancaria.NUBANK);
        ContaBancaria cc2 = new ContaCorrente(456, InstituicaoBancaria.BRADESCO);
        ContaBancaria cc3 = new ContaCorrente(789, InstituicaoBancaria.NUBANK);

        cc1.depositar(100.0);
        cc1.sacar(20.0);

        cc1.exibirExtrato(null , null);
        cc2.exibirExtrato(null , null);
        cc1.depositar(20.0);

        System.out.println("CC1 " + cc1.consultarSaldo());
        System.out.println("CC2 " + cc2.consultarSaldo());

        cc1.transferir(20.0, cc2);

        System.out.println("CC1 " + cc1.consultarSaldo());
        System.out.println("CC2 " + cc2.consultarSaldo());

        cc1.exibirExtrato(null , null);
        cc2.exibirExtrato(null , null);

        cc1.depositar(21.0);
        cc1.transferir(20.0, cc3);


    }

}
