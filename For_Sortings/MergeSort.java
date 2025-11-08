package For_Sortings;

import java.util.List;
import java.util.ArrayList;

public class MergeSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> arr) {
        merge(arr);
    }

    public void merge(List<Integer> arr) {
        if (arr.size() > 1) {
            int mid = arr.size() / 2;
            List<Integer> left_half = new ArrayList<Integer>(mid);
            List<Integer> right_half = new ArrayList<Integer>(arr.size() - mid);

            for (int i = 0; i < mid; i++) {
                left_half.add(i, arr.get(i));
            }

            for (int i = mid; i < arr.size(); i++) {
                right_half.add(i - mid, arr.get(i));
            }

            merge(left_half);
            merge(right_half);

            int i = 0;
            int j = 0;
            int k = 0;

            while (left_half.size() > i && right_half.size() > j) {
                if (left_half.get(i) > right_half.get(j)) {
                    arr.set(k, right_half.get(j));
                    j++;
                } else {
                    arr.set(k, left_half.get(i));
                    i++;
                }
                k++;
            }

            while (i < left_half.size()) {
                arr.set(k, left_half.get(i));
                i++;
                k++;
            }

            while (j < right_half.size()) {
                arr.set(k, right_half.get(j));
                j++;
                k++;
            }
        }
    }
}
