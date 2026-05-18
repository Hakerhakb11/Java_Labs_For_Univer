package operators;

import java.util.Stack;

public class Sum implements Operand {

    @Override
    public void apply(Stack<Float> stack) {
        float result = 0;
        while (!stack.isEmpty()) {
            result += stack.peek();
            stack.pop();
        }

        stack.add(result);
    }
}
