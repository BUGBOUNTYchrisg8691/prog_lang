package com.chrisg.prog_lang.utils;

import java.util.List;

public class HelperFunctions {
    public char[] parseInput(String text) {
        char[] char_arr = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char_arr[i] = text.charAt(i);
        }

        return char_arr;
    }

    public String parseTokens(List tokens) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tokens.size(); i++) {
            sb.append(tokens.get(i));
        }

        return sb.toString();
    }
}
