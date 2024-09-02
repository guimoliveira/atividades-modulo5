/** Classe principal */
public class Main {

    /** Método de entrada da aplicação */
    public static void main(String[] args) {
        new Menu("O que você deseja executar?", new Menu.Opcao[]{
                new Menu.Opcao("Gerenciador de Tarefas", Main::instanciarGerenciadorTarefas),
                new Menu.Opcao("Histórico de Navegação", Main::instanciarHistoricoNavegacao),
                new Menu.Opcao("Editor de Texto", Main::instanciarEditorTexto),
                new Menu.Opcao("Editor de Texto 2", Main::instanciarEditorTexto2),
                new Menu.Opcao("Jogo de Cartas", Main::instanciarJogoCartas),
                new Menu.Opcao("Gerenciador de Fila para Banco", Main::instanciarGerenciadorFilasBanco),
                new Menu.Opcao("Gerenciador de Impressão", Main::instanciarGerenciadorImpressao),
                new Menu.Opcao("Gerenciador de Processos", Main::instanciarGerenciadorProcessos),
                new Menu.Opcao("Sair", () -> {})
        });
    }

    private static void instanciarGerenciadorTarefas() {
        new GerenciadorTarefas();
    }
    private static void instanciarHistoricoNavegacao() {
        new HistoricoNavegacao();
    }
    private static void instanciarEditorTexto() {
        new EditorTexto();
    }
    private static void instanciarEditorTexto2() {
        new EditorTexto2();
    }
    private static void instanciarJogoCartas() {
        new JogoCartas();
    }
    private static void instanciarGerenciadorFilasBanco() {
        new GerenciadorFilasBanco();
    }
    private static void instanciarGerenciadorImpressao() {
        new GerenciadorImpressao();
    }
    private static void instanciarGerenciadorProcessos() {
        new GerenciadorProcessos();
    }

}