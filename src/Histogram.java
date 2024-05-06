package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.Reader;
import java.util.logging.Logger;

public class Histogram {
    private static int[] frequencies;

    // TASK 01
    private static final Logger logger = Logger.getLogger(Histogram.class.getName());

    public static Character getNextCharacter(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int nextCharInt;

            while ((nextCharInt = reader.read()) != -1) {
                char nextChar = (char) nextCharInt;

                if (nextChar != '\r') {
                    return nextChar;
                }
            }
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }

        return null;
    }

    // TASK 02
    public void writeStringToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("'" + content + "'"+ " successfully written to the file: " + filePath);
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }
    }

    public void writeIntegerToFile(String filePath, Integer number) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(number.toString());
            System.out.println("'" + number + "'"+ " successfully written to the file: " + filePath);

        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }
    }

    public void createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();

}}
    // TASK 03
    private static boolean isASCIILetters(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private static int getNormalizedIndex(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 26;
        } else if (c >= 'A' && c <= 'Z'){
            return c - 'A';
        } else {
            return -1;
        }
    }

    public static void countCharacterFrequencies(String inputFilePath, String outputFilePath) {
        int[] frequencies = new int[52];

        buffer(inputFilePath, frequencies);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (char c = 'A'; c <= 'Z'; c++) {
                writer.write(c + ": " + frequencies[c - 'A'] + "\n");
            }
            for (char c = 'a'; c <= 'z'; c++) {
                writer.write(c + ": " + frequencies[c - 'a' + 26]  + "\n");
            }
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }

        System.out.println("Character frequencies written to: " + outputFilePath);
    }

    private static void buffer(String inputFilePath, int[] frequencies) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            int nextCharInt;
            while ((nextCharInt = reader.read()) != -1) {
                char nextChar = (char) nextCharInt;

                if (isASCIILetters(nextChar)) {
                    int index = getNormalizedIndex(nextChar);
                    frequencies[index]++;
                }
            }
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }
    }

    // TASK 04
    public static void count(Reader reader) {
        Histogram count = new Histogram();

        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            int nextCharInt;
            while ((nextCharInt = bufferedReader.read()) != -1) {
                char nextChar = (char) nextCharInt;
                if (isASCIILetters(nextChar)) {
                    int index = getNormalizedIndex(nextChar);
                    frequencies[index]++;
                }
            }
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }

        System.out.println("Character frequencies:");
        count.printFrequencies();
    }

    public void printFrequencies() {
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println(frequencies[i]);
        }
    }

    public void testCharacterFrequencyCounter() {
        try {
            FileReader reader = new FileReader("files/file.txt");
            count(reader);
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }
    }

}