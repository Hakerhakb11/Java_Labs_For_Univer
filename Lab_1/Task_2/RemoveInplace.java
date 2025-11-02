package Lab_1.Task_2;

public class RemoveInplace {
        public static int remove_elem_inplace(int arr[], int val) {
            int j = 0;
            int count = 0;
            System.out.print("Input: arr = [");
            for(int i : arr) {
                System.out.print(i + ",");
                if (i != val) {
                    arr[j++] = arr[i];
                } else {
                    count++;
                }
            }
            System.out.print("], val = " + val);
            return count;
        }
}