package tokens;

public class OperandToken implements Token {
    private String operand;
    
    public OperandToken (String operand) {
        this.operand = operand;
    }
    
    public String getOperand() {
        return operand;
    }
}
