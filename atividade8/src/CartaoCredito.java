import java.security.InvalidParameterException;

class CartaoCredito extends FormaPagamento {
    private final String numCartao;
    private final int cvv;

    public CartaoCredito(String numCartao, int cvv) {
        this.numCartao = numCartao;
        this.cvv = cvv;
    }

    @Override
    boolean validarPagamento() {
        if (!numCartao.matches("[0-9]+")) { // Número do cartão não pode ter letras
            return false;
        }
        // CVV precisa de 3 ou 4 dígitos
        return cvv >= 100 && cvv <= 9999;
    }

    @Override
    void processarPagamento(double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor inválido");
        }
        IO.println("Pagando R$" + valor + " no Cartão de Crédito");
    }
}
