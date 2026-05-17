import java.util.List;

import app.Calculator;
import app.Tokenizer;
import operators.Minus;
import operators.Plus;
import tokens.Token;

public class Main {
    public static void main(String[] args) {
    System.out.println("Start CALCULATOR ----------------------");
    
    System.out.println("Welcome to CALCULATOR");

    String input = "4 1 + 5";
    
    Calculator calc = new Calculator();
    Plus plusOp = new Plus();
    Minus minusOp = new Minus();
    
    calc.register("+", plusOp);
    calc.register("-", minusOp);
    Tokenizer tokenizer = new Tokenizer();
    List<Token> tokens = tokenizer.tokenize(input);

    int result = calc.eval(tokens);


    System.out.println("result: " + result);


    System.out.println("End CALCULATOR   ======================");
    }
}
