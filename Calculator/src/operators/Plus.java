package operators;

import java.util.Stack;

public class Plus implements Operand {
    private final Integer priority = 1;

    @Override
    public void apply(Stack<Float> stack) {
        Float val2 = stack.pop();
        Float val1 = stack.pop();

        stack.add(val1 + val2);
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
