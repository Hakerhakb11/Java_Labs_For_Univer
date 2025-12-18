package Lab_1.Task_2;

public class Main {
        public static void main(String[] args) {
            int[] arr = {2, 6, 3, 4, 5, 6, 5, 2, 3, 6};
            int val = 6;

            RemoveInplace removeInplace = new RemoveInplace();
            
            int count = removeInplace.removeElemInplace(arr, val);
            
            System.out.print("\nOutput: " + count + ", arr = [");
            for(int k = 0; k < count; k++) {
                System.out.print(val + ",");
            }
            System.out.println(']');
        }
    }