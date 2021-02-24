package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) {

        LocalDate incio = LocalDate.of(2020, 7, 7);
        LocalDate fim = LocalDate.of(2020, 7, 21);

        ContaBancaria cc1 = new ContaDigital(123, InstituicaoBancaria.NUBANK);
        ContaBancaria cc2 = new ContaCorrente(456, InstituicaoBancaria.BRADESCO);
        ContaBancaria cc3 = new ContaPoupanca(789, InstituicaoBancaria.BANCO_DO_BRASIL);

        cc1.depositar(100.0);
//        cc1.sacar(20.0);

//        cc1.exibirExtrato(null , null);
//        cc2.exibirExtrato(null , null);
//        cc1.depositar(20.0);

        System.out.println("CC1 " + cc1.consultarSaldo());
        System.out.println("CC2 " + cc2.consultarSaldo());
//        System.out.println("CC3 " + cc3.consultarSaldo());

        cc1.transferir(20.0, cc2);
//        cc1.transferir(20.0, cc3);

//        System.out.println("CC1 " + cc1.consultarSaldo());
//        System.out.println("CC2 " + cc2.consultarSaldo());

//        cc1.exibirExtrato(null , null);
//        cc2.exibirExtrato(null , null);
//        cc3.exibirExtrato(null , null);

        System.out.println("CC1 " + cc1.consultarSaldo());
        System.out.println("CC2 " + cc2.consultarSaldo());
//        System.out.println("CC3 " + cc3.consultarSaldo());
//
        cc1.depositar(21.0);
//        cc1.transferir(20.0, cc3);
//
        cc1.exibirExtrato(incio , fim);
        cc1.exibirExtrato(null , null);
//        cc3.exibirExtrato(null , null);
//
        System.out.println("CC1 " + cc1.consultarSaldo());
//        System.out.println("CC3 " + cc3.consultarSaldo());


    }

}
