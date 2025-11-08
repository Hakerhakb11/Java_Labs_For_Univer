package For_Sortings;

import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> arr) {
        insert(arr);
    }
     
    public void insert(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int k = 0;
            while (i - 1 >= 0) {
                if(arr.get(i) < arr.get(i - 1)) {
                    int temp = arr.get(i - 1);
                    arr.set(i - 1, arr.get(i));
                    arr.set(i, temp);
                    k++;
                    i--;
                } else {
                    break;
                }
            }
            i += k;
        }
    }
}
    
    