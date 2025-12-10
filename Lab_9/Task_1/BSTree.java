package Lab_9.Task_1;

public class BSTree {
    private Node head = null;
    class Node {
        private final int data;
        private final Node left;
        private final Node right;
        
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void insert(int value) {
        Node counterer = head;
        System.out.println("debug: " + head + " debug ");
        try {
            while (counterer != null) {
                if (counterer.data < value) { 
                    counterer = counterer.right;
                } else {
                    counterer = counterer.left; //ладно патом
                }
            }
            System.out.println("Created data");
            head = new Node(value, null, null);

        } catch(NullPointerException e) {
            System.out.println("first null.");
            counterer = new Node(value, null, null);
        }
    }

    public void has() {
        //TO DO
    }

    public void delete() {
        //TO DO
    }

    public void next() {
        //TO DO
    }

    public void prev() {
        //TO DO
    }
    public void printTree() {
        // print tree interactive || Inputable arr.length must be <= 8 
        // if (head.length <= 16) {
            System.out.print("\n       " + head.data + "\r\n" + //
            "    /     \\\r\n" + //
            "   " + head.left.data + "       " + head.right.data + "\r\n"); //+ //
            // "  / \\     / \\\r\n" + //
            // " " + head.left.left.data + "   " + head.left.left.data + "   " + head.right.right.data + "   " + head.right.right.data + "\r\n" + //
            //         "/ \\ / \\ / \\ / \\\r\n" + //"");
            // "" + head.left.left.left.data + " " + head.left.left.left.data + " " + head.left.left.left.data + " " + head.left.left.left.data + " " + head.right.right.right.data + " " + head.right.right.right.data + " " + head.right.right.right.data + " " + head.right.right.right.data + "\n\n");
        // } else {
            System.out.println("Интерактивный вывод доступен только если arr.length <= 8");
        // }
    }

    
}