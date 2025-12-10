package Lab_9.Task_1;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_9.1");

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        System.out.println();

        BSTree bstree = new BSTree();

        bstree.insert(3);
        bstree.insert(6);
        bstree.insert(2);

        bstree.printTree();


        System.out.println("\nEnd lab_9.1");
    }
}
