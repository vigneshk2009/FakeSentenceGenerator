package com.sensis.model;

import java.util.Objects;

/**
 * This is class holds two word tuples
 * @author Vignesh
 */
public class WordTuple {

    private String firstWord;
    private String secondWord;

    private WordTuple(WordTupleBuilder wordTupleBuilder) {
        this.firstWord = wordTupleBuilder.firstWord;
        this.secondWord = wordTupleBuilder.secondWord;

    }

    public String getFirstWord() {
        return firstWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public static class WordTupleBuilder {
        private String firstWord;
        private String secondWord;

        public WordTupleBuilder firstWord (String firstWord) {
            this.firstWord = firstWord;
            return this;
        }

        public WordTupleBuilder secondWord(String secondWord) {
            this.secondWord = secondWord;
            return this;
        }

        public WordTuple build() {
            return new WordTuple(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordTuple)) return false;
        WordTuple wordTuple = (WordTuple) o;
        return Objects.equals(getFirstWord(), wordTuple.getFirstWord()) &&
                Objects.equals(getSecondWord(), wordTuple.getSecondWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstWord(), getSecondWord());
    }

    @Override
    public String toString() {
        return firstWord + ((null != secondWord && !"".equalsIgnoreCase(secondWord)) ? " " + secondWord : "");
    }
}
