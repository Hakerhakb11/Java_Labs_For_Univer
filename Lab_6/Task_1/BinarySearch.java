package Lab_6.Task_1;

import java.util.List;
import java.util.ArrayList;

public class BinarySearch {
    public List<Integer> searchNearValue(List<Integer> arr, List<Integer> request) {
        List<Integer> out = new ArrayList<>();

        for (int requestNum : request) {
            int right = arr.size() - 1;
            int left = 0;
            if (requestNum > arr.get(right)) {
                out.add(arr.get(right));
            } else if (requestNum < arr.get(left)) {
                out.add(arr.get(left));
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
                    out.add(arr.get(leftValue));
                } else {
                    out.add(arr.get(rightValue));
                }
            }
        }
        return out;
    }
}
