/** Classe que representa um Gerenciador de Tarefas utilizando uma Lista Simples Encadeada */
class GerenciadorTarefas {

    /** Classe que representa uma tarefa */
    private static class Tarefa {
        /**
         * Construtor
         * @param titulo Nome da tarefa
         */
        public Tarefa(String titulo) {
            this.titulo = titulo;
            this.concluida = false;
        }

        /** Conclui a tarefa */
        public void concluir() {
            concluida = true;
        }

        /**
         * Converte para string
         * @return String
         */
        @Override
        public String toString() {
            return titulo + (concluida ? " - Concluída" : " - Não concluída");
        }

        private final String titulo;
        private boolean concluida;
    }

    /** Construtor */
    public GerenciadorTarefas() {
        while (rodando) {
            new Menu("\nGerenciador de Tarefas", new Menu.Opcao[]{
                    new Menu.Opcao("Adicionar Tarefa", this::adicionar),
                    new Menu.Opcao("Remover Tarefa", this::remover),
                    new Menu.Opcao("Concluir Tarefa", this::concluir),
                    new Menu.Opcao("Listar Tarefas", this::listar),
                    new Menu.Opcao("Sair", () -> rodando = false)
            });
        }
    }

    /**
     * Adiciona uma tarefa
     */
    public void adicionar() {
        tarefas.addFirst(new Tarefa(IO.lerString("Título da terafa: ", (String str) -> {
            if (str == null) return "Título inválido";
            if (str.length() < 3) return "Título precisa ter pelo menos 3 caracteres";
            if (str.length() > 16) return "Título não pode ter mais de 16 caracteres";
            return "";
        })));
        IO.println("Tarefa adicionada com sucesso!");
    }

    /**
     * Remove uma tarefa
     */
    public void remover() {
        this.listar();
        if (tarefas.isEmpty()) return;

        if (tarefas.remove(IO.lerInt("Qual tarefa você deseja remover? ") - 1)) {
            IO.println("Tarefa removida com sucesso!");
        } else {
            IO.println("Tarefa não encontrada");
        }
    }

    /**
     * Conclui uma tarefa
     */
    public void concluir() {
        this.listar();
        if (tarefas.isEmpty()) return;

        Tarefa tarefa = tarefas.peek(IO.lerInt("Qual tarefa você deseja concluir? ") - 1);
        if (tarefa != null) {
            tarefa.concluir();
            IO.println("Tarefa concluída com sucesso!");
        } else {
            IO.println("Tarefa não encontrada");
        }
    }

    /**
     * Lista as tarefa
     */
    public void listar() {
        if (tarefas.isEmpty()) {
            IO.println("Nenhuma tarefa");
            return;
        }
        IO.println(tarefas.toString());
    }

    private boolean rodando = true;
    private final SimpleLinkedList<Tarefa> tarefas = new SimpleLinkedList<>();

}
