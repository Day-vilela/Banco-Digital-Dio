import model.Cliente;
import model.Conta;
import service.BancoService;
import service.ContaService;
import util.ValidacaoUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BancoService bancoService = new BancoService();
        ContaService contaService = new ContaService();
        Scanner scanner = new Scanner(System.in);
        
        // Menu principal
        while (true) {
            System.out.println("\n=== Banco Digital ===");
            System.out.println("1. Abrir Conta Corrente");
            System.out.println("2. Abrir Conta Poupança");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Transferir");
            System.out.println("6. Consultar Saldo");
            System.out.println("7. Extrato");
            System.out.println("8. Listar Contas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer
            
            switch (opcao) {
                case 1: // Abrir Conta Corrente
                    System.out.println("\n--- Abertura de Conta Corrente ---");
                    System.out.print("Nome: ");
                    String nomeCc = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfCc = scanner.nextLine();
                    if (!ValidacaoUtils.validarCPF(cpfCc)) {
                        System.out.println("CPF inválido!");
                        break;
                    }
                    System.out.print("Data Nascimento (dd/MM/yyyy): ");
                    String dataNascCc = scanner.nextLine();
                    System.out.print("Agência: ");
                    int agenciaCc = scanner.nextInt();
                    System.out.print("Limite Cheque Especial: ");
                    double limite = scanner.nextDouble();
                    
                    Cliente clienteCc = new Cliente(nomeCc, cpfCc, dataNascCc);
                    bancoService.abrirContaCorrente(clienteCc, agenciaCc, limite);
                    break;
                    
                case 2: // Abrir Conta Poupança
                    System.out.println("\n--- Abertura de Conta Poupança ---");
                    System.out.print("Nome: ");
                    String nomeCp = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfCp = scanner.nextLine();
                    if (!ValidacaoUtils.validarCPF(cpfCp)) {
                        System.out.println("CPF inválido!");
                        break;
                    }
                    System.out.print("Data Nascimento (dd/MM/yyyy): ");
                    String dataNascCp = scanner.nextLine();
                    System.out.print("Agência: ");
                    int agenciaCp = scanner.nextInt();
                    System.out.print("Taxa de Rendimento (%): ");
                    double taxa = scanner.nextDouble();
                    
                    Cliente clienteCp = new Cliente(nomeCp, cpfCp, dataNascCp);
                    bancoService.abrirContaPoupanca(clienteCp, agenciaCp, taxa/100);
                    break;
                    
                case 3: // Depositar
                    System.out.println("\n--- Depósito ---");
                    System.out.print("Número da conta: ");
                    int numContaDep = scanner.nextInt();
                    Conta contaDep = bancoService.buscarContaPorNumero(numContaDep);
                    
                    if (contaDep != null) {
                        System.out.print("Valor do depósito: ");
                        double valorDep = scanner.nextDouble();
                        contaService.depositar(contaDep, valorDep);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 4: // Sacar
                    System.out.println("\n--- Saque ---");
                    System.out.print("Número da conta: ");
                    int numContaSaq = scanner.nextInt();
                    Conta contaSaq = bancoService.buscarContaPorNumero(numContaSaq);
                    
                    if (contaSaq != null) {
                        System.out.print("Valor do saque: ");
                        double valorSaq = scanner.nextDouble();
                        contaService.sacar(contaSaq, valorSaq);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 5: // Transferir
                    System.out.println("\n--- Transferência ---");
                    System.out.print("Número da conta origem: ");
                    int numContaOrig = scanner.nextInt();
                    Conta contaOrig = bancoService.buscarContaPorNumero(numContaOrig);
                    
                    if (contaOrig != null) {
                        System.out.print("Número da conta destino: ");
                        int numContaDest = scanner.nextInt();
                        Conta contaDest = bancoService.buscarContaPorNumero(numContaDest);
                        
                        if (contaDest != null) {
                            System.out.print("Valor da transferência: ");
                            double valorTransf = scanner.nextDouble();
                            contaService.transferir(contaOrig, contaDest, valorTransf);
                        } else {
                            System.out.println("Conta destino não encontrada!");
                        }
                    } else {
                        System.out.println("Conta origem não encontrada!");
                    }
                    break;
                    
                case 6: // Consultar Saldo
                    System.out.println("\n--- Consulta de Saldo ---");
                    System.out.print("Número da conta: ");
                    int numContaSaldo = scanner.nextInt();
                    Conta contaSaldo = bancoService.buscarContaPorNumero(numContaSaldo);
                    
                    if (contaSaldo != null) {
                        contaService.consultarSaldo(contaSaldo);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 7: // Extrato
                    System.out.println("\n--- Extrato ---");
                    System.out.print("Número da conta: ");
                    int numContaExtrato = scanner.nextInt();
                    Conta contaExtrato = bancoService.buscarContaPorNumero(numContaExtrato);
                    
                    if (contaExtrato != null) {
                        contaService.imprimirExtrato(contaExtrato);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                    
                case 8: // Listar Contas
                    System.out.println("\n--- Listagem de Contas ---");
                    bancoService.listarContas();
                    break;
                    
                case 0: // Sair
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}