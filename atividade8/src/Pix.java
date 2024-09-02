import java.security.InvalidParameterException;

class Pix extends FormaPagamento {

    public enum TipoChave {
        Cpf,
        Cnpj,
        Celular,
        Email,
        Aleatoria
    }

    private final String chave;
    private final TipoChave tipo;

    public Pix(String chave, TipoChave tipo) {
        this.chave = chave;
        this.tipo = tipo;
    }

    @Override
    boolean validarPagamento() {
        switch (tipo) {
            case Cpf:
                return chave.matches("[0-9]+") && chave.length() == 11;
            case Cnpj:
                return chave.matches("[0-9]+") && chave.length() == 14;
            case Celular:
                return chave.matches("[0-9]+") && chave.length() >= 8 && chave.length() <= 13;
            case Email:
                return chave.contains("@") && chave.contains(".");
            case Aleatoria:
                return chave.length() == 32;
        }
        return false;
    }

    @Override
    void processarPagamento(double valor) {
        if (valor < 0) {
            throw new InvalidParameterException("Valor inválido");
        }
        IO.println("Pagando R$" + valor + " no Pix");
    }
}
