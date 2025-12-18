package Lab_1.Task_3;

public class Main {
    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 8, 4, 5, 1};
        
        merge(arr);
        int i = 0;
        boolean t = false;
        while (i < arr.length) {
            try {
                if (arr[i] == arr[i + 1]) {
                    t = true;
                    break;
                }
                i++;
            }
            catch(ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
        System.out.println("Array have twise number: " + t);
    }
    public static void merge(int arr[]) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left_half = new int[mid];
            int[] right_half = new int[arr.length - mid];

            for (int i = 0; i < mid; i++) {
                left_half[i] = arr[i];
            }

            for (int i = mid; i < arr.length; i++) {
                right_half[i - mid] = arr[i];
            }

            merge(left_half);
            merge(right_half);

            int i = 0;
            int j = 0;
            int k = 0;

            while (left_half.length > i && right_half.length > j) {
                if (left_half[i] > right_half[j]) {
                    arr[k] = right_half[j];
                    j++;
                } else {
                    arr[k] = left_half[i];
                    i++;
                }
                k++;
            }

            while (i < left_half.length) {
                arr[k] = left_half[i];
                i++;
                k++;
            }

            while (j < right_half.length) {
                arr[k] = right_half[j];
                j++;
                k++;
            }
        }
    }
}
