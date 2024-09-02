class Gerente extends Funcionario{
    Gerente(String nome) {
        super(nome);
    }

    @Override
    public double getSalarioBase() {
        return 10000.00;
    }

    @Override
    public double calcularBonus() {
        return 0.2 * getSalario();
    }

    @Override
    public String trabalhar() {
        return "Gerente trabalhou para garantir que tudo está funcionando corretamente";
    }
}
