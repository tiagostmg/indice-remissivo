public class TabelaHash {

    public ArvoreBinaria vetor[];
    public int nElementos;

    public TabelaHash(int capacidade) {
        this.vetor = new ArvoreBinaria[capacidade];
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

    //entrada e retorno tem que ser string ?

    public int hash(String string) {
        return string.charAt(0) - 'a';
    }

    public ArvoreBinaria busca(String elemento) {
        int chave = hash(elemento);
        return this.vetor[chave];
    }

    public void insere(String palavraChave, int linha) {
        int chave = hash(palavraChave);

        if(this.vetor[chave] == null) {
            this.vetor[chave] = new ArvoreBinaria();
        }

        this.vetor[chave].insere(palavraChave, linha);

        this.nElementos++;
    }

    public void remove(PalavraChave elemento) {
        int chave = hash(elemento.getChave());
        this.vetor[chave] = null;
        this.nElementos--;
    }


    private static String normaliza(String texto) {
        texto = texto.toLowerCase();

        texto = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        texto = texto.replaceAll("[^a-z0-9-]", "");

        return texto;
    }
}