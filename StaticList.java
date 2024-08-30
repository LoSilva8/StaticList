public class StaticList {
    private int[] data; // array de store
    private int size;   // tamanho
    private int limite; // limite max da lista

    // construtor
    public StaticList(int limite) {
        this.limite = limite;
        this.data = new int[limite];
        this.size = 0;
    }

    // reseta o tamanho
    public void clear() {
        this.size = 0;
    }

    // adiciona elementos
    public void add(int data) {
        if (!isFull()) {
            this.data[size++] = data;
        } else {
            System.out.println("Lista Cheia.");
        }
    }

    // adiciona elementos em lugar especifico
    public void add(int data, int pos) {
        if (pos >= 0 && pos < limite) {
            if (!isFull()) {
                for (int i = size; i > pos; i--) {
                    this.data[i] = this.data[i - 1];
                }
                this.data[pos] = data;
                size++;
            } else {
                System.out.println("Lista Cheia.");
            }
        } else {
            System.out.println("Posicao invalida.");
        }
    }

    // remove elemento em lugar especifico
    public int remove(int pos) {
        if (pos >= 0 && pos < size) {
            int removedData = this.data[pos];
            for (int i = pos; i < size - 1; i++) {
                this.data[i] = this.data[i + 1];
            }
            size--;
            return removedData;
        } else {
            System.out.println("Posicao invalida.");
            return -1; // Remocao invalida
        }
    }

    // Lista Vazia?
    public boolean isEmpty() {
        return size == 0;
    }

    // Lista Cheia?
    public boolean isFull() {
        return size == limite;
    }

    // Set dado em pos especifica
    public void setData(int data, int pos) {
        if (pos >= 0 && pos < size) {
            this.data[pos] = data;
        } else {
            System.out.println("Posicao invalida.");
        }
    }

    // Get data pos especifica
    public int getData(int pos) {
        if (pos >= 0 && pos < size) {
            return this.data[pos];
        } else {
            System.out.println("Posicao invalida.");
            return -1; // Valor invalido
        }
    }

    // Tamanho Lista
    public int getSize() {
        return size;
    }

    // Pos especifica de um elemento
    public int find(int data) {
        for (int i = 0; i < size; i++) {
            if (this.data[i] == data) {
                return i;
            }
        }
        return -1; // Element nao encontrado
    }

    // Main
    public static void main(String[] args) {
        StaticList list = new StaticList(5);
        list.add(1);
        list.add(2);
        list.add(3, 1); // Adiciona 3 na pos 1
        System.out.println(list.getData(1)); // Output 3
        list.remove(1); // Remove elemento da pos 1
        System.out.println(list.find(2)); // Output 1
    }
}
