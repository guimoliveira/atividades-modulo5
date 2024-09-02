class Estagiario extends Funcionario{
    Estagiario(String nome) {
        super(nome);
    }

    @Override
    public double getSalarioBase() {
        return 600.00;
    }

    @Override
    public String trabalhar() {
        return "Estagiário trabalhou muito para impressionar o seu superior";
    }

}
