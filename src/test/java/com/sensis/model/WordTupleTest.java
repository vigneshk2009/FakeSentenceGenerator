package com.sensis.model;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class WordTupleTest {

    private static final String FIRST_WORD = "firstWord";
    private static final String SECOND_WORD = "secondWord";

    @Test
    public void testEquals() {
        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();
        WordTuple secondWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();

        assertTrue(firstWordTuple.equals(secondWordTuple));
    }

    @Test
    public void testNotEquals() {

        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord("").secondWord(SECOND_WORD).build();
        WordTuple secondWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();

        assertFalse(firstWordTuple.equals(secondWordTuple));
    }

    @Test
    public void testNullEquals() {
        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord("").secondWord(SECOND_WORD).build();

        assertFalse(firstWordTuple.equals(null));
    }

    @Test
    public void testInverse() {
        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();
        WordTuple secondWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();

        assertTrue(firstWordTuple.equals(secondWordTuple));
        assertTrue(secondWordTuple.equals(firstWordTuple));
    }

    @Test
    public void testAssociativeEqulas() {
        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();
        WordTuple secondWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();
        WordTuple thirdWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();

        if (firstWordTuple.equals(secondWordTuple) && secondWordTuple.equals(firstWordTuple)) {
            assertTrue(thirdWordTuple.equals(firstWordTuple));
        }
    }

    @Test
    public void testEqualHash() {
        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();
        WordTuple secondWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();

        assertEquals(firstWordTuple.hashCode(), secondWordTuple.hashCode());
    }

    @Test
    public void testUnequalHash() {
        WordTuple firstWordTuple = new WordTuple.WordTupleBuilder().firstWord(FIRST_WORD).secondWord(SECOND_WORD).build();
        WordTuple secondWordTuple = new WordTuple.WordTupleBuilder().firstWord(SECOND_WORD).secondWord(FIRST_WORD).build();

        assertNotEquals(firstWordTuple.hashCode(), secondWordTuple.hashCode());
    }
}
