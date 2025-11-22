package Lab_6.Task_1;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab 6.1");
        List<Integer> arr = Arrays.asList(1,5,12, 100);
        List<Integer> req = Arrays.asList(1, 2, 3, 4, 2, 7, 11, 15,35,45,88);
        for (int reqNum : req) {
            int right = arr.size() - 1;
            int left = 0;
            if (reqNum > arr.get(right)) {
                System.out.println(arr.get(right));
            } else if (reqNum < arr.get(left)) {
                System.out.println(arr.get(left));
            } else {
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (reqNum < arr.get(mid)) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    } 
                }
                int rightValue = left;
                int leftValue = left - 1;
                if (Math.abs(arr.get(leftValue) - reqNum) < Math.abs(arr.get(rightValue) - reqNum)) {
                    System.out.println(arr.get(leftValue));
                } else {
                    System.out.println(arr.get(rightValue));
                }
            }
        }
        System.out.println("End lab 6.1");
    }
}
