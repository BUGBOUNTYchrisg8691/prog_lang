package com.chrisg.prog_lang.basic;

import com.chrisg.prog_lang.errors.Error;
import com.chrisg.prog_lang.errors.IllegalCharError;
import com.chrisg.prog_lang.TokenType;
import com.chrisg.prog_lang.utils.HelperFunctions;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private char[] text;
    private int pos;
    private Character current_char;

    private HelperFunctions hf = new HelperFunctions();

    public Lexer(String text) {
        this.text = hf.parseInput(text);
        this.pos = -1;
        this.advance();
    }

    public void advance() {
        this.pos++;
        if (this.pos < this.text.length) {
            this.current_char = this.text[this.pos];
        } else {
            this.current_char = null;
        }
    }

    public LexerOut make_tokens() {
        List<Token> tokens = new ArrayList();

        while (this.current_char != null) {
            if (this.current_char == ' ' || this.current_char == '\t') {
                this.advance();
            } else if (this.current_char >= 0 || this.current_char < 10) {
                tokens.add(this.make_number());
                this.advance();
            } else if (this.current_char == '+') {
                tokens.add(new Token(TokenType.TT_PLUS));
                this.advance();
            } else if (this.current_char == '-') {
                tokens.add(new Token(TokenType.TT_MINUS));
                this.advance();
            } else if (this.current_char == '*') {
                tokens.add(new Token(TokenType.TT_MULT));
                this.advance();
            } else if (this.current_char == '/') {
                tokens.add(new Token(TokenType.TT_DIV));
                this.advance();
            } else if (this.current_char == '(') {
                tokens.add(new Token(TokenType.TT_LPAREN));
                this.advance();
            } else if (this.current_char == ')') {
                tokens.add(new Token(TokenType.TT_RPAREN));
                this.advance();
            } else {
                char ch = this.current_char;
                this.advance();

                List<Token> empty_list = new ArrayList();
                Error err = new IllegalCharError('"' + String.valueOf(this.current_char) + '"');

                return new LexerOut(empty_list, err);
            }
        }

        return new LexerOut(tokens, null);
    }

    private Token make_number() {
        StringBuilder num_string = new StringBuilder();
        int dot_count = 0;

        while (this.current_char != null && (this.current_char >= 0 || this.current_char > 10 || this.current_char == '.')) {
            if (this.current_char == '.') {
                if (dot_count == 1) {
                    break;
                }

                dot_count++;
                num_string.append('.');
            } else {
                num_string.append(this.current_char);
            }
        }

        if (dot_count == 0) {
            return new Token(TokenType.TT_INT, Integer.parseInt(num_string.toString()));
        } else {
            return new Token(TokenType.TT_FLOAT, Float.parseFloat(num_string.toString()));
        }
    }
}