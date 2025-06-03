import java.io.PrintWriter;
import java.io.Writer;

public class ArvoreBinariaBusca {

    static class Nodo {

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

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.nElementos = 0;
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
            } else {
                this.insere(elemento, nodo.direito);
            }
        }
    }

    public void registrarOcorrencia(String palavra, int linha) {
        PalavraChave palavraChave = busca(palavra);
        if(palavraChave != null){
            ListaEncadeada ocorrencias = palavraChave.getOcorrencias();
            if(ocorrencias.contem(linha)){
                return;
            }
            ocorrencias.insereFinal(linha);
        }
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public void imprimeEmOrdem(PrintWriter writer) {
        this.emOrdem(this.raiz, writer);
    }

    public void emOrdem(Nodo nodo, PrintWriter writer) {
        if (nodo == null) return;

        this.emOrdem(nodo.esquerdo, writer);
        writer.println(nodo.elemento);
        this.emOrdem(nodo.direito, writer);
    }
}