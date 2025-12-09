package Lab_8.Task_2;

public class MinElemTree {
    private int[] tree;
    private int size;

    public MinElemTree(int[] arr) {
        size = 1;
        while (size < arr.length) {
            size *= 2;
        }
        tree = new int[size * 2];
        for (int i = 0; i < arr.length; i++) {
            tree[size + i] = arr[i];
        }
        for (int i = arr.length; i < size; i++) {
            tree[size + i] = Integer.MAX_VALUE;
        }
        for (int i = size - 1; i >= 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    public int query(int left, int right) {
        left += size;
        right += size;
        int result = Integer.MAX_VALUE;
        while(left <= right) {
            if ((left % 2) != 0) {
                result = Math.min(result, tree[left++]);
            }
            if ((right % 2) == 0) {
                result = Math.min(result, tree[right--]);            
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }

    public void printTree() {
        // print tree interactive || Inputable arr.length must be <= 8 
        if (tree.length <= 16) {
            System.out.print("\n       " + tree[1] + "\r\n" + //
            "    /     \\\r\n" + //
            "   " + tree[2] + "       " + tree[3] + "\r\n" + //
            "  / \\     / \\\r\n" + //
            " " + tree[4] + "   " + tree[5] + "   " + tree[6] + "   " + tree[7] + "\r\n" + //
                    "/ \\ / \\ / \\ / \\\r\n" + //"");
            "" + tree[8] + " " + tree[9] + " " + tree[10] + " " + tree[11] + " " + tree[12] + " " + tree[13] + " " + tree[14] + " " + tree[15] + "\n\n");
        } else {
            System.out.println("Интерактивный вывод доступен только если arr.length <= 8");
        }
    }
}
