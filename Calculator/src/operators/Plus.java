package operators;

import java.util.Stack;

public class Plus implements Operator {
    private String plus = "+";

    @Override
    public void apply(Stack<Float> stack) {
        Float val2 = stack.pop();
        Float val1 = stack.pop();
        stack.add(val1 + val2);
    }

    public String getPlus() {
        return plus;
    }
}
