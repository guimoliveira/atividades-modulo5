import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

/** Classe que representa um Histórico de Navegação utilizando uma Lista Simples Encadeada */
class HistoricoNavegacao {

    private static final int TAMANHO_HISTORICO = 10;

    /** Construtor */
    public HistoricoNavegacao() {
        while (rodando) {
            new Menu("\nHistórico de Navegação", new Menu.Opcao[]{
                    new Menu.Opcao("Ir para Endereço", this::adicionar),
                    new Menu.Opcao("Ver Histórico", this::listar),
                    new Menu.Opcao("Sair", () -> rodando = false)
            });
        }
    }

    /**
     * Adiciona um endereço
     */
    public void adicionar() {
        AtomicReference<String> urlValidada = new AtomicReference<>();
        IO.lerString("URL: ", (String str) -> {
            if (!str.contains("//")) {
                str = "http://" + str;
            }
            urlValidada.set(validarURL(str));
            return (urlValidada.get() == null ? "URL inválida" : "");
        });
        historico.addFirst(urlValidada.get());
        if (++quantidade > TAMANHO_HISTORICO) {
            historico.removeLast();
        }
        IO.println("Navegação realizada");
    }

    /**
     * Exibe o histórico
     */
    public void listar() {
        if (historico.isEmpty()) {
            IO.println("Histórico está vazio");
            return;
        }
        IO.println(historico.toString());
    }

    private String validarURL(String url) {
        try {
            return new URL(url).toURI().toString();
        } catch (MalformedURLException | URISyntaxException e) {
            return null;
        }
    }

    private boolean rodando = true;
    private int quantidade = 0;

    private final SimpleLinkedList<String> historico = new SimpleLinkedList<>();

}
