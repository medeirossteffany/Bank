import br.com.contas.servicos.Contas.ContaBancaria;
import br.com.contas.servicos.Contas.ContaDolar;
import br.com.contas.servicos.Contas.ContaEuro;
import br.com.contas.servicos.ConversorMoeda.Conversor;
import br.com.contas.servicos.Opcoes.OpcoesLogica;

public class Main {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        ContaDolar contaDolar = new ContaDolar();
        ContaEuro contaEuro = new ContaEuro();
        Conversor conversor = new Conversor(conta, contaDolar, contaEuro);
        OpcoesLogica opcoes = new OpcoesLogica(conta, contaDolar, contaEuro, conversor);
        opcoes.exibirOpcoes();
    }
}
