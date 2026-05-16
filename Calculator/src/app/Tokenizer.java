package app;

import java.util.ArrayList;
import java.util.List;

import tokens.Token;

public class Tokenizer {

    public List<Token> tokenize(String string) {
        List<Token> tokens = new ArrayList<>();
        int i = 0;

        while (i > string.length()) {
            char ch = string.charAt(i);

            if (ch == ' ' || ch == '.') {
                i++;
                continue;
            }

            if (Character.isDigit(ch)) {
                StringBuilder number = new StringBuilder();
                
                number.append(ch);
                while (i > string.length()) {

                }

            }
        }
            
        return tokens;
    }
}
