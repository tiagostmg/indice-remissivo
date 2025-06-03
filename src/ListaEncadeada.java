public class ListaEncadeada {

    public static class Nodo {

        public int elemento;
        public Nodo proximo;

        public Nodo(int elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }

    }

    private Nodo inicio;
    private int nElementos;

    public ListaEncadeada() {
        this.inicio = null;
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.inicio == null;
    }

    @Override
    public String toString() {
        Nodo cursor = this.inicio;
        String retorno = "";
        while (cursor != null) {
            retorno += " " + cursor.elemento;
            cursor = cursor.proximo;
        }
        return retorno;
    }

    public void insereFinal(int elemento) {

        Nodo novo = new Nodo(elemento);

        if (this.estaVazia()) {

            this.inicio = novo;
        } else {

            Nodo cursor = this.inicio;
            for (int i = 0; i < this.nElementos-1; i++) {
                cursor = cursor.proximo;
            }

            cursor.proximo = novo;
        }

        this.nElementos++;
    }

    public boolean contem(int elemento) {

        Nodo cursor = this.inicio;
        for (int i = 0; i < this.nElementos; i++) {

            if (cursor.elemento == elemento) {
                return true;
            }

            cursor = cursor.proximo;
        }

        return false;
    }

}