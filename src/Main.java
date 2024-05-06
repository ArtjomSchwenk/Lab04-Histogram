package src;



public class Main {
    public static void main(String [] args){

        // TASK 01
        Histogram histogram = new Histogram();
        String path = "files/script.txt";
        histogram.getNextCharacter(path);
        Character nextChar = Histogram.getNextCharacter(path);

        if (histogram != null) {
            System.out.println("Next character in the file: " + nextChar);
        } else {
            System.out.println("End of file reached or error occurred.");
        }

        // TASK 02
        histogram.writeStringToFile("files/file.txt", "TESTING STRING");
        histogram.writeIntegerToFile("files/file.txt", 123);
        histogram.createFile("files/testFile.txt");

        // TASK 03
        histogram.countCharacterFrequencies("files/script.txt", "files/ASCIILetters.txt");

        // TASK 04
        histogram.testCharacterFrequencyCounter();

        // TASK 05
        histogram.testMostFrequentChar("files/script.txt");

        // TASK 07
        histogram.printHistogramWithStars(3);
    }
}
