package tokens;

public class OperatorToken implements Token {
    private String operand;
    
    public OperatorToken (String operand) {
        this.operand = operand;
    }
    
    public String getNumber() {
        return operand;
    }
}
