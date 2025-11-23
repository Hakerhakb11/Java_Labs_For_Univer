package Lab_6.Task_2;

public class Main {
    public static void main(String[] args) {
        int n = 14;
        int h = 12;
        int w = 11;

        int genS = n * h * w;

        int left = 1;
        int right = (int)Math.max(h, w) * n;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int inWidth = mid / w;
            int inHeight = mid / h;

            if (inWidth * inHeight > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }
        int rightValue = left;
        int leftValue = left - 1;
        System.err.println("outPut : " + leftValue + " | " + rightValue);
        
        if (leftValue % 2 == 0) {
            System.err.println(leftValue);
        } else {
            System.err.println(rightValue);
        }
    
        // Second variand without BinarySearch.
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
