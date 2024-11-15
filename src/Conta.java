import java.util.ArrayList;

public class Conta {
    private Cliente cliente;
    private int numeroConta;
    private String tipo;
    private double saldo;
    private ArrayList<Movimentacao> movimentacao = new ArrayList<>();

    public Conta(Cliente cliente, int numeroConta, String tipo, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getNumConta() {
        return this.numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void consultarSaldo() {
        System.out.println("O saldo da conta " + numeroConta + " é: R$ " + saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            movimentacao.add(new Movimentacao("DEPOSITO", cliente, "Depósito", valor));
            System.out.println("Depósito realizado com sucesso! Novo saldo: R$ " + saldo);
        } else {
            System.out.println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            movimentacao.add(new Movimentacao("SAQUE", cliente, "Saque", valor));
            System.out.println("Saque realizado com sucesso! Novo saldo: R$ " + saldo);
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            contaDestino.depositar(valor);
            movimentacao.add(new Movimentacao("TRANSFERÊNCIA", cliente, "Saída por Transferência", valor));
            contaDestino.movimentacao.add(new Movimentacao("TRANSFERÊNCIA", cliente, "Entrada por Transferência", valor));
            System.out.println("Transferência realizada com sucesso!");
        } else if (valor <= 0) {
            System.out.println("Valor de transferência inválido!");
        } else {
            System.out.println("Saldo insuficiente para transferência!");
        }
    }
}
