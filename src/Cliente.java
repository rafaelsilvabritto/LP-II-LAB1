import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private int senha;
    private ArrayList<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, int senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getSenha() {
        return senha;
    }
}
