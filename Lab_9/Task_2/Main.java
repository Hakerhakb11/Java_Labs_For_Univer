package Lab_9.Task_2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_9.2");

        BBSTree bstree = new BBSTree();
        
        bstree.insert(8);
        bstree.insert(4);
        bstree.insert(2);
        bstree.insert(1);
        // bstree.insert(3);
        // bstree.insert(6);
        // bstree.insert(5);
        // bstree.insert(7);
        // bstree.insert(12);
        // bstree.insert(10);
        // bstree.insert(11);
        // bstree.insert(9);
        // bstree.insert(14);
        // bstree.insert(13);
        // bstree.insert(15);
        
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

// Big befutifule tree 1-15
//        8
//     /     \
//    4        12
//   / \      /  \
//  2   6   10    14
// / \ / \  / \   / \
// 1 3 5 7 9  11 13 15

// bstree.insert(8);
// bstree.insert(4);
// bstree.insert(2);
// bstree.insert(1);
// bstree.insert(3);
// bstree.insert(6);
// bstree.insert(5);
// bstree.insert(7);
// bstree.insert(12);
// bstree.insert(10);
// bstree.insert(11);
// bstree.insert(9);
// bstree.insert(14);
// bstree.insert(13);
// bstree.insert(15);

// Second tree, without 2 and 6.
//        5
//     /     \
//    3        8
//   / \      /  \
//  1   4   7    9

// bstree.insert(5);
// bstree.insert(3);
// bstree.insert(8);
// bstree.insert(1);
// bstree.insert(4);
// bstree.insert(7);
// bstree.insert(9);

// Test For Univer Lab.
// bstree.insert(5);
// bstree.insert(7);
// bstree.insert(3);
// bstree.insert(4);
// System.out.println(bstree.has(3));
// System.out.println(bstree.has(8));
// bstree.insert(8);
// System.out.println(bstree.has(8));
// // System.out.println(bstree.delete(3));
// System.out.println(bstree.has(4));
// System.out.println(bstree.next(7));
// System.out.println(bstree.prev(5));


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
