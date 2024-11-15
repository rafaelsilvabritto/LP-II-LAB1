import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    public Cliente autenticarCliente(String cpf, int senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf) && cliente.getSenha() == senha) {
                return cliente;
            }
        }
        return null;
    }

    public boolean cadastrarCliente(String nome, String cpf, int senha) {
        if (buscarClientePorCpf(cpf) == null) {
            clientes.add(new Cliente(nome, cpf, senha));
            return true;
        }
        return false;
    }

    public Cliente buscarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}
