package com.chrisg.prog_lang.basic;

import com.chrisg.prog_lang.errors.Error;

import java.util.List;

public class LexerOut {
    private List<Token> tokens;
    private Error error;

    public LexerOut(List<Token> tokens, Error error) {
        this.tokens = tokens;
        this.error = error;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}