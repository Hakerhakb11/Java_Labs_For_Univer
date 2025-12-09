package Lab_8.Task_2;

public class Main {
    public static void main(String[] args) {
        // int[] arr = new int[]{5, 2, 1, 7, 3, 6, 7};
        int[] arr = new int[]{1, 5, 8, 3, 2, 7, 0};

        MinElemTree tree = new MinElemTree(arr);
        tree.printTree();
        System.out.print("" + tree.query(0, 6));
        System.out.print(", " + tree.query(2, 5));
        System.out.print(", " + tree.query(4, 6));
    }
}
