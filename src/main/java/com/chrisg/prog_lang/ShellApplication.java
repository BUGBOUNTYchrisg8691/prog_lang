package com.chrisg.prog_lang;

import com.chrisg.prog_lang.basic.Lexer;
import com.chrisg.prog_lang.basic.LexerOut;
import com.chrisg.prog_lang.utils.HelperFunctions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HelperFunctions hf = new HelperFunctions();

        while (true) {
            System.out.print("Basic> ");
            String input = reader.readLine();

            Lexer lexer = new Lexer(input);
            LexerOut lexout = lexer.make_tokens();

            if (lexout.getError() != null) {
                System.out.println(lexout.getError().as_string());
            } else {
                System.out.println(hf.parseTokens(lexout.getTokens()));
            }
        }
    }

    public LexerOut run(String input) {
        Lexer lexer = new Lexer(input);
        LexerOut lexout = lexer.make_tokens();
        return lexout;
    }
}