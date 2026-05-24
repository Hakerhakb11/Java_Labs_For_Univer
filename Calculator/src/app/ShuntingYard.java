package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import operators.Function;
import operators.Operand;
import tokens.BracketToken;
import tokens.CommaToken;
import tokens.NumberToken;
import tokens.OperandToken;
import tokens.Token;

public class ShuntingYard {
    public List<Token> sort(List<Token> infixTokens, Calculator calc) {
        List<Token> output = new ArrayList<>();
        Stack<Token> operatorStack = new Stack<>();
        Stack<Integer> arityStack = new Stack<>();

        for (Token token : infixTokens) {

            if (token instanceof NumberToken) {
                output.add(token);
            }

            else if (token instanceof BracketToken bracket) {
                if (bracket.isOpen()) {
                    operatorStack.push(token);
                } else {
                    while (!operatorStack.isEmpty() && !(operatorStack.peek() instanceof BracketToken)) {
                        output.add(operatorStack.pop());
                    }

                    if (!operatorStack.isEmpty()) {
                        operatorStack.pop();
                    }

                    if (!operatorStack.isEmpty() && operatorStack.peek() instanceof OperandToken) {
                        OperandToken funcToken = (OperandToken) operatorStack.peek();
                        Operand op = calc.createOperator(funcToken.getOperand());

                        if (op instanceof Function) {
                            funcToken = (OperandToken) operatorStack.pop();

                            int finalArity = arityStack.pop();

                            funcToken.setArity(finalArity);

                            output.add(funcToken);
                        }
                    }
                }
            }

            else if (token instanceof CommaToken) {
                while (!operatorStack.isEmpty() && !(operatorStack.peek() instanceof BracketToken)) {
                    output.add(operatorStack.pop());
                }
                if (!arityStack.isEmpty()) {
                    int currentArity = arityStack.pop();
                    arityStack.push(currentArity + 1);
                }
            }

            else if (token instanceof OperandToken currentOperandToken) {
                Operand op = calc.createOperator(currentOperandToken.getOperand());

                if (op instanceof Function) {
                    arityStack.push(1);
                    operatorStack.push(currentOperandToken);
                }

                else {
                    int currentPriority = calc.getPriority(currentOperandToken.getOperand());

                    while (!operatorStack.isEmpty() && operatorStack.peek() instanceof OperandToken topOpToken) {
                        int topPriority = calc.getPriority(topOpToken.getOperand());

                        if (topPriority >= currentPriority) {
                            output.add(operatorStack.pop());
                        } else {
                            break;
                        }
                    }
                    operatorStack.push(currentOperandToken);
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        return output;
    }
}
