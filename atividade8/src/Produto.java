import java.security.InvalidParameterException;

class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    Produto(String nome, double preco, int quantidade) {
        setNome(nome);
        setPreco(preco);
        setQuantidade(quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new InvalidParameterException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new InvalidParameterException("Quantidade não pode ser negativa");
        }
        this.quantidade = quantidade;
    }

    public void aplicarDesconto(double porcentagem) {
        if (porcentagem > 0.5) {
            throw new InvalidParameterException("Desconto não pode ser maior que 50%");
        }
        preco -= preco * porcentagem;
    }
}
