public class ArvoreBinaria{

    class Nodo {

        public PalavraChave elemento;
        public Nodo esquerdo;
        public Nodo direito;

        public Nodo(PalavraChave elemento) {
            this.elemento = elemento;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    public Nodo raiz;
    public int nElementos;

    public ArvoreBinaria() {
        this.raiz = null;
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public void imprimeEmLargura() {

        Fila<Nodo> fila = new Fila<Nodo>();

        fila.enfileira(this.raiz);
        while (!fila.estaVazia()) {

            Nodo cursor = fila.desenfileira();

            System.out.print(cursor.elemento + " ");

            if (cursor.esquerdo != null) {
                fila.enfileira(cursor.esquerdo);
            }

            if (cursor.direito != null) {
                fila.enfileira(cursor.direito);
            }
        }

        System.out.println();

    }

    public void imprimePreOrdem() {
        this.preOrdem(this.raiz);
        System.out.println();
    }

    public void imprimePosOrdem() {
        this.posOrdem(this.raiz);
        System.out.println();
    }

    public void imprimeEmOrdem() {
        this.emOrdem(this.raiz);
        System.out.println();
    }

    public void preOrdem(Nodo nodo) {

        if (nodo == null)
            return;

        System.out.print(nodo.elemento + " ");
        this.preOrdem(nodo.esquerdo);
        this.preOrdem(nodo.direito);
    }

    public void posOrdem(Nodo nodo) {

        if (nodo == null)
            return;

        this.posOrdem(nodo.esquerdo);
        this.posOrdem(nodo.direito);
        System.out.print(nodo.elemento + " ");
    }

    public void emOrdem(Nodo nodo) {

        if (nodo == null)
            return;

        this.emOrdem(nodo.esquerdo);
        System.out.print(nodo.elemento + " ");
        this.emOrdem(nodo.direito);
    }

    public void insere(String entrada) {
        PalavraChave elemento = busca(entrada);
        if(elemento == null){
            this.insere(entrada, this.raiz);
        }
    }

    public void insere(String elemento, Nodo nodo) {

        Nodo novo = new Nodo(new PalavraChave(elemento));

        if (nodo == null) {
            this.raiz = novo;
            this.nElementos++;
            return;
        }

        int comparacao = novo.elemento.getChave().compareTo(nodo.elemento.getChave());

        if (comparacao < 0) {
            if (nodo.esquerdo == null) {
                nodo.esquerdo = novo;
                this.nElementos++;
                return;
            } else {
                this.insere(elemento, nodo.esquerdo);
            }
        }

        if (comparacao > 0) {
            if (nodo.direito == null) {
                nodo.direito = novo;
                this.nElementos++;
                return;
            } else {
                this.insere(elemento, nodo.direito);
            }
        }
    }

    //TODO
    public void registrarOcorrencia(String palavra, int linha) {
        PalavraChave palavraChave = busca(palavra);
        palavraChave.getOcorrencias().insereFinal(linha);
    }

    private Nodo maiorElemento(Nodo nodo) {
        while (nodo.direito != null) {
            nodo = nodo.direito;
        }
        return nodo;
    }

    private Nodo menorElemento(Nodo nodo) {
        while (nodo.esquerdo != null) {
            nodo = nodo.esquerdo;
        }
        return nodo;
    }

    public boolean remove(PalavraChave elemento) {
        return this.remove(elemento, this.raiz) != null;
    }

    private Nodo remove(PalavraChave elemento, Nodo nodo) {

        if (nodo == null) {
            System.out.println("Valor não encontrado");
            return null;
        }

        int comparacao = elemento.getChave().compareTo(nodo.elemento.getChave());

        if (comparacao < 0) {
            nodo.esquerdo = this.remove(elemento, nodo.esquerdo);
        } else if (comparacao > 0) {
            nodo.direito = this.remove(elemento, nodo.direito);
        } else {

            if (nodo.esquerdo == null) {
                this.nElementos--;
                return nodo.direito;
            } else if (nodo.direito == null) {
                this.nElementos--;
                return nodo.esquerdo;
            } else {
                Nodo substituto = this.menorElemento(nodo.direito);
                nodo.elemento = substituto.elemento;
                this.remove(substituto.elemento, nodo.direito);
            }
        }

        return nodo;
    }

    public PalavraChave busca(String entrada) {
        return this.busca(entrada, this.raiz);
    }

    public PalavraChave busca(String entrada, Nodo nodo) {

        if (nodo == null) {
            return null;
        }

        int comparacao = entrada.compareTo(nodo.elemento.getChave());

        if (comparacao < 0) {
            return this.busca(entrada, nodo.esquerdo);
        } else if (comparacao > 0) {
            return this.busca(entrada, nodo.direito);
        } else {
            return nodo.elemento;
        }
    }

    private int altura(Nodo nodo) {

        if (nodo == null) {
            return -1;
        }

        int alturaEsquerda = this.altura(nodo.esquerdo) + 1;
        int alturaDireita = this.altura(nodo.direito) + 1;

        int altura = alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita;

        return altura;

    }

    public int altura() {
        return this.altura(this.raiz);
    }
}