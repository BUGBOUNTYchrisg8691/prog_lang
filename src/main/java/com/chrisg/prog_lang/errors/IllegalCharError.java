package com.chrisg.prog_lang.errors;

public class IllegalCharError implements Error {
    private final String error_name = "Illegal Character";
    private String details;

    public IllegalCharError(String details) {
        this.details = details;
    }

    @Override
    public String as_string() {
        return String.format("%s: %s", this.error_name, this.details);
    }
}
