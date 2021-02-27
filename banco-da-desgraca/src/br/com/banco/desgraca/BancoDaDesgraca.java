package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.conta.ContaBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;
import br.com.banco.desgraca.exception.InstituicaoBancariaInvalidaException;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;
import br.com.banco.desgraca.exception.ValorInvalidoException;
//import br.com.banco.desgraca.exception.ValorSaqueInvalidoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;

import static br.com.banco.desgraca.domain.InstituicaoBancaria.*;
import static java.text.DecimalFormat.getCurrencyInstance;
import static java.util.Arrays.asList;

public class BancoDaDesgraca {

    private static final Collection<ContaBancaria> CONTAS = new ArrayList();
    private static final Collection<ContaBancaria> CONTAS_CORRENTE = new ArrayList();
    private static final Collection<ContaBancaria> CONTAS_POUPANCA = new ArrayList();
    private static final Collection<ContaBancaria> CONTAS_DIGITAL = new ArrayList();

    public static void main(String[] args) throws Exception {

        System.out.println("\n > Criando contas bancárias...");

        ContaBancaria bbCc = new ContaCorrente(123 ,BANCO_DO_BRASIL);
        ContaBancaria bradescoCc = new ContaCorrente(234, BRADESCO);
        ContaBancaria caixaCc = new ContaCorrente(345, CAIXA);
        ContaBancaria itauCc = new ContaCorrente(456, ITAU);
        ContaBancaria nubankCc = new ContaCorrente(567, NUBANK);
        CONTAS_CORRENTE.addAll(asList(bbCc, bradescoCc, caixaCc, itauCc, nubankCc));

        ContaBancaria bbPoupanca = new ContaPoupanca(678, BANCO_DO_BRASIL);
        ContaBancaria bradescoPoupanca = new ContaPoupanca(789, BRADESCO);
        ContaBancaria caixaPoupanca = new ContaPoupanca(978,CAIXA);
        ContaBancaria itauPoupanca = new ContaPoupanca(876, ITAU);
        CONTAS_POUPANCA.addAll(asList(bbPoupanca, bradescoPoupanca, caixaPoupanca, itauPoupanca));

        ContaBancaria itauDigital = new ContaDigital(756, ITAU);
        ContaBancaria nubankDigital = new ContaDigital(654, NUBANK);
        CONTAS_DIGITAL.addAll(asList(itauDigital, nubankDigital));

        CONTAS.addAll(CONTAS_CORRENTE);
        CONTAS.addAll(CONTAS_POUPANCA);
        CONTAS.addAll(CONTAS_DIGITAL);


        ///


        System.out.println("\n > Verificando contas que não podem ser criadas...");
        verificarContasQueNaoPodemSerCriadas();


        ///


        System.out.println("\n > Depositando R$ 1000,00 em cada conta...");
        CONTAS.forEach(conta -> conta.depositar(1000.0));
        // > cc = 1000
        // > digital = 1000
        // > poupanca = 1000


        ///


        System.out.println("\n > Sacando R$ 100,00 de cada conta...");
        CONTAS.forEach(conta -> conta.sacar(100.0));
        // > cc = 900
        // > digital = 900
        // > poupanca = 898


        ///


        System.out.println("\n > Verificando saques com valores menores do que o permitido...");
        verificarSaqueInvalidosMenores();


        ///


        System.out.println("\n > Transferindo R$ 10,00 de cada conta digital para cada conta corrente...");
        CONTAS_DIGITAL.forEach(digital ->
                CONTAS_CORRENTE.forEach(cc ->
                        digital.transferir(10.0, cc)));
        // > cc = 920
        // > digital = 850
        // > poupanca = 898


        ///


        System.out.println("\n > Transferindo R$ 10,00 de cada conta corrente para cada conta poupança...");
        CONTAS_CORRENTE.forEach(cc ->
                CONTAS_POUPANCA.forEach(poupanca ->
                        cc.transferir(10.0, poupanca)));
        // > cc (nubank) = 879.6
        // > cc (outros) = 879.7
        // > digital = 850
        // > poupanca = 948


        ///


        System.out.println("\n > Transferindo R$ 10,00 de cada conta poupança para cada conta digital...");
        CONTAS_POUPANCA.forEach(poupanca ->
                CONTAS_DIGITAL.forEach(digital ->
                        poupanca.transferir(10.0, digital)));
        // > cc (nubank) = 879.6
        // > cc (outros) = 879.7
        // > digital = 890
        // > poupanca (itaú) = 927.85
        // > poupanca (outros) = 927.8


        ///


        System.out.println("\n > Tentando sacar valores maiores do que o saldo...");
        verificarSaquesMaioresDoQueSaldo();


        ///


        System.out.println("\n > Verificando extrato da Conta Digital Nubank no período de 01/01/2021 a 31/01/2021 (devem aparecer 3 registros)...");
        nubankDigital.exibirExtrato(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 31));


