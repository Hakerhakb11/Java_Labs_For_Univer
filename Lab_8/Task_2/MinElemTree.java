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
            tree[size + i] = 111;
        }
        for (int i = size - 1; i >= 0; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
    }
    public int query(int i, int j) {
        System.out.println("Start query\n");

        i += size;
        j += size;
        System.out.println(tree[i] + " and: " + tree[j]);
        


        System.out.println("\nEnd query");
        return 1;
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
            // // not completed version of print
            // int count = 1;
            // int j = 0;
            // while (count <= 32) {
            //     count = count * 2;
            //     for (int i = 0; i < count; i++) {
            //         System.out.print(tree[j++] + " ");
            //     }
            //     System.out.println();
            // }
        }
    }
    
}
