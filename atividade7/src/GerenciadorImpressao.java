import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/** Classe que representa um Gerenciador de Impressão utilizando uma Fila */
class GerenciadorImpressao {

    /** Construtor */
    @SuppressWarnings("BusyWait")
    public GerenciadorImpressao() {
        AtomicBoolean rodando = new AtomicBoolean(true);

        new Thread(() -> {
            while (rodando.get()) {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (fila) {
                    String arquivo = fila.poll();
                    if (arquivo != null) {
                        IO.println("\nEnviando para a impressora... Arquivo: " + arquivo);
                    }
                }
            }
        }).start();

        while (rodando.get()) {
            new Menu("\nGerenciador de Impressão", new Menu.Opcao[]{
                    new Menu.Opcao("Adicionar arquivo para impressão", this::adicionar),
                    new Menu.Opcao("Sair", () -> rodando.set(false))
            });
        }
    }

    /**
     * Adiciona um cliente
     */
    public void adicionar() {
        synchronized (fila) {
            fila.add(IO.lerString("Nome do arquivo: ", (String str) -> {
                if (str == null) return "Nome inválido";
                if (str.length() < 3) return "Nome precisa ter pelo menos 3 caracteres";
                if (str.length() > 16) return "Nome não pode ter mais de 16 caracteres";
                return "";
            }));
        }
        IO.println("Arquivo adicionado com sucesso a fila!");
    }

    private final Queue<String> fila = new ArrayDeque<>();

}
