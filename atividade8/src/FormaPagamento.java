abstract class FormaPagamento {
    abstract boolean validarPagamento();
    abstract void processarPagamento(double valor);
}
