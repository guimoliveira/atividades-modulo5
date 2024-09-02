/** Classe para geração de menus */
class Menu {

    /** Interface de Callback da seleção */
    public interface CallbackSelecao {
        /**
         * Método a ser chamado após o usuário escolher uam opção
         */
        void selecionar();
    }

    /** Classe que representa uma opção do menu */
    public static class Opcao {
        /**
         * Construtor
         * @param titulo Título da opção
         * @param callback Callback a ser chamado após o usuário escolher uma opção
         */
        public Opcao(String titulo, CallbackSelecao callback) {
            this.titulo = titulo;
            this.callback = callback;
        }
        private final String titulo;
        private final CallbackSelecao callback;
    }

    /**
     * Construtor para renderizar o menu
     * @param titulo Título do menu
     * @param opcoes Array com as opções do menu
     */
    public Menu(String titulo, Opcao[] opcoes) {
        IO.println(titulo);

        for (int i = 0; i < opcoes.length; i++) {
            IO.printf(" %d. %s\n", (i + 1), opcoes[i].titulo);
        }
        int opcaoSelecionada = IO.lerInt("Escolha uma opção: ",
                (Integer num) -> {
                    if (num == null || num < 1 || num > (opcoes.length))
                        return "Opção inválida";
                    return "";
                });
        opcoes[opcaoSelecionada - 1].callback.selecionar();
    }

}
