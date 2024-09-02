class Desenvolvedor extends Funcionario{
    Desenvolvedor(String nome) {
        super(nome);
    }

    @Override
    public double getSalarioBase() {
        return 3200.00;
    }

    @Override
    public double calcularBonus() {
        return 0.1 * getSalario();
    }

    @Override
    public String trabalhar() {
        return "Desenvolvedor trabalhou duro durante todo o dia para entregar o projeto no prazo";
    }

}
