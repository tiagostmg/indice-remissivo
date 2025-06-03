import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TabelaHash {

    public ArvoreBinariaBusca[] vetor;
    public int nElementos;

    public TabelaHash(int capacidade) {
        this.vetor = new ArvoreBinariaBusca[capacidade];
        this.nElementos = 0;
    }

    public int hash(String string) {
        string = normaliza(string);
        if(string.isEmpty()){
            return -1;
        }
        return string.charAt(0) - 'a';
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
            ArvoreBinariaBusca arvore = this.vetor[chave];
            arvore.registrarOcorrencia(palavraChave, linha);
        }
    }

    private String normaliza(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        texto = texto.toLowerCase();

        texto = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{M}", "");

        texto = texto.replaceAll("[^a-z0-9-]", "");

        return texto;
    }

    public void imprime() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            for (ArvoreBinariaBusca arvoreBinariaBusca : vetor) {
                if (arvoreBinariaBusca != null && !arvoreBinariaBusca.estaVazia()) {
                    arvoreBinariaBusca.imprimeEmOrdem(writer);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de saída: " + e.getMessage());
        }
    }
}