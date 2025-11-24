package Lab_6.Task_3;

public class Main {
    public static void main(String[] args) {
        double a = 4.0;
        System.out.println(a);

        double left = 1.0;
        double right = Math.sqrt(a) + 1.0;

        for(int i = 0; i < 100; i++) {
            double mid = (left + right) / 2.0;
            double sol = Math.pow(mid, 2) - mid + Math.sqrt(mid);
            if (sol > a) {
                right = mid;
            } else {
                left = mid;
            } 
        }
        System.out.println(left);
    }
}
