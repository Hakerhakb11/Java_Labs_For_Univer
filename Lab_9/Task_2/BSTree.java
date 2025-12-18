package Lab_9.Task_2;

public class BSTree {
    private Node head = null;
    class Node {
        private int data;
        private Node left;
        private Node right;
        
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public int getData() {
            return this.data;
        }
        public void setRight(Node right) {
            this.right = right;
        }
        public void setLeft(Node left) {
            this.left = left;
        }
    }

    public void insert(int value) {
        Node current = head;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (current.data < value) { 
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                return;
            }
        }
        if (head == null) {
            head = new Node(value, null, null);    
            return;
        }
        if(parent.data < value) {
            parent.setRight(new Node(value, null, null)); 
        } else {
            parent.setLeft(new Node(value, null, null));
        }
    }

    public boolean has(int value) {
        Node current = head;
        while (current != null) {
            if (value < current.data) {
                current = current.left;
            } else if (value > current.data) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public int next(int value) {
        Node current = head;
        Node parent = null;
        
        while (current != null) {
            if (current.data < value) {
                current = current.right;
            } else if (current.data > value) {
                parent = current;
                current = current.left;
            } else {
                if (current.right != null) {
                    current = current.right;
                    while (current.left != null) {
                        current = current.left;
                    }
                    return current.data;
                } else {
                    return parent.data;
                }
            }
        }
        return parent.data;
    }
    
    public int prev(int value) {
        Node current = head;
        Node parent = null;
        
        while (current != null) {
            if (current.data < value) {
                parent = current;
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                if (current.left != null) {
                    current = current.left;
                    while (current.right != null) {
                        current = current.right;
                    }
                    return current.data;
                } else {
                    return parent.data;
                }
            }
        }
        return parent.data;
    }
    
    public void delete(int value) {
        Node current = head;
        Node parent = null;
        
        while (current != null) {
            parent = current;
            if (current.data < value) {
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                if (current.right != null) {
                    current = current.right;
                    Node parent2 = null;
                    while (current.left != null) {
                        parent2 = current;
                        current = current.left;
                    }
                    parent.data = current.data;
                    parent2.setLeft(null);
                    // // МОЖННО помечать удаленные как 0, для использования printTree, для наглядности.
                    // parent2.setLeft(new Node(0, null, null));

                } else if (current.left != null) {
                    parent.setRight(current.left);
                } else {
                    parent.setRight(null);
                }
            }
        }
    }

    // print tree interactive || Inputable tree.length must be = 15 || tree must be ABS(balanced) when you input numbers.
    public void printTree() {
        System.out.print("\n       " + head.data + "\r\n" + //
        "    /     \\\r\n" + //
        "   " + head.left.data + "        " + head.right.data + "\r\n" + //
        "  / \\      /  \\\r\n" + //
        " " + head.left.left.data + "   " + head.left.right.data + "   " + head.right.left.data + "    " + head.right.right.data + "\r\n" + //
                "/ \\ / \\  / \\   / \\\r\n" + //"");
        "" + head.left.left.left.data + " " + head.left.left.right.data + " " + head.left.right.left.data + " " + head.left.right.right.data + " " + head.right.left.left.data + "  " + head.right.left.right.data + " " + head.right.right.left.data + "  " + head.right.right.right.data + "\n\n");
    }
}
