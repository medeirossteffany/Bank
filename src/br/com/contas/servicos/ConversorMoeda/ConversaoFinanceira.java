package br.com.contas.servicos.ConversorMoeda;

public interface ConversaoFinanceira {
    int getConverterRealParaDolar();
    int getConverterEuroParaReal();
    int getConverterDolarParaReal();
    int getConverterRealParaEuro();
    int getValorConversao();
}

