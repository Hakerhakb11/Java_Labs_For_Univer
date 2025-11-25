package Lab_6.Task_2;

public class Main {
    public static void main(String[] args) {
        int n = 2;
        int h = 3;
        int w = 5;

        int left = 1;
        int right = Math.max(h, w) * n;
        
        while (left < right) {
            int mid = (right + left) / 2;
            int inWidth = mid / w;
            int inHeight = mid / h;
            
            if (inWidth * inHeight >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            } 
        }
        System.out.println("BinOutput: " + left);
        
        // // if result incorrect, uncomment this code
        // int rightValue = left;
        // int leftValue = left - 1;
        // System.err.println("outPut : " + leftValue + " | " + rightValue);
        // if (leftValue % 2 == 0) {
        //     System.err.println(leftValue);
        // } else {
        //         System.err.println(rightValue);
        //     }
                
                
        // Second variand without BinarySearch.
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
