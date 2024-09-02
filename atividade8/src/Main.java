import java.util.ArrayList;

/** Classe principal */
public class Main {

    /** Método de entrada da aplicação */
    public static void main(String[] args) {
        new Menu("O que você deseja executar?", new Menu.Opcao[]{
                new Menu.Opcao("Produtos", Main::instanciarProdutos),
                new Menu.Opcao("Produto com Desconto", Main::instanciarProdutoDesconto),
                new Menu.Opcao("Funcionarios", Main::instanciarFuncionarios),
                new Menu.Opcao("Funcionarios Trabalhando", Main::instanciarFuncionariosTrabalhando),
                new Menu.Opcao("Meios de Transporte", Main::instanciarMeiosTransporte),
                new Menu.Opcao("Animais", Main::instanciarAnimais),
                new Menu.Opcao("Formas de Pagamentos", Main::instanciarFormasPagamentos),
                new Menu.Opcao("Gerenciador de Funcionários", Main::instanciarGerenciadorFuncionarios),
                new Menu.Opcao("Sair", () -> {})
        });
    }

    private static void instanciarProdutos() {
        Produto arroz = new Produto("Arroz", 10, 3);
        Produto carne = new Produto("Carne", 30, 2);
        IO.printf("Produto criado: %s Preço: R$ %f Quantidade: %d\n", arroz.getNome(), arroz.getPreco(), arroz.getQuantidade());
        IO.printf("Produto criado: %s Preço: R$ %f Quantidade: %d\n", carne.getNome(), carne.getPreco(), carne.getQuantidade());
    }

    private static void instanciarProdutoDesconto() {
        Produto chocolate = new Produto("Chocolate", 50, 1);
        IO.printf("Produto criado: %s Preço: R$ %f Quantidade: %d\n", chocolate.getNome(), chocolate.getPreco(), chocolate.getQuantidade());
        chocolate.aplicarDesconto(0.2);
        IO.printf("Produto com desconto: %s Preço: R$ %f Quantidade: %d\n", chocolate.getNome(), chocolate.getPreco(), chocolate.getQuantidade());
    }

    private static void instanciarFuncionarios() {
        Funcionario dev = new Desenvolvedor("Guilherme");
        IO.printf("Desenvolvedor: %s Salário: R$ %f Bônus: R$ %f\n", dev.getNome(), dev.getSalario(), dev.calcularBonus());
        Funcionario gerente = new Gerente("João");
        IO.printf("Gerente: %s Salário: R$ %f Bônus: R$ %f\n", gerente.getNome(), gerente.getSalario(), gerente.calcularBonus());
    }

    private static void instanciarFuncionariosTrabalhando() {
        Funcionario dev = new Desenvolvedor("Guilherme");
        Funcionario gerente = new Gerente("João");
        IO.println(dev.trabalhar());
        IO.println(gerente.trabalhar());
    }

    private static void instanciarMeiosTransporte() {
        ArrayList<IMeioTransporte> meiosTransporte = new ArrayList<>();
        meiosTransporte.add(new Bicicleta());
        meiosTransporte.add(new Carro());
        meiosTransporte.add(new Trem());

        for (IMeioTransporte meio : meiosTransporte) {
            meio.acelerar();
            meio.frear();
        }
    }

    private static void instanciarAnimais() {
        ArrayList<Animal> animais = new ArrayList<>();
        animais.add(new Gato());
        animais.add(new Cachorro());
        animais.add(new Vaca());

        for (Animal animal : animais) {
            animal.emitirSom();
        }
    }

    private static void instanciarFormasPagamentos() {
        ArrayList<FormaPagamento> formasPagamentos = new ArrayList<>();
        formasPagamentos.add(new Boleto("123456789123456789123456"));
        formasPagamentos.add(new CartaoCredito("123456789123", 123));
        formasPagamentos.add(new Pix("example@mail.com", Pix.TipoChave.Email));

        for (FormaPagamento forma : formasPagamentos) {
            forma.validarPagamento();
            forma.processarPagamento(10);
        }
    }

    private static void instanciarGerenciadorFuncionarios() {
        GerenciadorFuncionarios funcionarios = new GerenciadorFuncionarios();

        Estagiario estagiario = new Estagiario("João");
        Estagiario estagiarioPromovido = new Estagiario("Marcelo");
        Desenvolvedor dev = new Desenvolvedor("Guilherme");
        Desenvolvedor devPromovido = new Desenvolvedor("Rodrigo");
        Gerente gerente = new Gerente("Paulo");

        funcionarios.contratar(estagiario);
        funcionarios.contratar(estagiarioPromovido);
        funcionarios.contratar(dev);
        funcionarios.contratar(devPromovido);
        funcionarios.contratar(gerente);

        funcionarios.promover(estagiarioPromovido);
        funcionarios.promover(devPromovido);

        funcionarios.calcularFolhaPagamento();
    }

}