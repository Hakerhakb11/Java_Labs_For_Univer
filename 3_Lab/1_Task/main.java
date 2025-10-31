import java.util.Arrays;
import java.util.List;

public class main {
    public static void main (String[] args){
        List<Integer> arr = Arrays.asList(124, 1, 68, 57, 0, 93, 60, 24, 71, 125, 70, 87, 83, 105, 34, 30, 15, 1, 2);
        int N = arr.size();

        Sorting sorting = new CountingSort();

        sorting.sort(arr);

        System.out.println("\n\rAfter\n" + N);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}
