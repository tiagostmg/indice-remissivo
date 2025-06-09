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
        return string.charAt(0) - 'a';
    }

    public void insere(String palavraChave) {
        if(palavraChave.isEmpty()) {
            return;
        }
        int chave = hash(palavraChave);

        if(this.vetor[chave] == null) {
            this.vetor[chave] = new ArvoreBinariaBusca();
        }

        this.vetor[chave].insere(palavraChave);

        this.nElementos++;
    }

    public void buscarPalavraChaveERegistrarOcorrencia(String palavraChave, int linha) {
        if(palavraChave.isEmpty()) {
            return;
        }
        int chave = hash(palavraChave);

        if(this.vetor[chave] != null) {
            ArvoreBinariaBusca arvore = this.vetor[chave];
            arvore.registrarOcorrencia(palavraChave, linha);
        }
    }

    public void imprime() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("indice.txt"))) {
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