package com.sensis;

import com.sensis.model.WordTuple;
import com.sensis.service.ParsedInput;
import com.sensis.service.SimpleParsedInput;
import com.sensis.util.FileUtil;


import java.io.File;
import java.util.Scanner;

public class App {


    private static Scanner in;

    private static WordTuple readInputWordTuple () {
        System.out.println("Enter first two words of fake sentence. Press enter for default (First two words of input file)");
        System.out.println("First word:");
        String firstWord = in.nextLine();
        if (null == firstWord || "".equalsIgnoreCase(firstWord)) {
            return null;
        }
        System.out.println("Second word:");
        String secondWord = in.nextLine();
        if (null == secondWord || "".equalsIgnoreCase(secondWord)) {
            return null;
        }

        WordTuple wordTuple = new WordTuple.WordTupleBuilder().firstWord(firstWord).secondWord(secondWord).build();
        return wordTuple;
    }

    public static void main(String[] args) {


        System.out.println("* Fake Text Creation Exercise *");
        System.out.println("Enter the input file name: ");
        in = new Scanner(System.in);
        final String inputFileName = in.nextLine();


        if (null == inputFileName || "".equalsIgnoreCase(inputFileName)) {
            System.out.println("Invalid input file name.\n Bye!");
            return;
        }

        final File inputFile = new File(inputFileName);
        if (!inputFile.exists()) {
            System.out.println("Input file does not exist\n Bye!");
            return;
        }

        System.out.println("Processing your file, please wait");
        String inputText = FileUtil.parse(inputFileName);
        ParsedInput parsedInput = new SimpleParsedInput.ParsedInputFileBuilder().from(inputText).build();

        WordTuple inWord = readInputWordTuple();
        System.out.println("Fake Sentence: ");
        if (null != inWord) {
            System.out.println(parsedInput.generateFakeSentence(inWord));
        } else {
            System.out.println(parsedInput.generateFakeSentence());
        }
    }
}
