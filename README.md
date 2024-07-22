# Projeto de Conversão e Gerenciamento de Contas

Este projeto é uma aplicação Java que permite a conversão de valores entre diferentes moedas (Real, Dólar e Euro) e o gerenciamento de contas bancárias, incluindo operações de depósito, saque e consulta de saldo.

## Estrutura do Projeto

O projeto está organizado em vários pacotes, cada um responsável por uma funcionalidade específica:

- `br.com.contas.servicos.Contas`: Contém as classes relacionadas às contas bancárias.
- `br.com.contas.servicos.ConversorMoeda`: Contém as classes e interfaces relacionadas à conversão de moedas.
- `br.com.contas.servicos.Opcoes`: Contém a classe responsável por exibir as opções e interagir com o usuário.

## Dependências

- `com.google.code.gson`: Biblioteca utilizada para manipulação de JSON.

## Classes Principais

### `ContaBancaria`

Representa uma conta bancária com funcionalidades básicas de depósito, saque e consulta de saldo. Também possui um método para cobrar uma tarifa mensal.

### `ContaDolar` e `ContaEuro`

Subclasses de `ContaBancaria` que representam contas em Dólar e Euro, respectivamente. Possuem métodos específicos para adicionar e subtrair saldo em suas respectivas moedas.

### `ConversaoFinanceira`

Interface que define os métodos de conversão entre diferentes moedas.

### `ConversaoFinanceiraImpl`

Implementação da interface `ConversaoFinanceira` que utiliza uma API de taxa de câmbio para realizar as conversões entre moedas.

### `Conversor`

Classe responsável por realizar as conversões entre diferentes moedas e atualizar os saldos das contas correspondentes.

### `OpcoesLogica`

Classe responsável por exibir as opções disponíveis para o usuário e interagir com ele para realizar as operações desejadas.

## Como Executar

1. Importe o projeto em sua IDE preferida (como IntelliJ IDEA, Eclipse, NetBeans, etc.).
2. Execute a classe `Main` diretamente a partir da IDE.
