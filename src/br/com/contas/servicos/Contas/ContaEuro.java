package br.com.contas.servicos.Contas;

public class ContaEuro extends ContaBancaria {
    private double saldoContaEuro = 0;

    public double getSaldoContaEuro() {
        return saldoContaEuro;
    }

    public void adicionarSaldo(double valor) {
        saldoContaEuro += valor;
    }

    public void subtrairSaldo(double valor) {
        saldoContaEuro -= valor;
    }
}

