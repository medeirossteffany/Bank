package br.com.contas.servicos.ConversorMoeda;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversaoFinanceiraImpl implements ConversaoFinanceira {
    private int valorConversao;
    private static final String API_KEY = "e1156c211a095ea542c841b8";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/e1156c211a095ea542c841b8/latest/";

    public ConversaoFinanceiraImpl(int valor) {
        this.valorConversao = valor;
    }

    public int getValorConversao() {
        return this.valorConversao;
    }

    private double getConversionRate(String fromCurrency, String toCurrency) throws Exception {
        String urlStr = BASE_URL + fromCurrency;
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();
        JsonObject jsonResponse = JsonParser.parseString(content.toString()).getAsJsonObject();
        JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
        if (conversionRates.has(toCurrency)) {
            return conversionRates.get(toCurrency).getAsDouble();
        } else {
            throw new IllegalArgumentException("Invalid currency code");
        }
    }

    public int getConverterDolarParaReal() {
        try {
            double conversionRate = this.getConversionRate("USD", "BRL");
            return (int) (this.valorConversao * conversionRate);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0;
        }
    }

    public int getConverterRealParaDolar() {
        try {
            double conversionRate = this.getConversionRate("BRL", "USD");
            return (int) (this.valorConversao * conversionRate);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0;
        }
    }

    public int getConverterEuroParaReal() {
        try {
            double conversionRate = this.getConversionRate("EUR", "BRL");
            return (int) (this.valorConversao * conversionRate);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0;
        }
    }

    public int getConverterRealParaEuro() {
        try {
            double conversionRate = this.getConversionRate("BRL", "EUR");
            return (int) (this.valorConversao * conversionRate);
        } catch (Exception var3) {
            var3.printStackTrace();
            return 0;
        }
    }
}








