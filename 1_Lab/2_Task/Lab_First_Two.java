public class Lab_First_Two {
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
        public static void main(String[] args) {
            int[] arr = {2, 6, 3, 4, 5, 6, 5, 2, 3, 6};
            int val = 6;
            
            int count = remove_elem_inplace(arr, val);
            
            System.out.print("\nOutput: " + count + ", arr = [");
            for(int k = 0; k < count; k++) {
                System.out.print(val + ",");
            }
            System.out.println(']');
        }
    }
    // System.out.print("\n2). Output: " + arr.length + ", arr = [");
    // for(int k = 0; k < arr.length - count; k++)
    // {
    //     System.out.print(arr[k] + ",");
    // }
    // System.out.println(']');
// Input: arr = [4,5,5,4], val = 4
// Output: 2, arr = [5,5,_,_]