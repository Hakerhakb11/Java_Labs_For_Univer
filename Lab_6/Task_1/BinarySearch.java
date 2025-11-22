package Lab_6.Task_1;

import java.util.List;

public class BinarySearch {
    public int searchNearValue(List<Integer> arr, List<Integer> request) {
        for (int requestNum : request) {
            int right = arr.size() - 1;
            int left = 0;
            if (requestNum > arr.get(right)) {
                // System.out.println(arr.get(right));
                return arr.get(right);
            } else if (requestNum < arr.get(left)) {
                // System.out.println(arr.get(left));
                return arr.get(left);
            } else {
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (requestNum < arr.get(mid)) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    } 
                }
                int rightValue = left;
                int leftValue = left - 1;
                if (Math.abs(arr.get(leftValue) - requestNum) < Math.abs(arr.get(rightValue) - requestNum)) {
                    // System.out.println(arr.get(leftValue));
                    return arr.get(leftValue);
                } else {
                    // System.out.println(arr.get(rightValue));
                    return arr.get(rightValue);
                }
            }
        }
    }
}