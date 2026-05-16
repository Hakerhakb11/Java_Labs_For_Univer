import java.util.List;

import app.Calculator;
import app.Tokenizer;
import tokens.Token;

public class Main {
    public static void main(String[] args) {
    System.out.println("Start CALCULATOR ----------------------");
    
    System.out.println("Welcome to CALCULATOR");

    String input = "4 1 + 5";
    
    Calculator calculator = new Calculator();
    Tokenizer tokenizer = new Tokenizer();
    List<Token> tokens = tokenizer.tokenize(input);

    int result = calculator.calc(tokens);


    System.out.println("result: " + result);


    System.out.println("End CALCULATOR   ======================");
    }
}
