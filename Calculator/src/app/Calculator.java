package app;

import java.util.HashMap;
import java.util.List;

import operators.Operator;
import tokens.Token;

public class Calculator {
    public static HashMap<String, Operator> registered = new HashMap<>();

    public int eval(List<Token> tokens) {
        return 0; ///////// todo
    }

    public void register(String nameOp, Operator op) {
        registered.put(nameOp, op);
    }
}
