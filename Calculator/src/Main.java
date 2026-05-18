import java.util.List;

import app.Calculator;
import app.ShuntingYard;
import app.Tokenizer;
import tokens.Token;

import operators.*;
import operators.Module;

public class Main {
    public static void main(String[] args) {
    System.out.println("Start ----------------------");
    
    Calculator calc = new Calculator();
    Plus plusOp = new Plus();
    Minus minusOp = new Minus();
    Multiplicate multiplicateOp = new Multiplicate();
    Devide devideOp = new Devide();
    Sum sumOp = new Sum();
    Module moduleOp = new Module();
    
    calc.register("+", plusOp, 1);
    calc.register("-", minusOp, 1);
    calc.register("*", multiplicateOp, 2);
    calc.register("/", devideOp, 2);
    calc.register("sum", sumOp, 1);
    calc.register("%", moduleOp, 2);
    
    String input1 = "4 1 + 5 *";
    String input2 = "6 8 + 3 %";
    String input3 = "1 2 3 4 5 6 sum";
    String input4 = "(1 + 4) / 5 + 9 % 2";
    System.out.println(calc.getStack());

    Tokenizer tokenizer = new Tokenizer();
    List<Token> tokens1 = tokenizer.tokenize(input1);
    List<Token> tokens2 = tokenizer.tokenize(input2);
    List<Token> tokens3 = tokenizer.tokenize(input3);
    List<Token> tokens4 = tokenizer.tokenize(input4);
    ShuntingYard shuntingYard = new ShuntingYard();
    List<Token> tokens44 = shuntingYard.sort(tokens4, calc);


    float result1 = calc.eval(tokens1);
    float result2 = calc.eval(tokens2);
    float result3 = calc.eval(tokens3);
    float result4 = calc.eval(tokens44);

    boolean check1 = (result1 == (4 + 1) * 5);
    boolean check2 = (result2 == (6 + 8) % 3);
    boolean check3 = (result3 == 1 + 2 + 3 + 4 + 5 + 6);
    boolean check4 = (result4 == (1 + 4) / 5 + 9 % 2);

    System.out.println("result 1: " + result1 + " " + check1);
    System.out.println("result 2: " + result2 + " " + check2);
    System.out.println("result 3: " + result3 + " " + check3);    
    System.out.println("result 4: " + result4 + " " + check4);

    System.out.println("End =======================");
    }
}
