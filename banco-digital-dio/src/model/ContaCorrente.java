package model;

public class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, int agencia, double limiteChequeEspecial) {
        super(cliente, agencia);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            transacoes.add(new Transacao("Saque", -valor));
        } else {
            System.out.println("Saldo + limite insuficiente!");
        }
    }
}