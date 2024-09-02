import java.security.InvalidParameterException;

class Boleto extends FormaPagamento {
    private final String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    boolean validarPagamento() {
        return codigoBarras.matches("[0-9]+"); // Código de barras não pode ter letras
    }

    @Override
    void processarPagamento(double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor inválido");
        }
        IO.println("Pagando R$" + valor + " no Boleto");
    }
}
