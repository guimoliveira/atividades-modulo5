class EditorTexto {

    public EditorTexto() {
        IO.println("\nEditor de Texto\n");
        IO.println("Para sair deixe em branco");
        IO.println("Para desfazer a última linha, insira undo\n");

        String linha;
        int numLinhas = 0;

        SimpleLinkedList<String> linhas = new SimpleLinkedList<>();
        while (true) {
            linha = IO.lerString("");
            if (linha.isEmpty()) {
                break;
            }
            if (linha.equals("undo")) {
                linhas.removeFirst();
                numLinhas = Math.max(numLinhas - 1, 0);
                continue;
            }
            linhas.addFirst(linha);
            numLinhas++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = numLinhas - 1; i >= 0; i--) {
            sb.append(linhas.peek(i));
            sb.append('\n');
        }

        IO.println("Texto inserido:\n");
        IO.print(sb.toString());
    }

}
