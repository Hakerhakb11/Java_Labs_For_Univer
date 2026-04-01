package Lab_9.Task_2;

public class Main {
    public static void main(String[] args) {
        BBSTree bstree = new BBSTree();

        bstree.insert(10);
        bstree.insert(5);
        bstree.insert(15);
        bstree.insert(3);
        bstree.insert(7);
        bstree.insert(20);
        bstree.insert(6);

        System.out.println(bstree.next(2));
        System.out.println(bstree.prev(5));
        System.out.println(bstree.has(12));

        bstree.printTree();
        bstree.delete(20);
        bstree.printTree();
    }
}
