package tokens;

public class OperandToken implements Token {
    private final String operand;
    private int arity;

    public OperandToken(String operand) {
        this.operand = operand;
    }

    public String getOperand() {
        return operand;
    }

    public void setArity(int arity) {
        this.arity = arity;
    }

    public int getArity() {
        return arity;
    }
}
