import java.util.ArrayList;

class GerenciadorFuncionarios {

    public void contratar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void demitir(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    public void promover(Funcionario funcionario) {
        if (funcionario instanceof Estagiario) {
            funcionario = new Desenvolvedor(funcionario.getNome());
        } else if (funcionario instanceof Desenvolvedor) {
            funcionario = new Gerente(funcionario.getNome());
        }
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getNome().equals(funcionario.getNome())) {
                funcionarios.set(i, funcionario);
            }
        }
    }

    public void calcularFolhaPagamento() {
        double totalSalario = 0;
        double totalBonus = 0;

        IO.println("Nome Salário Bônus");

        for (Funcionario f : funcionarios) {
            double salario = f.getSalario();
            double bonus = f.calcularBonus();
            totalSalario += salario;
            totalBonus += bonus;

            IO.println(f.getNome() + " R$ " + salario + " R$ " + bonus);
        }
        IO.println("");
        IO.println("TOTAL: R$ " + totalSalario + " R$ " + totalBonus + " = R$ " + (totalSalario + totalBonus));
    }

    public Funcionario getByNome(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                return f;
            }
        }
        return null;
    }

    private final ArrayList<Funcionario> funcionarios = new ArrayList<>();

}
