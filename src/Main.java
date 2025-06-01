import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TabelaHash hash = new TabelaHash(26);

        //palavras chave
        for (int i = 1; sc.hasNextLine(); i++) {
            String linha = sc.nextLine();
            String[] palavras = linha.trim().split(" ");
            for(String palavra : palavras) {
                hash.insere(palavra, i);
            }
        }

    }
}