package br.com.contas.servicos.Opcoes;

import br.com.contas.servicos.Contas.ContaBancaria;
import br.com.contas.servicos.Contas.ContaDolar;
import br.com.contas.servicos.Contas.ContaEuro;
import br.com.contas.servicos.ConversorMoeda.ConversaoFinanceiraImpl;
import br.com.contas.servicos.ConversorMoeda.Conversor;

import java.util.Scanner;

public class OpcoesLogica {

    private ContaBancaria contaBancaria;
    private ContaDolar contaDolar;
    private ContaEuro contaEuro;
    private Conversor conversor;

    public OpcoesLogica(ContaBancaria conta, ContaDolar contaDolar, ContaEuro contaEuro, Conversor conversor) {
        this.contaBancaria = conta;
        this.contaDolar = contaDolar;
        this.contaEuro = contaEuro;
        this.conversor = conversor;
    }

    public void exibirOpcoes() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("DIGITE O NÚMERO DE ALGUMA DAS OPÇÕES ABAIXO");
            System.out.println("1 - CONSULTAR SALDO");
            System.out.println("2 - DEPOSITAR");
            System.out.println("3 - SACAR");
            System.out.println("4 - CONVERTER");
            System.out.println("5 - CONSULTAR SALDO EM DÓLAR");
            System.out.println("6 - CONSULTAR SALDO EM EURO");
            System.out.println("7 - DEPOSITAR EM DÓLAR");
            System.out.println("8 - SACAR EM DÓLAR");
            System.out.println("9 - DEPOSITAR EM EURO");
            System.out.println("10 - SACAR EM EURO");
            System.out.println("11 - CONVERTER PARA REAL");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Saldo: " + contaBancaria.getSaldo());
                    break;
                case "2":
                    System.out.println("Digite o valor para depositar: ");
                    double valorDepositar = Double.parseDouble(scanner.nextLine());
                    contaBancaria.depositar(valorDepositar);
                    System.out.println("Transação bem sucedida.");
                    break;
                case "3":
                    System.out.println("Digite o valor para sacar: ");
                    double valorSacar = Double.parseDouble(scanner.nextLine());
                    contaBancaria.sacar(valorSacar);
                    System.out.println("Transação bem sucedida.");
                    break;
                case "4":
                    System.out.println("Digite o valor que deseja converter:");
                    double valorConverter = Double.parseDouble(scanner.nextLine());
                    System.out.println("Digite para qual moeda deseja converter:");
                    System.out.println("1- DÓLAR");
                    System.out.println("2- EURO");
                    int moeda = Integer.parseInt(scanner.nextLine());
                    conversor.converte(valorConverter, moeda);
                    break;
                case "5":
                    System.out.println("Saldo em Dólar: " + contaDolar.getSaldoContaDolar());
                    break;
                case "6":
                    System.out.println("Saldo em Euro: " + contaEuro.getSaldoContaEuro());
                    break;
                case "7":
                    System.out.println("Digite o valor para depositar em Dólar: ");
                    double valorDepositarDolar = Double.parseDouble(scanner.nextLine());
                    contaDolar.adicionarSaldo(valorDepositarDolar);
                    System.out.println("Transação bem sucedida.");
                    break;
                case "8":
                    System.out.println("Digite o valor para sacar em Dólar: ");
                    double valorSacarDolar = Double.parseDouble(scanner.nextLine());
                    if (contaDolar.getSaldoContaDolar() >= valorSacarDolar) {
                        contaDolar.subtrairSaldo(valorSacarDolar);
                        System.out.println("Transação bem sucedida.");
                    } else {
                        System.out.println("Saldo insuficiente em Dólar.");
                    }
                    break;
                case "9":
                    System.out.println("Digite o valor para depositar em Euro: ");
                    double valorDepositarEuro = Double.parseDouble(scanner.nextLine());
                    contaEuro.adicionarSaldo(valorDepositarEuro);
                    System.out.println("Transação bem sucedida.");
                    break;
                case "10":
                    System.out.println("Digite o valor para sacar em Euro: ");
                    double valorSacarEuro = Double.parseDouble(scanner.nextLine());
                    if (contaEuro.getSaldoContaEuro() >= valorSacarEuro) {
                        contaEuro.subtrairSaldo(valorSacarEuro);
                        System.out.println("Transação bem sucedida.");
                    } else {
                        System.out.println("Saldo insuficiente em Euro.");
                    }
                    break;
                case "11":
                    System.out.println("Digite o valor que deseja converter:");
                    double valorConverterParaReal = Double.parseDouble(scanner.nextLine());
                    conversor.converteParaReal(new ConversaoFinanceiraImpl((int) valorConverterParaReal));
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}
