public class Main {
    public static void main(String[] args) {
        int[] letterCounters = new int[26];

        char letter = 'T';
        int index = letter - 'A';
        letterCounters[index]++;

        letter = 'C';
        index = letter - 'A';
        letterCounters[index]++;

        for (int i = 0; i < 26; i++) {
            char currentLetter = (char) ('A' + i);
            System.out.println(currentLetter + ": " + letterCounters[i]);
        }
    }
}
