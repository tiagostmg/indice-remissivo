public class PalavraChave {
    private String chave;
    private Lista ocorrencias;

    public PalavraChave(String elemento) {
        this.chave = elemento;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Lista getOcorrencias() {
        return ocorrencias;
    }

    public void setOcorrencias(Lista ocorrencias) {
        this.ocorrencias = ocorrencias;
    }
}
