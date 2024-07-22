package br.com.contas.servicos.Contas;

public class ContaDolar extends ContaBancaria {
    private double saldoContaDolar = 0;

    public double getSaldoContaDolar() {
        return saldoContaDolar;
    }

    public void adicionarSaldo(double valor) {
        saldoContaDolar += valor;
    }

    public void subtrairSaldo(double valor) {
        saldoContaDolar -= valor;
    }
}
