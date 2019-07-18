package com.sensis.service;

import com.sensis.model.WordTuple;
import org.junit.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleParsedInputTest {

    private static final String INPUT_TXT = "I wish I may I wish I might";
    private static final String EXPECTED_OUT_PUT = "I wish I might";

    ParsedInput simpleParsedInputFile;

    @Test(expected=IllegalArgumentException.class)
    public void testLessThanTwoWords() {
        simpleParsedInputFile = new SimpleParsedInput.ParsedInputFileBuilder().from("Wish").build();

    }

    @Test
    public void testExactlyTwoWords() {
        simpleParsedInputFile = new SimpleParsedInput.ParsedInputFileBuilder().from("I Wish").build();

        assertEquals(simpleParsedInputFile.generateFakeSentence(), "I Wish");
    }

    @Test
    public void testSimpleInput() {
        simpleParsedInputFile = new SimpleParsedInput.ParsedInputFileBuilder().from(INPUT_TXT).build();

        assertEquals(simpleParsedInputFile.generateFakeSentence(), EXPECTED_OUT_PUT);
    }

    @Test
    public void testFakeSentenceWithWordTuple() {
        simpleParsedInputFile = new SimpleParsedInput.ParsedInputFileBuilder().from(INPUT_TXT).build();
        WordTuple wordTuple = new WordTuple.WordTupleBuilder().firstWord("I").secondWord("wish").build();

        assertEquals(simpleParsedInputFile.generateFakeSentence(wordTuple), EXPECTED_OUT_PUT);
    }

}
