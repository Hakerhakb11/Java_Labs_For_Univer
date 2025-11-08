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
            List<Integer> leftHalf = new ArrayList<Integer>(mid);
            List<Integer> rightHalf = new ArrayList<Integer>(arr.size() - mid);

            for (int i = 0; i < mid; i++) {
                leftHalf.add(i, arr.get(i));
            }

            for (int i = mid; i < arr.size(); i++) {
                rightHalf.add(i - mid, arr.get(i));
            }

            merge(leftHalf);
            merge(rightHalf);

            int i = 0;
            int j = 0;
            int k = 0;

            while (leftHalf.size() > i && rightHalf.size() > j) {
                if (leftHalf.get(i) > rightHalf.get(j)) {
                    arr.set(k, rightHalf.get(j));
                    j++;
                } else {
                    arr.set(k, leftHalf.get(i));
                    i++;
                }
                k++;
            }

            while (i < leftHalf.size()) {
                arr.set(k, leftHalf.get(i));
                i++;
                k++;
            }

            while (j < rightHalf.size()) {
                arr.set(k, rightHalf.get(j));
                j++;
                k++;
            }
        }
    }
}
