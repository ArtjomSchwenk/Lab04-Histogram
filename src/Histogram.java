package src;

import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.Reader;
import java.util.logging.Logger;

public class Histogram {
    public void readFile() {
        private static final Logger logger = Logger.getLogger(Histogram.class.getName());
        Path path = Paths.get("files/script.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
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

}
}