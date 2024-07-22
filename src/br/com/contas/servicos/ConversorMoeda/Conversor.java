package br.com.contas.servicos.ConversorMoeda;

import br.com.contas.servicos.Contas.ContaBancaria;
import br.com.contas.servicos.Contas.ContaDolar;
import br.com.contas.servicos.Contas.ContaEuro;

import java.util.Scanner;

public class Conversor {
    private ContaBancaria contaBancaria;
    private ContaDolar contaDolar;
    private ContaEuro contaEuro;

    public Conversor(ContaBancaria contaBancaria, ContaDolar contaDolar, ContaEuro contaEuro) {
        this.contaBancaria = contaBancaria;
        this.contaDolar = contaDolar;
        this.contaEuro = contaEuro;
    }

    public void converteParaReal(ConversaoFinanceira conversor) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a moeda que deseja converter para Real:");
        System.out.println("1- DÓLAR");
        System.out.println("2- EURO");
        int moeda = Integer.parseInt(scanner.nextLine());

        double valorConversao = conversor.getValorConversao();

        if (moeda == 1) {
            double calculoReal = conversor.getConverterDolarParaReal();
            if (contaDolar.getSaldoContaDolar() >= valorConversao) {
                contaDolar.subtrairSaldo(valorConversao);
                contaBancaria.depositar(calculoReal);
                System.out.println("Conversão bem sucedida.");
            } else {
                System.out.println("Saldo insuficiente em Dólar.");
            }
        } else if (moeda == 2) {
            double calculoReal = conversor.getConverterEuroParaReal();
            if (contaEuro.getSaldoContaEuro() >= valorConversao) {
                contaEuro.subtrairSaldo(valorConversao);
                contaBancaria.depositar(calculoReal);
                System.out.println("Conversão bem sucedida.");
            } else {
                System.out.println("Saldo insuficiente em Euro.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public void converte(double valorConversao, int moeda) {
        if (moeda == 1) {
            ConversaoFinanceira conversor = new ConversaoFinanceiraImpl((int)valorConversao);
            int calculoDolar = conversor.getConverterRealParaDolar();
            contaDolar.adicionarSaldo(calculoDolar);
            System.out.println("A conversão é: " + calculoDolar + " Dólares");
            System.out.println("Deseja realizar a conversão?");
            System.out.println("1 - Sim, converter");
            System.out.println("2 - Não, finalizar");
            Scanner scanner = new Scanner(System.in);
            int descontarOpcao = Integer.parseInt(scanner.nextLine());
            if (descontarOpcao == 1 && contaBancaria.getSaldo() >= valorConversao) {
                contaBancaria.sacar(valorConversao);
                System.out.println("Conversão realizada com sucesso.");
            } else {
                System.out.println("Conversão não realizada.");
            }
        } else if (moeda == 2) {
            ConversaoFinanceira conversor = new ConversaoFinanceiraImpl((int)valorConversao);
            int calculoEuro = conversor.getConverterRealParaEuro();
            contaEuro.adicionarSaldo(calculoEuro);
            System.out.println("A conversão é: " + calculoEuro + " Euros");
            System.out.println("Deseja realizar a conversão?");
            System.out.println("1 - Sim, converter");
            System.out.println("2 - Não, finalizar");
            Scanner scanner = new Scanner(System.in);
            int descontarOpcao = Integer.parseInt(scanner.nextLine());
            if (descontarOpcao == 1 && contaBancaria.getSaldo() >= valorConversao) {
                contaBancaria.sacar(valorConversao);
                System.out.println("Conversão realizada com sucesso.");
            } else {
                System.out.println("Conversão não realizada.");
            }
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
