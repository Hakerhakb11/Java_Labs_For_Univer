package Lab_8.Task_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_8.2");

        int[] arr = new int[]{5, 2, 1, 7, 3, 6, 7};

        MinElemTree tree = new MinElemTree(arr);
        tree.printTree();
        System.out.println(tree.query(0, 4)); // 1
        // System.out.println(tree.query(2, 4)); // 3
        // System.out.println(tree.query(4, 6)); // 5


        System.out.println("\nEnd lab_8.2");
    }
}
