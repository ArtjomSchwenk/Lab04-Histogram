package src;

public class main {
    public class Alphabet {
        public static void main(String[] args) {
            char[] alphabet = new char[26];
            char a = 65; // Erster Buchstabe (großes A)
            for (int i = 0; i < alphabet.length; i++, a++) {
                alphabet[i] = a;
            }
            System.out.println(alphabet);
        }
    }
}
