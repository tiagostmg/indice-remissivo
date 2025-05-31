public class TabelaHash {

    public Integer vetor[];
    public int nElementos;

    public TabelaHash(int capacidade) {
        this.vetor = new Integer[capacidade];
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public void imprime() {
        System.out.println("Chave\tValor");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(i + " -->\t[ " + vetor[i] + " ]");
        }
    }

    private int funcaoHashDiv(Integer elemento) {
        return elemento % this.vetor.length;
    }

    public Integer busca(int elemento) {
        int chave = funcaoHashDiv(elemento);
        return this.vetor[chave];
    }

    public void insere(Integer elemento) {
        int chave = funcaoHashDiv(elemento);
        this.vetor[chave] = elemento;
        this.nElementos++;
    }

    public void remove(int elemento) {
        int chave = funcaoHashDiv(elemento);
        this.vetor[chave] = null;
        this.nElementos--;
    }

}