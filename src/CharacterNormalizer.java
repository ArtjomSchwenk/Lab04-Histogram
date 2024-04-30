package src;

import java.text.Normalizer;

public class CharacterNormalizer {
    public static void main(String[] args) {
        char inputChar = 'a'; // Ersetzen durch gewünschten Character

        char normalizedChar = normalizeCharacter(inputChar);
        System.out.println("Normalized character: " + normalizedChar);
    }

    public static char normalizeCharacter(char inputChar) {
        // Character normalisieren
        String normalizedString = Normalizer.normalize(String.valueOf(inputChar), Normalizer.Form.NFD);

        // non-ASCII characters entfernen
        normalizedString = normalizedString.replaceAll("[^\\p{ASCII}]","");

        // Return zum first character
        return normalizedString.charAt(0);
    }
}
