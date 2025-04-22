package service;

import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class BancoService {
    private List<Conta> contas;

    public BancoService() {
        this.contas = new ArrayList<>();
    }

    public void abrirContaCorrente(Cliente cliente, int agencia, double limiteChequeEspecial) {
        Conta conta = new ContaCorrente(cliente, agencia, limiteChequeEspecial);
        contas.add(conta);
        System.out.println("Parabéns!! Sua conta corrente foi aberta com sucesso! Número: " + conta.getNumero());
    }

    public void abrirContaPoupanca(Cliente cliente, int agencia, double taxaRendimento) {
        Conta conta = new ContaPoupanca(cliente, agencia, taxaRendimento);
        contas.add(conta);
        System.out.println("Parabéns!! Sua conta poupança foi aberta com sucesso! Número: " + conta.getNumero());
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas() {
        System.out.println("\n=== Lista de Contas ===");
        for (Conta conta : contas) {
            System.out.println(conta.getCliente().getNome() + " - Ag: " + conta.getAgencia() + 
                               " - CC: " + conta.getNumero() + " - Saldo: " + conta.getSaldo());
        }
    }
}