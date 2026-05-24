package app;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;

import operators.Operand;
import tokens.NumberToken;
import tokens.OperandToken;
import tokens.Token;

public class Calculator {
    public static HashMap<String, Supplier<Operand>> registered = new HashMap<>();
    private Stack<Float> stack = new Stack<>();

    public void register(String nameOp, Supplier<Operand> op) {
        registered.put(nameOp, op);
    }

    public float eval(List<Token> tokens) {
        stack.clear();
        for (Token token : tokens) {
            if (token instanceof NumberToken numberToken) {
                stack.add(numberToken.getNumber());
            } else if (token instanceof OperandToken operandToken) {
                Operand op = createOperator(operandToken.getOperand());

                if (op instanceof operators.Function func) {
                    func.setArity(operandToken.getArity());
                }

                if (op != null) {
                    op.apply(stack);
                } else {
                    System.err.println("Ошибка, Операнд не найден почемуто: " + operandToken.getOperand());
                }
            }
        }

        return stack.pop();
    }

    public Operand createOperator(String name) {
        Supplier<Operand> supplier = registered.get(name);
        if (supplier != null) {
            return supplier.get();
        }
        return null;
    }

    public int getPriority(String name) {
        Operand op = createOperator(name);
        return op != null ? op.getPriority() : 0;
    }

    public Stack<Float> getStack() {
        return stack;
    }

    public void clearStack() {
        this.stack.clear();
    }
}