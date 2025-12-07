package Lab_8.Task_1;

//почему немогу с большой буквы писать PrefixSum?
public class prefixSum {
    public int[] prefixSum(int[] arr, int x, int y) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] += prefix[i - 1] + arr[i];
        }
        return prefix;

    }

}
