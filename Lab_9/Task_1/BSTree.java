package Lab_9.Task_1;

public class BSTree {
    private Node head = null;
    class Node {
        private final int data;
        private Node left;
        private Node right;
        
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public void setRight(Node right) { this.right = right; }
        public void setLeft(Node left) { this.left = left; }
        public Node getRight() { return right; }
        public Node getLeft() { return left; }
        public int getData() { return data; }
    }

    public void insert(int value) {
        if (head == null) {
            head = new Node(value, null, null);    
            return;
        }

        Node temp = head;
        while (head != null) {
            temp = head;
            if (head.data < value) { 
                head = head.right;
                temp.right = head;
                System.out.println("to right");
            } else {
                head = head.left;
                temp.left = head;
                System.out.println("to left");
            }
        }
        
        System.out.println("Created data");
        head = new Node(value, null, null);
        System.out.println("head debug: " + head + " debug ");
        head = temp;

        // } catch(NullPointerException e) {
        //     System.out.println("first null.");
        //     head = new Node(value, null, null);
        // }
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
        System.out.println("!!!!!!head debug: " + head.data + " debug ");
        System.out.println("!!!!!!head debug: " + head.left + " debug ");
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