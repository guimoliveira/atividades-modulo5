/**
 * Representa uma lista simplesmente encadeada.
 *
 * @param <T> O tipo de dado armazenado no nó.
 */
@SuppressWarnings("unused")
class SimpleLinkedList<T> {

    /**
     * Representa um nó na lista simplesmente encadeada.
     *
     * @param <T> O tipo de dado armazenado no nó.
     */
    private static class Node<T> {
        private final T data;        // Valor armazenado no nó
        private Node<T> next;  // Referência para o próximo nó

        /**
         * Constrói um novo nó com o dado fornecido.
         *
         * @param data O valor a ser armazenado no nó.
         */
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;  // Referência para o primeiro nó

    /**
     * Constrói uma nova lista simplesmente encadeada vazia.
     */
    public SimpleLinkedList() {
        this.head = null;
    }

    /**
     * Adiciona um novo nó no início da lista.
     *
     * @param data O valor a ser armazenado no novo nó.
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Adiciona um novo nó no final da lista.
     *
     * @param data O valor a ser armazenado no novo nó.
     */
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Remove o primeiro nó da lista.
     */
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Remove o último nó da lista.
     */
    public void removeLast() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
            return;
        }

        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    /**
     * Remove o elemento em determinada posição.
     *
     * @param index Índice do elemento
     */
    public boolean remove(int index) {
        if (head == null) return false;

        Node<T> prev = null;
        Node<T> current = head;
        int i = 0;
        do {
            if (i++ == index) {
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != null);

        return false;
    }

    /**
     * Obtém o primeiro elemento da lista sem removê-lo.
     *
     * @return O valor do primeiro elemento, ou {@code null} se a lista estiver vazia.
     */
    public T peekFirst() {
        return (head != null) ? head.data : null;
    }

    /**
     * Obtém o último elemento da lista sem removê-lo.
     *
     * @return O valor do último elemento, ou {@code null} se a lista estiver vazia.
     */
    public T peekLast() {
        if (head == null) return null;

        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Obtém o elemento em determinada posição.
     *
     * @param index Índice do elemento
     * @return O valor do elemento em determinada posição
     */
    public T peek(int index) {
        if (head == null) return null;

        Node<T> current = head;
        int i = 0;
        do {
            if (i++ == index) return current.data;
            current = current.next;
        } while (current != null);

        return null;
    }

    /**
     * Converte para String
     *
     * @return Lista convertida para String.
     */
    @Override
    public String toString() {
        if (head == null) return "";

        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        int i = 1;

        do {
            sb.append(i++);
            sb.append(". ");
            sb.append(current.data.toString());
            sb.append('\n');
            current = current.next;
        } while (current != null);

        return sb.toString();
    }

    /**
     * Verifica se a lista está vazia.
     *
     * @return {@code true} se a lista estiver vazia, {@code false} caso contrário.
     */
    public boolean isEmpty() {
        return head == null;
    }
}