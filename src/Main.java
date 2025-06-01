import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TabelaHash hash = new TabelaHash(26);

        // Lê as palavras-chave do arquivo input.txt
        try {
            File arquivo = new File("input.txt");
            Scanner fileScanner = new Scanner(arquivo);

            while (fileScanner.hasNextLine()) {
                String linha = fileScanner.nextLine();
                String[] palavras = linha.trim().split(" ");
                for (String palavra : palavras) {
                    hash.insere(palavra);
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo input.txt não encontrado.");
            return;
        }

        // Leitura das linhas com ocorrências via entrada padrão
        Scanner sc = new Scanner(System.in);
        int linhaNum = 1;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] palavras = linha.trim().split(" ");
            for (String palavra : palavras) {
                hash.registrarOcorrencia(palavra, linhaNum);
            }
            linhaNum++;
        }

        hash.imprime();
    }
}
