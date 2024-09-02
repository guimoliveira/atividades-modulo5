import java.util.LinkedList;
import java.util.Random;

/** Classe que representa um Jogo de Cartas, utilizando uma lista duplamente encadeada */
@SuppressWarnings("FieldCanBeLocal")
class JogoCartas {

    private final int JOGADAS_POR_RODADA = 3;
    private final int CARTAS_POR_RODADA = 4; // Quantas cartas comprar por rodada
    private final int TAMANHO_MAO = 20; // Máximo de cartas na mão

    private final char COPAS = '♥';
    private final char OURO = '♦';
    private final char PAUS = '♣';
    private final char ESPADAS = '♠';

    /* Caso o console não suporte os caracteres acima troque para o seguinte código:
        private final char COPAS = 3;
        private final char OURO = 4;
        private final char PAUS = 5;
        private final char ESPADAS = 6;
    */

    private static class Carta {
        private final int numero;
        private final char naipe;

        Carta(int numero, char naipe) {
            this.numero = numero;
            this.naipe = naipe;
        }

        @Override
        public String toString() {
            return (numero == 1 ? "A" : Integer.toString(numero)) + naipe;
        }
    }

    /** Construtor */
    public JogoCartas() {
        IO.println("\nJogo de Cartas\n");
        IO.println("Objetivo do jogo:");
        IO.println("\tO objetivo do jogo é organizar as cartas em ordem crescente (A ao 10) sem importar o naipe.");
        IO.println("Como funciona:");
        IO.println("\tNo início do jogo são embaralhadas 40 cartas no baralho, 10 de cada naipe.");
        IO.println("\tNo início de cada rodada você compra 4 cartas. Você pode fazer até 3 jogadas por rodada.");
        IO.println("Sendo elas:");
        IO.println("\tMover Cartas: Troca duas cartas de posição.");
        IO.println("\tDescartar Carta: Descarta uma carta da sua mão.");
        IO.println("Regras do jogo:");
        IO.println("\tCaso não haja cartas suficente para comprar no baralho, você perde.");
        IO.println("\tCaso na hora de comprar uma carta a sua mão fique com mais de 20 cartas, você perde.");
        IO.println("Boa sorte!\n");

        embaralhar();
        comprarCartas();
        loop();
    }

    /**
     * Move duas cartas
     */
    public void mover() {
        if (mao.size() < 2) {
            IO.println("Sem cartas para mover");
            return;
        }
        int pos1 = IO.lerInt("Escolha uma carta. Informe a posição: ", (Integer pos) -> {
            if (pos == null) return "Posição inválida";
            if (pos < 1) return "Posição deve ser maior que 1";
            if (pos > mao.size()) return "Nenhuma carta nesta posição";
            return "";
        });
        int pos2 = IO.lerInt("Escolha outra carta. Informe a posição: ", (Integer pos) -> {
            if (pos == null) return "Posição inválida";
            if (pos < 1) return "Posição deve ser maior que 1";
            if (pos > mao.size()) return "Nenhuma carta nesta posição";
            if (pos == pos1) return "Deve ser diferente da primeira carta escolhida";
            return "";
        });
        Carta carta1 = mao.get(pos1 - 1);
        Carta carta2 = mao.get(pos2 - 1);
        mao.set(pos1 - 1, carta2);
        mao.set(pos2 - 1, carta1);
    }

    /**
     * Desacarta uma carta
     */
    public void descartar() {
        if (mao.isEmpty()) {
            IO.println("Sem cartas para descartar");
            return;
        }
        int pos = IO.lerInt("Escolha uma carta. Informe a posição: ", (Integer p) -> {
            if (p == null) return "Posição inválida";
            if (p < 1) return "Posição deve ser maior que 1";
            if (p > mao.size()) return "Nenhuma carta nesta posição";
            return "";
        });
        mao.remove(pos - 1);
    }

    private void embaralhar() {
        for (int i = 1; i <= 10; i++) {
            baralho[i - 1] = new Carta(i, COPAS);
            baralho[i + 9] = new Carta(i, OURO);
            baralho[i + 19] = new Carta(i, PAUS);
            baralho[i + 29] = new Carta(i, ESPADAS);
        }

        Random rand = new Random();
        for (int i = 0; i < baralho.length; i++) {
            int randomIndex = rand.nextInt(baralho.length);
            Carta temp = baralho[randomIndex];
            baralho[randomIndex] = baralho[i];
            baralho[i] = temp;
        }
    }

    private void comprarCartas() {
        if (jogando) {
            for (int i = 0; i < CARTAS_POR_RODADA; i++) {
                if (compradas >= baralho.length || mao.size() == TAMANHO_MAO) {
                    jogando = false;
                    return;
                }
                mao.add(baralho[compradas++]);
            }
        }
    }

    private void mostrarCartas() {
        IO.println("Sua mão:");
        for (int i = 1; i <= 10 && i <= mao.size(); i++) {
            IO.printf("\t%s\t", mao.get(i - 1).toString());
        }
        IO.print("\n");
        for (int i = 1; i <= 10 && i <= mao.size(); i++) {
            IO.printf("\t%2s\t", i);
        }
        IO.print("\n");
        if (mao.size() > 10) {
            for (int i = 11; i <= 20 && i <= mao.size(); i++) {
                IO.printf("\t%s\t", mao.get(i - 1).toString());
            }
            IO.print("\n");
            for (int i = 11; i <= 20 && i <= mao.size(); i++) {
                IO.printf("\t%2s\t", i);
            }
            IO.print("\n");
        }
    }

    private void verificarVitoria() {
        int corretas = 1;
        for (Carta carta : mao) {
            if (carta.numero == corretas) {
                corretas++;
            } else {
                corretas = 1;
            }
            if (corretas > 10) {
                jogando = false;
                ganhou = true;
                return;
            }
        }
    }

    private void loop() {
        while (jogando) {
            for (jogada = 0; jogada < JOGADAS_POR_RODADA && jogando; jogada++) {
                mostrarCartas();

                new Menu("Qual sua jogada? " + (jogada + 1) + "/" + JOGADAS_POR_RODADA, new Menu.Opcao[]{
                        new Menu.Opcao("Mover Cartas", this::mover),
                        new Menu.Opcao("Descartar Carta", this::descartar),
                        new Menu.Opcao("Próxima Rodada", () -> jogada = JOGADAS_POR_RODADA),
                        new Menu.Opcao("Desistir", () -> {
                            jogada = JOGADAS_POR_RODADA;
                            jogando = false;
                        })
                });

                verificarVitoria();
            }
            comprarCartas();
        }
        if (ganhou) {
            IO.println("\nParabéns! Você ganhou.");
        } else {
            IO.println("\nAh, não! Você perdeu.");
        }
        mostrarCartas();
    }

    private boolean jogando = true;
    private boolean ganhou = false;
    private int jogada = 0;
    private int compradas = 0;

    private final LinkedList<Carta> mao = new LinkedList<>();
    private final Carta[] baralho = new Carta[40];

}
