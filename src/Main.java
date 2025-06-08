import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TabelaHash hash = new TabelaHash(26);

        lerPalavrasChave(hash);
        lerTexto(hash);

        hash.imprime();
    }

    private static void lerPalavrasChave(TabelaHash hash) {
        try {
            File arquivoPalavras = new File("palavras-chave.txt");
            Scanner scannerPalavras = new Scanner(arquivoPalavras);

            while (scannerPalavras.hasNextLine()) {
                String linha = scannerPalavras.nextLine();
                String[] palavras = linha.trim().split(" ");
                for (String palavra : palavras) {
                    palavra = normalize(palavra);
                    hash.insere(palavra);
                }
            }

            scannerPalavras.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo palavras-chave.txt não encontrado.");
        }
    }

    private static void lerTexto(TabelaHash hash) {
        try {
            File arquivoTexto = new File("texto.txt");
            Scanner scannerTexto = new Scanner(arquivoTexto);

            int linhaNum = 1;
            while (scannerTexto.hasNextLine()) {
                String linha = scannerTexto.nextLine();
//                if(linha.trim().isEmpty()) continue;
                String[] palavras = linha.trim().split(" ");
                for (String palavra : palavras) {
                    palavra = normalize(palavra);
                    hash.buscarPalavraChaveERegistrarOcorrencia(palavra, linhaNum);
                }
                linhaNum++;
            }

            scannerTexto.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo texto.txt não encontrado.");
        }
    }
    private static String normalize(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "";
        }

        texto = texto.toLowerCase();

        texto = java.text.Normalizer.normalize(texto, java.text.Normalizer.Form.NFD);
        texto = texto.replaceAll("\\p{M}", "");

        texto = texto.replaceAll("[^a-z0-9-]", "");

        return texto;
    }
}
