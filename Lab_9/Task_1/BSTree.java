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
        public void setRight(Node right) {
            this.right = right;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
    }

    public void insert(int value) {
        if (head == null) {
            head = new Node(value, null, null);    
            return;
        }
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current;
            if (current.data < value) { 
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                return;
            }
        }
        if(temp.data < value) {
            temp.setRight(new Node(value, null, null)); 
        } else {
            temp.setLeft(new Node(value, null, null));
        }
    }

    public boolean has(int value) {
        Node current = head;
        while (current != null) {
            if (current.data < value) {
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public int next(int value) {
        Node current = head;
        
        while (current != null) {
            if (current.data < value) {
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                if (current.right != null) {
                    current = current.right;
                    while (current.left != null) {
                        current = current.left;
                    }
                    return current.data;
                }
            }
            System.out.println("There!!!!" + current.data + " and: " + value);
        }
        return 0;
    }
    
    public int prev(int value) {
        Node current = head;
        
        while (current.data != value) {
            if (current.data < value) {
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                    current = current.right;

            }
        }


        return 0;
    }

    public void delete() {
        //TO DO
    }

    public void printTree() {
        // print tree interactive || Inputable tree.length must be = 16 
        // if (head.length <= 16) {
            System.out.print("\n       " + head.data + "\r\n" + //
            "    /     \\\r\n" + //
            "   " + head.left.data + "        " + head.right.data + "\r\n" + //
            "  / \\      /  \\\r\n" + //
            " " + head.left.left.data + "   " + head.left.right.data + "   " + head.right.left.data + "    " + head.right.right.data + "\r\n" + //
                    "/ \\ / \\  / \\   / \\\r\n" + //"");
            "" + head.left.left.left.data + " " + head.left.left.right.data + " " + head.left.right.left.data + " " + head.left.right.right.data + " " + head.right.left.left.data + "  " + head.right.left.right.data + " " + head.right.right.left.data + "  " + head.right.right.right.data + "\n\n");
        // } else {
            System.out.println("Интерактивный вывод доступен только если arr.length <= 8");
        // }
    }
}