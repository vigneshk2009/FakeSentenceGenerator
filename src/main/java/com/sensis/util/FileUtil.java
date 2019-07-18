package com.sensis.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Utility file to read the data from the file
 * @author Vignesh
 */
public class FileUtil {

    /**
     * This API reads the content from the the file. Replaces any special or punctuation characters.
     * Appends all the lines of the string and returns a string.
     * @param inputFileName - Name of the input file
     * @return - Contents of the file in a string
     */
    public static String parse(String inputFileName) {
        final StringBuilder inputText = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(inputFileName))) {

            stream.forEach(line -> {
                String inputString = line.replaceAll("[^a-zA-Z ]", "");
                inputText.append(inputString + " ");
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputText.toString();

    }

}
