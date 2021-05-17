package com.chrisg.prog_lang.basic;

import com.chrisg.prog_lang.TokenType;
import com.chrisg.prog_lang.TokenValue;

public class Token {
    private TokenType type;
    private Object value;

    public Token(TokenType type) {
        this.type = type;
    }

    public Token(TokenType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String repr() {
        if (this.value != null) {
            return String.format("%s:%s", this.type, this.value);
        }

        return String.format("%s", this.type);
    }
}
