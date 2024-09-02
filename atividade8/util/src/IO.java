import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Classe auxiliar de IO */
class IO {

    /** Interface para validar String */
    public interface ValidacaoString {
        /**
         * Método que valida uma String
         * @param str String a ser validada, pode ser null
         * @return Deve retornar uma string vazia caso passe a validação,
         * ou então a mensagem de erro
         */
        String validar(String str);
    }

    /** Interface para validar Integer */
    public interface ValidacaoInt {
        /**
         * Método que valida um Integer
         *
         * @param num Número a ser validado, pode ser null
         * @return Deve retornar uma string vazia caso passe a validação,
         * ou então a mensagem de erro
         */
        String validar(Integer num);
    }

    /**
     * Método para escrever uma string no console
     * @param str String a ser escrita
     */
    public static void print(String str) {
        System.out.print(str);
    }

    /**
     * Método para escrever uma string no console com uma linha em branco
     * @param str String a ser escrita
     */
    public static void println(String str) {
        System.out.println(str);
    }

    /**
     * Método para escrever uma string formatada no console
     * @param format Formato
     * @param args Argumentos
     */
    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    /**
     * Método para ler uma string do console
     * @param prompt Mensagem a ser exibida ou null para não exibir nada
     * @return String inserida pelo usuário
     */
    public static String lerString(String prompt) {
        try {
            if (prompt != null ) print(prompt);
            return reader.readLine().trim();
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Método para ler um número do console
     * @param prompt Mensagem a ser exibida ou null para não exibir nada
     * @return Número inserido pelo usuário
     */
    public static int lerInt(String prompt) {
        try {
            return Integer.parseInt(lerString(prompt));
        } catch (Exception ignored) {
            println("Número inválido");
            return lerInt(prompt);
        }
    }

    /**
     * Método para ler uma string do console aplicando validações,
     * caso não passe na validação repete a chamada
     * @param prompt Mensagem a ser exibida ou null para não exibir nada
     * @param validacao Método a ser chamado para validar a String
     * @return String inserida pelo usuário
     */
    public static String lerString(String prompt, ValidacaoString validacao) {
        String ret = null;
        try {
            print(prompt);
            ret = reader.readLine().trim();
        } catch (Exception ignored) {}

        String retValidacao = validacao.validar(ret);
        if (retValidacao.isEmpty()) {
            return ret;
        }
        println(retValidacao);
        return lerString(prompt, validacao);
    }

    /**
     * Método para ler um número do console aplicando validações,
     * caso não passe na validação repete a chamada
     * @param prompt Mensagem a ser exibida ou null para não exibir nada
     * @param validacao Método a ser chamado para validar o número
     * @return Número inserido pelo usuário
     */
    public static Integer lerInt(String prompt, ValidacaoInt validacao) {
        Integer ret = null;
        try {
            print(prompt);
            ret = Integer.parseInt(reader.readLine().trim());
        } catch (Exception ignored) {}

        String retValidacao = validacao.validar(ret);
        if (retValidacao.isEmpty()) {
            return ret;
        }
        println(retValidacao);
        return lerInt(prompt, validacao);
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
}
