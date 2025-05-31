public class Main {
    public static void main(String[] args) {

        TabelaHash tabelaHash = new TabelaHash(29);

        //tabelaHash.insere();

    }


    //
    private static int hash(String string) {
        return string.toLowerCase().charAt(0) - 'a';
    }
}