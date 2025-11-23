package Lab_6.Task_2;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        int h = 3;
        int w = 5;

        int genS = n * h * w;
        int roundS = (int)Math.round(Math.sqrt(genS));

        int inWidth = roundS / w;
        int inHeight = roundS / h;
        while (inWidth * inHeight < n) {
            roundS++;
            inWidth = roundS / w;
            inHeight = roundS / h;
        }
        System.out.println("M must be: " + roundS);
    }
}
