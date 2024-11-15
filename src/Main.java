import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();
        Cliente clienteLogado = null;

        while (true) {
            System.out.println("Bem-vindo ao Banco Simples!");
            System.out.println("Digite 1 para Login ou 2 para Cadastro de novo usuário:");
            int opcaoInicial = scanner.nextInt();
            scanner.nextLine();

            if (opcaoInicial == 2) {
                System.out.print("Digite seu nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite seu CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Digite sua senha: ");
                int senha = scanner.nextInt();
                scanner.nextLine();

                banco.cadastrarCliente(nome, cpf, senha);
                System.out.println("Cadastro realizado com sucesso! Agora faça o login.");
            }

            boolean autenticado = false;
            while (!autenticado) {
                System.out.print("Digite seu CPF: ");
                String cpfLogin = scanner.nextLine();
                System.out.print("Digite sua senha: ");
                int senhaLogin = scanner.nextInt();
                scanner.nextLine();

                clienteLogado = banco.autenticarCliente(cpfLogin, senhaLogin);
                if (clienteLogado != null) {
                    autenticado = true;
                    System.out.println("Login bem-sucedido!");
                } else {
                    System.out.println("CPF ou senha inválidos. Redirecionando para cadastro...");
                    break;
                }
            }

            while (autenticado) {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Depositar");
                System.out.println("3. Sacar");
                System.out.println("4. Transferir");
                System.out.println("5. Deslogar");
                System.out.println("6. Sair");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    System.out.print("Digite o número da conta para consultar o saldo: ");
                    int numeroConta = scanner.nextInt();
                    Conta conta = clienteLogado.buscarConta(numeroConta);
                    if (conta != null) {
                        conta.consultarSaldo();
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                } else if (opcao == 2) {
                    System.out.print("Digite o número da conta para depósito: ");
                    int numeroConta = scanner.nextInt();
                    Conta conta = clienteLogado.buscarConta(numeroConta);
                    if (conta != null) {
                        System.out.print("Digite o valor para depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                } else if (opcao == 3) {
                    System.out.print("Digite o número da conta para saque: ");
                    int numeroConta = scanner.nextInt();
                    Conta conta = clienteLogado.buscarConta(numeroConta);
                    if (conta != null) {
                        System.out.print("Digite o valor para saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                } else if (opcao == 4) {
                    System.out.print("Digite o número da conta origem para transferência: ");
                    int numeroContaOrigem = scanner.nextInt();
                    Conta contaOrigem = clienteLogado.buscarConta(numeroContaOrigem);
                    if (contaOrigem != null) {
                        System.out.print("Digite o número da conta destino para transferência: ");
                        int numeroContaDestino = scanner.nextInt();
                        Conta contaDestino = banco.buscarClientePorCpf(clienteLogado.getCpf()).buscarConta(numeroContaDestino);
                        if (contaDestino != null) {
                            System.out.print("Digite o valor para transferência: ");
                            double valorTransferencia = scanner.nextDouble();
                            contaOrigem.transferir(contaDestino, valorTransferencia);
                        } else {
                            System.out.println("Conta destino não encontrada.");
                        }
                    } else {
                        System.out.println("Conta origem não encontrada.");
                    }
                } else if (opcao == 5) {
                    clienteLogado = null;
                    System.out.println("Você foi deslogado. Faça o login novamente.");
                    break;
                } else if (opcao == 6) {
                    // Sair
                    autenticado = false;
                    System.out.println("Saindo... Até logo!");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        }
    }
}
