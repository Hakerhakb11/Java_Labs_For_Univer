package app;

import java.util.ArrayList;
import java.util.List;

import tokens.BracketToken;
import tokens.CommaToken;
import tokens.NumberToken;
import tokens.OperandToken;
import tokens.Token;

public class Tokenizer {

    public List<Token> tokenize(String string) {
        List<Token> tokens = new ArrayList<Token>();
        int i = 0;

        while (i < string.length()) {
            char ch = string.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(ch) || (ch == '-' && i + 1 < string.length() && Character.isDigit(string.charAt(i + 1)))) {
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
                        break;
                    }
                }

                String stringNumber = numberBuild.toString();
                float number = parseFloat(stringNumber);
                NumberToken numToken = new NumberToken(number);
                tokens.add(numToken);

            } else if (ch == '(' || ch == ')') {
                String bracketString = String.valueOf(ch);
                BracketToken bracketToken = new BracketToken(bracketString);
                tokens.add(bracketToken);
                i++;

            } else if (ch == ',') {
                tokens.add(new CommaToken());
                i++;

            } else {
                StringBuilder stringBuild = new StringBuilder();

                while (i < string.length()) {
                    ch = string.charAt(i);
                    if (ch == ' ' || ch == '(' || ch == ')' || ch == ',' || Character.isDigit(ch)) {
                        break;
                    }
                    stringBuild.append(ch);
                    i++;
                }
                String stringOperand = stringBuild.toString();
                if (!stringOperand.isEmpty() && Calculator.registered.containsKey(stringOperand)) {
                    OperandToken opToken = new OperandToken(stringOperand);
                    tokens.add(opToken);
                }
            }
        }
        return tokens;
    }

    private float parseFloat(String stringNumber) {
        int i = 0;
        float number = 0;
        boolean havePoint = false;
        boolean isNegative = false;

        if (stringNumber.charAt(i) == '-') {
            isNegative = true;
            i++;
        }

        float divisor = 10;
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
                i++;
            }
        }

        if (isNegative) {
            return -number;
        }
        return number;
    }
}
