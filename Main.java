import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //task 2 function
    public static int[] randomNumbers() {
        int[] doubleArray = new int[10];
        for (int i = 0; i < 10; i++) {
            doubleArray[i] = (int) (Math.round(Math.random() * 100));

        }
        return doubleArray;
    }

    public static void main(String[] args) {
        //Task 1
        double[] array = {4.34, 5.22, 2.23, 6.12, 7.11};
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Choose a number between 0 and 4: ");
        number = scanner.nextInt();
        //Task 1 version 1
        try {
            System.out.println("You chose number: " + array[number]);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Let's continue.");
        //Task 1 version 2 throw new default java exception
        try {

            if (number >= array.length) {
                throw new IllegalArgumentException("INVALID");
            }
            System.out.println("You chose number: " + array[number]);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        System.out.println("Let's continue, again.");

        //Task 2
        int[] randomNumbers = randomNumbers();
        String fileName = "random_numbers.txt";
        String fileNameCsv = "random_numbers.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int value : randomNumbers) {
                writer.write(Integer.toString(value));
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNameCsv))) {
            for (int value : randomNumbers) {
                writer.write(Integer.toString(value));
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
          //Task 3
        String[] shortWords = new String[20];
        String[] longWords = new String[20];
        int shortIndex = 0;
        int longIndex = 0;

        try {
            FileReader fr = new FileReader("input_file.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line;

            while ((line = reader.readLine()) != null && (shortIndex < 4 || longIndex < 4)) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.length() <= 3 && shortIndex < 20) {
                        shortWords[shortIndex++] = word;
                    } else if (word.length() >= 4 && longIndex < 20) {
                        longWords[longIndex++] = word;
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        String[] correctedShortWords = Arrays.copyOf(shortWords, shortIndex);
        String[] correctedLongWords = Arrays.copyOf(longWords, longIndex);
        System.out.println("Short words:");
        for (String value : correctedShortWords) {
            System.out.println(value);
        }

        System.out.println("Long words:");
        for (String value : correctedLongWords) {
            System.out.println(value);
        }

        String fileShortWords = "small_words.txt";
        String fileLongWords = "long_words.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileShortWords))) {
            for (String value : correctedShortWords) {
                writer.write(value);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileLongWords))) {
            for (String value : correctedLongWords) {
                writer.write(value);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
