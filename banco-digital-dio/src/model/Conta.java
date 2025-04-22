package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	private static int SEQUENCIAL = 1;
	
	protected int numero;
	protected int agencia;
	protected double saldo;
	protected Cliente cliente;
	protected List<Transacao> transacoes;
	
	public Conta(Cliente cliente, int agencia) {
		this.numero = SEQUENCIAL++;
		this.agencia = agencia;
		this.cliente = cliente;
		this.transacoes = new ArrayList<>();
	}
	
	public void depositar(double valor) {
		saldo += valor;
		transacoes.add(new Transacao("Depósito ", valor));
	}
	
	public void sacar (double valor) {
		if (saldo >= valor) {
			saldo -= valor;
			transacoes.add(new Transacao("Saque ", -valor));
		} else {
			System.out.println("Saldo insuficiente!");

		}
	}
	
	public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        transacoes.add(new Transacao("Transferência enviada", -valor));
        contaDestino.transacoes.add(new Transacao("Transferência recebida", valor));
    }

    public void imprimirExtrato() {
        System.out.println("=== Extrato ===");
        for (Transacao t : transacoes) {
            System.out.println(t);
        }
        System.out.println("Saldo atual: " + saldo);
    }

    // Getters
    public int getNumero() { 
    	return numero; 
    	}
    public int getAgencia() {
    	return agencia; 
    	}
    public double getSaldo() { 
    	return saldo; 
    	}
    public Cliente getCliente() { 
    	return cliente;
    	}
	
	
}
