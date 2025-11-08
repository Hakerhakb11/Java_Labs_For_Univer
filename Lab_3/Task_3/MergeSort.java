package Lab_3.Task_3;

import java.util.List;
import java.util.ArrayList;
import For_Sortings.Sorting;

public class MergeSort<T extends Comparable <? super T>> implements Sorting<T> {
    @Override
    public void sort(List<T> arr) {
        merge(arr);
    }

    public void merge(List<T> arr) {
        if (arr.size() > 1) {
            int mid = arr.size() / 2;
            List<T> leftHalf = new ArrayList<T>(mid);
            List<T> rightHalf = new ArrayList<T>(arr.size() - mid);

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
                if(leftHalf.get(i).compareTo(rightHalf.get(j)) > 0) {
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
