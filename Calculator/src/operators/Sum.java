package operators;

import java.util.Stack;

public class Sum implements Function {
    private final Integer priority = 3;
    private int arity;

    public void apply(Stack<Float> stack) {
        int finalArity = stack.size();
        if (arity > 0) {
            finalArity = arity;
        }
        float result = 0;
        for (int i = 0; i < finalArity; i++) {
            if (!stack.isEmpty()) {
                result += stack.pop();
            }
        }

        stack.add(result);
    }

    public void setArity(int arity) {
        this.arity = arity;
    }

    public int getPriority() {
        return priority;
    }
}
