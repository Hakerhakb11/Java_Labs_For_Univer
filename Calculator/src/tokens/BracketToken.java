package tokens;

public class BracketToken implements Token {
    private String bracket;
    
    public BracketToken (String bracket) {
        this.bracket = bracket;
    }
    
    public String getOperand() {
        return bracket;
    }

    public boolean isOpen() {
        if (bracket == "(") {
            return true;
        } else {
            return false;
        }
    }
}
