package tokens;

public class BracketToken implements Token {
    private String bracket;

    public BracketToken(String bracket) {
        this.bracket = bracket;
    }

    public String toString() {
        return bracket;
    }

    public boolean isOpen() {
        if (bracket.equals("(")) {
            return true;
        } else {
            return false;
        }
    }
}
