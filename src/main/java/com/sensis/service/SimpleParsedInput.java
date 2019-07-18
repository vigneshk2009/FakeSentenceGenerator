package com.sensis.service;

import com.sensis.model.WordTuple;

import java.util.HashMap;
import java.util.Map;

/**
 * This file holds the parsed data. The parsed data is stored in a hash map.
 * The twor tuple is the key and the next word is the value
 * @author Vignesh
 */
public class SimpleParsedInput implements ParsedInput {

    private static final int MAX_SENTENCE_LENGTH = 50;
    private Map<WordTuple, String> wordTupleStringMap = new HashMap<>();
    private WordTuple firstWordTuple;

    private SimpleParsedInput(ParsedInputFileBuilder parsedInputFileBuilder) {
        this.wordTupleStringMap = parsedInputFileBuilder.wordTupleStringMap;
        this.firstWordTuple = parsedInputFileBuilder.firstWordTuple;
    }


    public static class ParsedInputFileBuilder {
        private final Map<WordTuple, String> wordTupleStringMap = new HashMap<>();
        private WordTuple firstWordTuple;

        /**
         * Generates the hash map from the inputText
         */
        public ParsedInputFileBuilder from(String inputText) {

            String[] words = inputText.split(" ");
            if (words.length < 2) {
                throw new IllegalArgumentException("Sentence should have at least two words");
            }

            this.firstWordTuple = new WordTuple.WordTupleBuilder().firstWord(words[0]).secondWord(words[1]).build();
            wordTupleStringMap.put(this.firstWordTuple, "");

            if (words.length == 2) {
                return this;
            }

            WordTuple previousTuple = this.firstWordTuple;
            for (int i = 2; i < words.length; i++) {
                if (wordTupleStringMap.get(previousTuple) != null) {
                    if (wordTupleStringMap.get(previousTuple).length() < words[i].length()) {
                        wordTupleStringMap.put(previousTuple, words[i]);
                    }
                } else {
                    wordTupleStringMap.put(previousTuple, words[i]);
                }
                previousTuple = new WordTuple.WordTupleBuilder().firstWord(previousTuple.getSecondWord()).secondWord(words[i]).build();
            }

            return this;
        }

        public SimpleParsedInput build() {
            return new SimpleParsedInput(this);
        }
    }


    @Override
    public String generateFakeSentence() {
        return this.generateFakeSentence(this.firstWordTuple);
    }

    /**
     * Generates the fake sentences based on the word tuple passed in.
     * @param wordTuple - Two words of the sentence
     * @return - Fake sentence
     */
    @Override
    public String generateFakeSentence(WordTuple wordTuple) {
        StringBuilder fakeSentence = new StringBuilder();
        fakeSentence.append(wordTuple.toString());

        WordTuple nextTuple = wordTuple;
        String nextWord = this.wordTupleStringMap.get(nextTuple);
        int wordCounter = 2;

        while (null != nextWord && !"".equalsIgnoreCase(nextWord)
            && wordCounter++ < MAX_SENTENCE_LENGTH) {
            fakeSentence.append(" "+ nextWord);
            nextTuple = new WordTuple.WordTupleBuilder().firstWord(nextTuple.getSecondWord()).secondWord(nextWord).build();
            nextWord = this.wordTupleStringMap.get(nextTuple);
        }

        return fakeSentence.toString();
    }
}
