class Funcionario {

    private final String nome;
    private final double salario;

    Funcionario(String nome) {
        this.nome = nome.toUpperCase();
        this.salario = getSalarioBase();
    }

    public double getSalarioBase() {
        return 0.0;
    }

    public double calcularBonus() {
        return 0.0;
    }

    public String trabalhar() {
        return "Funcionário trabalhou duro durante todo o dia";
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }
}
