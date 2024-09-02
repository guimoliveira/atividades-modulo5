import java.util.LinkedList;

class EditorTexto2 {

    public EditorTexto2() {
        IO.println("\nEditor de Texto 2\n");
        IO.println("Para sair deixe em branco");
        IO.println("Para desfazer a última linha, insira undo");
        IO.println("Para refazer a ação desfeita, insira redo\n");

        String linha;
        int numLinhas = 0;

        LinkedList<String> linhas = new LinkedList<>();
        while (true) {
            linha = IO.lerString("");
            if (linha.equals("undo")) {
                numLinhas = Math.max(numLinhas - 1, 0);
                continue;
            }
            if (linha.equals("redo")) {
                numLinhas = Math.min(numLinhas + 1, linhas.size());
                continue;
            }
            if (numLinhas != linhas.size()) {
                linhas.subList(numLinhas, linhas.size()).clear();
            }
            if (linha.isEmpty()) {
                break;
            }
            linhas.add(linha);
            numLinhas++;
        }

        StringBuilder sb = new StringBuilder();
        for (String l : linhas) {
            sb.append(l);
            sb.append('\n');
        }

        IO.println("Texto inserido:\n");
        IO.print(sb.toString());
    }

}
