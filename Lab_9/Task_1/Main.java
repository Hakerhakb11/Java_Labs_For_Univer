package Lab_9.Task_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_9.1");

        BSTree bstree = new BSTree();

//        8
//     /     \
//    4        12
//   / \      /  \
//  2   6   10    14
// / \ / \  / \   / \
// 1 3 5 7 9  11 13 15

        bstree.insert(8);
        bstree.insert(4);
        bstree.insert(2);
        bstree.insert(1);
        bstree.insert(3);
        bstree.insert(6);
        bstree.insert(5);
        bstree.insert(7);
        bstree.insert(12);
        bstree.insert(10);
        bstree.insert(11);
        bstree.insert(9);
        bstree.insert(14);
        bstree.insert(13);
        bstree.insert(15);

        System.out.println(bstree.next(16));
        
        bstree.printTree();

        System.out.println("\nEnd lab_9.1");
    }
}
