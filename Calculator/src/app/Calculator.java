package app;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import operators.Operand;
import tokens.NumberToken;
import tokens.OperandToken;
import tokens.Token;

public class Calculator {
    public static HashMap<String, Operand> registered = new HashMap<>();
    private HashMap<String, Integer> priorities = new HashMap<>();
    private Stack<Float> stack = new Stack<>();

    public float eval(List<Token> tokens) {
        for (Token token : tokens) {
            if (token instanceof NumberToken numberToken) {
                stack.add(numberToken.getNumber());
            } else if (token instanceof OperandToken operandToken) {
                registered.get(operandToken.getOperand()).apply(stack);
            }
        }

        return stack.pop();
    }

    public void register(String nameOp, Operand op, Integer priority) {
        registered.put(nameOp, op);
        priorities.put(nameOp, priority);
    }

    public Stack<Float> getStack() {
        return stack;
    }

    public int getPriority(String string) {
        return priorities.get(string);
    }
}
