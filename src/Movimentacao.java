import java.util.Date;

public class Movimentacao {
    private Date data;
    private String tipo;
    private Cliente cliente;
    private String descricao;
    private double valor;

    public Movimentacao(String tipo, Cliente cliente, String descricao, double valor) {
        this.data = new Date();
        this.tipo = tipo;
        this.cliente = cliente;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
