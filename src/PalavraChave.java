public class PalavraChave {
    private String chave;
    private Lista ocorrencias;

    public PalavraChave(String elemento) {
        this.chave = elemento;
        this.ocorrencias = new Lista(99);
    }

    public String getChave() {
        return chave;
    }

    public Lista getOcorrencias() {
        return ocorrencias;
    }

    @Override
    public String toString() {
        return chave + ocorrencias.toString();
    }
}
