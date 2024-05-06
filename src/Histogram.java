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

    public void writeStringToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("'" + content + "'"+ " successfully written to the file: " + filePath);
        } catch (IOException e) {
            logger.severe("An error occurred:");
            logger.severe(e.toString());
        }
    }

}
