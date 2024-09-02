import java.util.ArrayDeque;
import java.util.Queue;

/** Classe que representa um Gerenciador de Fila de um banco utilizando uma Fila */
class GerenciadorFilasBanco {

    /** Construtor */
    public GerenciadorFilasBanco() {
        while (rodando) {
            new Menu("\nGerenciador de Filas do Banco", new Menu.Opcao[]{
                    new Menu.Opcao("Novo Cliente", this::adicionar),
                    new Menu.Opcao("Chamar Cliente", this::chamar),
                    new Menu.Opcao("Sair", () -> rodando = false)
            });
        }
    }

    /**
     * Adiciona um cliente
     */
    public void adicionar() {
        fila.add(IO.lerString("Nome do cliente: ", (String str) -> {
            if (str == null) return "Nome inválido";
            if (str.length() < 3) return "Nome precisa ter pelo menos 3 caracteres";
            if (str.length() > 16) return "Nome não pode ter mais de 16 caracteres";
            return "";
        }));
        IO.println("Cliente adicionado com sucesso a fila!");
    }

    /**
     * Chama o próximo cliente
     */
    public void chamar() {
        if (fila.isEmpty()) {
            IO.println("Nenhum cliente na fila");
            return;
        }

        String cliente = fila.remove();
        IO.println("Próximo cliente: " + cliente);
    }

    private boolean rodando = true;
    private final Queue<String> fila = new ArrayDeque<>();

}
