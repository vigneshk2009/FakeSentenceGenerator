package com.sensis.service;

import com.sensis.model.WordTuple;

public interface ParsedInput {

    String generateFakeSentence();

    String generateFakeSentence(WordTuple wordTuple);

}
