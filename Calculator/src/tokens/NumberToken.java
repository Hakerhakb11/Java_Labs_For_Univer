package tokens;

public class NumberToken implements Token {
    private float number;
    
    public NumberToken(float number) {
        this.number = number;
    }

    public float getNumber() {
        return number;
    }
}
