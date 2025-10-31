// import java.util.Arrays;
import java.util.List;

public class CountingSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> arr) {
        CountSort(arr);
    }
    public void CountSort(List<Integer> arr) {
        int count[] = new int[128];
    
        for (int num : arr) {
            count[num]++;
        }
        
        int index = 0;
        for(int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr.set(index++, i);
            }
        }

    }
}