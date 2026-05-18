package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tokens.NumberToken;
import tokens.OperandToken;
import tokens.BracketToken;
import tokens.Token;

public class ShuntingYard {
    public List<Token> sort(List<Token> infixTokens, Calculator calc) {
        List<Token> output = new ArrayList<>();
        Stack<Token> operatorStack = new Stack<>();

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
                }
            }

            else if (token instanceof OperandToken currentOperandToken) {
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

        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        return output;
    }
}
