package br.com.contas.servicos.Contas;

import java.time.LocalDate;

public class ContaBancaria {
    protected double saldo = 1000.0;

    public void depositar(double valorDepositar) {
        if (valorDepositar <= 0.0) {
            System.out.println("Valor inválido para depósito.");
        } else {
            this.saldo += valorDepositar;
            System.out.println("Depósito de R$ " + valorDepositar + " realizado com sucesso. Saldo atual: R$ " + this.saldo);
        }
    }

    public void sacar(double valorSacar) {
        if (valorSacar > 0.0 && this.saldo >= valorSacar) {
            this.saldo -= valorSacar;
            System.out.println("Saque de R$ " + valorSacar + " realizado com sucesso. Saldo atual: R$ " + this.saldo);
        } else if (valorSacar <= 0.0) {
            System.out.println("Valor de saque inválido.");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void cobrarTarifaMensal() {
        LocalDate dataAtual = LocalDate.now();
        int diaAtual = dataAtual.getDayOfMonth();
        if (diaAtual == 30) {
            this.saldo -= 50.0;
            System.out.println("Tarifa mensal cobrada em " + dataAtual + ". Saldo atual: R$ " + this.saldo);
        } else {
            System.out.println("Tarifa será cobrada no próximo dia 30.");
        }
    }
}
