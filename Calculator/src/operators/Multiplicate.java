package operators;

import java.util.Stack;

public class Multiplicate implements Operand {

    @Override
    public void apply(Stack<Float> stack) {
        Float val2 = stack.pop();
        Float val1 = stack.pop();

        stack.add(val1 * val2);
    }
}
