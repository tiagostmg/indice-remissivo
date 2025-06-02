public class TabelaHash {

    public ArvoreBinariaBusca vetor[];
    public int nElementos;

    public TabelaHash(int capacidade) {
        this.vetor = new ArvoreBinariaBusca[capacidade];
        this.nElementos = 0;
    }

    public int tamanho() {
        return this.nElementos;
    }

    public void imprime() {
        System.out.println("Chave\tOcorrencias");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("-----");
            System.out.println(i + " ");
            if(vetor[i] != null) {
                vetor[i].imprimeEmOrdem();
            }
        }
        System.out.println("-----");
    }

    public int hash(String string) {
        string = normaliza(string);
        if(string.isEmpty()){
            return -1;
        }
        return string.charAt(0) - 'a';
    }

    public ArvoreBinariaBusca busca(String elemento) {
        int chave = hash(elemento);
        if(chave == -1){
            return null;
        }
        return this.vetor[chave];
    }

    public void insere(String palavraChave) {
        int chave = hash(palavraChave);

        if(chave == -1){
            return;
        }

        if(this.vetor[chave] == null) {
            this.vetor[chave] = new ArvoreBinariaBusca();
        }

        palavraChave = normaliza(palavraChave);

        this.vetor[chave].insere(palavraChave);

        this.nElementos++;
    }

    public void registrarOcorrencia(String palavraChave, int linha) {
        int chave = hash(palavraChave);
        if(chave == -1){
            return;
        }
        palavraChave = normaliza(palavraChave);
        if(this.vetor[chave] != null) {
            this.vetor[chave].registrarOcorrencia(palavraChave, linha);
        }
    }

//    public void remove(PalavraChave elemento) {
//        int chave = hash(elemento.getChave());
//        this.vetor[chave] = null;
//        this.nElementos--;
//    }


    private String normaliza(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        // Converte para minúsculas
        texto = texto.toLowerCase();

        // Remove acentos e caracteres especiais
        texto = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{M}", "");

        // Remove pontuação no final da palavra (como vírgulas, pontos, etc.)
        texto = texto.replaceAll("[^a-z0-9-]", "");

        return texto;
    }
}