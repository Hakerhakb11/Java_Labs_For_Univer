package Lab_9.Task_2; // uncomplete

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_9.2");

        BBSTree bstree = new BBSTree();
        
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
        // bstree.insert(16);
        
        // System.out.println(bstree.next(2));
        // System.out.println(bstree.prev(5));
        // System.out.println(bstree.has(12));
        
        bstree.printTree();
        
        // bstree.delete(12);
        // System.out.println(bstree.has(12));
        
        // bstree.printTree();
        
        System.out.println("\nEnd lab_9.2");
    }
}

//                1
//        /               \
//        8               8
//    /       \       /       \
//    4       1       4       1
//  /   \   /   \   /   \   /   \
//  2   6   1   1   2   6   1   1
// / \ / \ / \ / \ / \ / \ / \ / \
// 0 3 5 7 9 1 1 3 1 5 0 3 5 7 9 1

//                               90
//               /                                \
//               80                              80
//       /                \              /                \
//       10              20              10              20
//   /        \      /        \      /        \      /        \
//   30      40      50      60      30      40      50      60
// /    \  /    \  /    \  /    \  /    \  /    \  /    \  /    \
// 70  80  90  10  11  12  13  14  70  80  90  10  11  12  13  14


        // System.out.print("\n       " + head.data + "\r\n" + //
        // "    /     \\\r\n" + //
        // "   " + head.left.data + "        " + head.right.data + "\r\n" + //
        // "  / \\      /  \\\r\n" + //
        // " " + head.left.left.data + "   " + head.left.right.data + "   " + head.right.left.data + "    " + head.right.right.data + "\r\n" + //
        //         "/ \\ / \\  / \\   / \\\r\n" + //"");
        // "" + head.left.left.left.data + " " + head.left.left.right.data + " " + head.left.right.left.data + " " + head.left.right.right.data + " " + head.right.left.left.data + "  " + head.right.left.right.data + " " + head.right.right.left.data + "  " + head.right.right.right.data + "\n\n");

//        8
//     /     \
//    4        12
//   / \      /  \
//  2   6   10    14
// / \ / \  / \   / \
// 0 3 5 7 9  11 13  15
