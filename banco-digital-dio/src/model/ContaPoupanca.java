package model;

public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(Cliente cliente, int agencia, double taxaRendimento) {
        super(cliente, agencia);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        transacoes.add(new Transacao("Rendimento", rendimento));
    }
}