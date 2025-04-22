package service;

import model.Conta;

public class ContaService {
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(Conta conta, double valor) {
        conta.sacar(valor);
        System.out.println("Saque realizado com sucesso!");
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        origem.transferir(valor, destino);
        System.out.println("Transferência realizada com sucesso!");
    }

    public void consultarSaldo(Conta conta) {
        System.out.println("Saldo atual: " + conta.getSaldo());
    }

    public void imprimirExtrato(Conta conta) {
        conta.imprimirExtrato();
    }
}