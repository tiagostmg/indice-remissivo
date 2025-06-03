public class PalavraChave {
    private String chave;
    private ListaEncadeada ocorrencias;

    public PalavraChave(String elemento) {
        this.chave = elemento;
        this.ocorrencias = new ListaEncadeada();
    }

    public String getChave() {
        return chave;
    }

    public ListaEncadeada getOcorrencias() {
        return ocorrencias;
    }

    @Override
    public String toString() {
        return chave + ocorrencias.toString();
    }
}
