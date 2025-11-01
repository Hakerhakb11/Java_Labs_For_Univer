public class main {
    public static void main (String[] args) {
        int[] arr = {1, 2, 5, 1, 1, 2, 6, 8, 9, 3};
        int n = arr.length;

        Sorting sorting = new InsertionSort();
        sorting.sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}