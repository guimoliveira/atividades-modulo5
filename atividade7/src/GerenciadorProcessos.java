import java.util.ArrayDeque;
import java.util.Queue;

/** Classe que representa um Gerenciador de Processos utilizando uma Fila */
class GerenciadorProcessos {

    /** Construtor */
    public GerenciadorProcessos() {
        while (rodando) {
            new Menu("\nGerenciador de Processos", new Menu.Opcao[]{
                    new Menu.Opcao("Adicionar Processo", this::adicionar),
                    new Menu.Opcao("Processar Processo", this::processar),
                    new Menu.Opcao("Sair", () -> rodando = false)
            });
        }
    }

    /**
     * Adiciona um processo
     */
    public void adicionar() {
        fila.add(IO.lerString("Processo: ", (String str) -> {
            if (str == null) return "Processo inválido";
            if (str.length() < 3) return "Processo precisa ter pelo menos 3 caracteres";
            if (str.length() > 16) return "Processo não pode ter mais de 16 caracteres";
            return "";
        }));
        IO.println("Processo adicionado com sucesso a fila!");
    }

    /**
     * Processa o processo mais antigo
     */
    public void processar() {
        if (fila.isEmpty()) {
            IO.println("Nenhum processo na fila");
            return;
        }

        String processo = fila.remove();
        IO.println("Executando processo: " + processo);
    }

    private boolean rodando = true;
    private final Queue<String> fila = new ArrayDeque<>();

}
