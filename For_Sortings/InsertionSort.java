package For_Sortings;

public class InsertionSort implements Sorting2<Integer> {
    @Override
    public void sort(int[] arr) {
        insert(arr);
    }
     
    public void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = 0;
            
            while (i - 1 >= 0) {
                if(arr[i] < arr[i - 1]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
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
    
    