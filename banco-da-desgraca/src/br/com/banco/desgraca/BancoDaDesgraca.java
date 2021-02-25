package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) {

        LocalDate incio = LocalDate.of(2020, 7, 7);
        LocalDate fim = LocalDate.of(2020, 7, 21);

        ContaBancaria cb1 = new ContaDigital(123, InstituicaoBancaria.NUBANK);

        ContaBancaria cb2 = new ContaCorrente(456, InstituicaoBancaria.BRADESCO);

        ContaBancaria cb3 = new ContaPoupanca(789, InstituicaoBancaria.BANCO_DO_BRASIL);

//        ContaBancaria cb4 = new ContaPoupanca(357, InstituicaoBancaria.NUBANK);
//        ContaBancaria cb5 = new ContaDigital(246, InstituicaoBancaria.CAIXA);

        cb1.depositar(100.0);
        cb2.depositar(100.0);
        cb2.sacar(15.0);

        cb1.exibirExtrato(null , null);
        cb2.exibirExtrato(null , null);
        cb3.exibirExtrato(null , null);

        cb1.depositar(20.0);

        System.out.println("CB1 " + DecimalFormat.getCurrencyInstance().format(cb1.consultarSaldo()));
        System.out.println("CB2 " + DecimalFormat.getCurrencyInstance().format(cb2.consultarSaldo()));
        System.out.println("CB3 " + DecimalFormat.getCurrencyInstance().format(cb3.consultarSaldo()));

        cb1.transferir(17.0, cb3);
        cb1.transferir(20.0, cb2);
//        cb3.sacar(50.0);

        System.out.println("CB1 " + cb1.consultarSaldo());
        System.out.println("CB2 " + cb2.consultarSaldo());

        cb1.exibirExtrato(null , null);
        cb2.exibirExtrato(null , null);
        cb3.exibirExtrato(null , null);

        System.out.println("CB1 " + DecimalFormat.getCurrencyInstance().format(cb1.consultarSaldo()));
        System.out.println("CB2 " + DecimalFormat.getCurrencyInstance().format(cb2.consultarSaldo()));
        System.out.println("CB3 " + DecimalFormat.getCurrencyInstance().format(cb3.consultarSaldo()));

        cb1.depositar(21.0);
        cb1.transferir(20.0, cb3);

        cb1.exibirExtrato(incio , fim);
        cb1.exibirExtrato(null , null);
//        cb3.exibirExtrato(null , null);

        System.out.println("CB1 " + DecimalFormat.getCurrencyInstance().format(cb1.consultarSaldo()));
        System.out.println("CB2 " + DecimalFormat.getCurrencyInstance().format(cb2.consultarSaldo()));
        System.out.println("CB3 " + DecimalFormat.getCurrencyInstance().format(cb3.consultarSaldo()));


    }

}