        ///


        System.out.println("\n > Verificando o saldo das contas...");
        verificarSaldo(bbCc, 879.70);
        verificarSaldo(bradescoCc, 879.70);
        verificarSaldo(caixaCc, 879.70);
        verificarSaldo(itauCc, 879.70);
        verificarSaldo(nubankCc, 879.60);
        verificarSaldo(bbPoupanca, 927.80);
        verificarSaldo(bradescoPoupanca, 927.80);
        verificarSaldo(caixaPoupanca, 927.80);
        verificarSaldo(itauPoupanca, 927.85);
        verificarSaldo(itauDigital, 890.00);
        verificarSaldo(nubankDigital, 890.00);

        System.out.println("\n\n\nPROGRAMA VALIDADO COM SUCESSO! PARABÉNS! :D\n\n");
    }

    private static void verificarSaldo(ContaBancaria conta, Double saldoEsperado) {

        BigDecimal saldoConta = new BigDecimal(conta.consultarSaldo()).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal saldoReal = new BigDecimal(saldoEsperado).setScale(2, RoundingMode.HALF_EVEN);

        if (saldoConta.compareTo(saldoReal) != 0) {
            throw new RuntimeException("Atenção, saldo incorreto! O saldo da conta " + conta + " deveria ser " + getCurrencyInstance().format(saldoEsperado) +
                    ", mas atualmente é " + getCurrencyInstance().format(conta.consultarSaldo()));
        }
    }

    private static void verificarContasQueNaoPodemSerCriadas() {

        contaInvalida(() -> new ContaDigital(123, BANCO_DO_BRASIL));
        contaInvalida(() -> new ContaDigital(234, BRADESCO));
        contaInvalida(() -> new ContaDigital(345, CAIXA));

        contaInvalida(() -> new ContaPoupanca(456, NUBANK));
    }

    private static void contaInvalida(Supplier<ContaBancaria> conta) {

        try {
            ContaBancaria cb = conta.get();
            throw new RuntimeException("Atenção! Não deveria ser possível criar a " + cb);
        } catch (InstituicaoBancariaInvalidaException ibie) {
        }
    }

    private static void verificarSaqueInvalidosMenores() {

        saqueInvalido(CONTAS_DIGITAL.iterator().next(), 9.99);

        double valorCc = 0.0;
        while (valorCc < 1 || valorCc % 5 == 0) {
            valorCc = (new Random().nextDouble() * 200) + 1;
        }
        saqueInvalido(CONTAS_CORRENTE.iterator().next(), valorCc);

        saqueInvalido(CONTAS_POUPANCA.iterator().next(), new Random().nextDouble() * 50);
    }

    private static void saqueInvalido(ContaBancaria conta, Double valor) {

        try {
            conta.sacar(valor);
            throw new RuntimeException("Atenção! Não deveria ser possível sacar " + getCurrencyInstance().format(valor) + " de " + conta);
        } catch (ValorInvalidoException vsie) {
            System.out.println("  X Saque cancelado: " + vsie.getMessage());
        }
    }

    private static void verificarSaquesMaioresDoQueSaldo() {

        CONTAS_CORRENTE.forEach(conta -> saldoInvalido(conta, 880.0));

        CONTAS_DIGITAL.forEach(conta -> saldoInvalido(conta, 890.01));

        CONTAS_POUPANCA.forEach(conta -> saldoInvalido(conta, conta.getInstituicaoBancaria() == ITAU ? 927.86 : 927.81));
    }

    private static void saldoInvalido(ContaBancaria conta, Double valor) {

        try {
            conta.sacar(valor);
            throw new RuntimeException("Atenção! Não deveria ser possível sacar " + getCurrencyInstance().format(valor) + " de " + conta);
        } catch (SaldoInsuficienteException sie) {
            System.out.println("  X Saque cancelado: " + sie.getMessage());
        }
    }
}