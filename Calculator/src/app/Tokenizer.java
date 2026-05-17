package app;

import java.util.ArrayList;
import java.util.List;

import tokens.NumberToken;
import tokens.OperatorToken;
import tokens.Token;

public class Tokenizer {

    public List<Token> tokenize(String string) {
        System.out.println("Tokze string: " + string);
        List<Token> tokens = new ArrayList<Token>();
        int i = 0;

        while (i < string.length()) {
            char ch = string.charAt(i);
            
            if (ch == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(ch)) {
                StringBuilder numberBuild = new StringBuilder();
                boolean havePoint = false;
                numberBuild.append(ch);
                i++;
                while (i < string.length()) {
                    ch = string.charAt(i);
                    if (Character.isDigit(ch)) {
                        numberBuild.append(ch);
                        i++;
                    } else if (!havePoint && ch == '.') {
                        numberBuild.append(ch);
                        havePoint = true;
                        i++; 
                    } else if (ch == ' ') {
                        i++;
                        break;
                    } else {
                        i++;
                        System.out.println("Пропустить: " + ch);
                        continue;
                    }
                }
                String stringNumber = numberBuild.toString();
                float number = parseFloat(stringNumber);
                NumberToken numToken = new NumberToken(number);
                tokens.add(numToken);
                System.out.println("Number: " + numberBuild);
            } else {
                StringBuilder stringBuild = new StringBuilder();
                stringBuild.append(ch);
                i++;
                while (i < string.length()) {
                    ch = string.charAt(i);
                    if (ch == ' ') {
                        i++;
                        break;
                    }
                }
                String stringOperand = stringBuild.toString();
                if (Calculator.registered.containsKey(stringOperand)) {
                    OperatorToken opToken = new OperatorToken(stringOperand);
                    tokens.add(opToken);
                    System.out.println("String: " + stringBuild);
                }
            } 
        }
        return tokens;
    }

    public float parseFloat(String stringNumber) {
        int i = 0;
        float number = 0;
        boolean havePoint = false;

        int divisor = 10;
        while (i < stringNumber.length()) {
            char ch = stringNumber.charAt(i);
            if (Character.isDigit(ch) && !havePoint) {
                number = number * divisor + ch - '0';
                i++;
            } else if (!havePoint && ch == '.') {
                i++;
                havePoint = true;
                continue;
            } else {
                number = number + (ch - '0') / divisor;
                divisor *= 10;
            }
        }
        System.out.println("END NUMBER: " + number);

        return number;
    }
}
