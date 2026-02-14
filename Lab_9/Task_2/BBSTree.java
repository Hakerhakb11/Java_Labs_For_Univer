package Lab_9.Task_2;

public class BBSTree {
    private Node head = null;
    class Node {
        private int height = 1;
        private int data;
        private Node left;
        private Node right;
        
        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 1;
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

    public Node insert(int value) {
        if (head == null) {
            head = new Node(value, null, null);    
            return head;
        }
        Node current = head;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (current.data < value) { 
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                return current;
            }
        }
        if (parent.data < value) {
            parent.setRight(new Node(value, null, null)); 
        } else {
            parent.setLeft(new Node(value, null, null));
        }
        updateHeight(head);
        // balance(head);   все конецццццццццц
        int diffHeight = getDiffHeight(head);
        System.out.println("DIFFE HEINT: " + diffHeight);
        return balance(head);
    }
    
    public Node balance(Node node) {
        int diffHeight = getDiffHeight(node);

        if (diffHeight > 1) {
            if (getDiffHeight(node.left) >= 0) {
                return rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                return rotateRight(node);
            }
        }
        if (diffHeight < -1) {
            if (getDiffHeight(node.right) <= 0) {
                return rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                return rotateLeft(node);
            }
        }
        return node;
    }

    public int updateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = updateHeight(node.left);
        int rightHeight = updateHeight(node.right);
        node.height = 1 + Math.max(leftHeight, rightHeight);
        return node.height;
    }
    
    public int getDiffHeight(Node node) {
        if (node.left != null) {
            if (node.right != null) {
                return node.left.height - node.right.height;
            } else {
                return node.left.height;
            }
        } else if (node.right != null) {
            return -node.right.height;
        } else {
            return 0;
        }
    }

    public Node rotateRight(Node node) {
        Node nodeLeft = node.left;
        Node nodeLeftRight = nodeLeft.right;

        nodeLeft.right = node;
        node.left = nodeLeftRight;

        updateHeight(node);
        updateHeight(nodeLeft);

        return nodeLeft;
    }

    public Node rotateLeft(Node node) {
        Node nodeRight = node.right;
        Node nodeRightLeft = nodeRight.left;

        nodeRight.left = node;
        node.right = nodeRightLeft;

        updateHeight(node);
        updateHeight(nodeRight);

        return nodeRight;
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

                } else if (current.left != null) {
                    parent.setRight(current.left);
                } else {
                    parent.setRight(null);
                }
            }
        }
    }

    
    //Check node. If this null, func doesn't printed .this
    private String P(Node node, String path) {
        if (node == null) {
            return "null";
        }
        String[] steps = path.split("\\.");
        Node current = node;
        for (String step : steps) {
                if (current == null) {
                    return "null";
                }
                if (step.equals("left")) {
                    current = current.left;
                } else if (step.equals("right")) {
                    current = current.right;
                }
            }
            if (current == null) {
                return "null";
            }
            return current.data + "," + current.height;
        }
        
        // print tree interactive || Inputable tree.length must be = 15 || tree must be ABS(balanced) when you input numbers.
        public void printTree() {
            System.out.print("\n                 " + P(head, "") + "\r\n" + //
            "            /          \\ \r\n" + //
            "         " + P(head, "left") + "            " + P(head, "right") + "\r\n" + //
            "        /   \\           /   \\    \r\n" + //
            "      " + P(head, "left.left") + "  " + P(head, "left.right") + "       " + P(head, "right.left") + "    " + P(head, "right.right") + "\r\n" + //
            "     / \\    / \\      / \\       / \\\r\n" + //"");
            "   " + P(head, "left.left.left") + " " + P(head, "left.left.right") + " " + P(head, "left.right.left") + " " + P(head, "left.right.right") + " " + P(head, "right.left.left") + " " + P(head, "right.left.right") + " " + P(head, "right.right.left") + " " + P(head, "right.right.right") + "\n\n");
        }
    }
    
    // // print tree interactive || Inputable tree.length must be = 15 || tree must be ABS(balanced) when you input numbers.
    //     public void printTree() {
        //         System.out.print("\n                 " + P(head) + "\r\n" + //
        //         "            /          \\ \r\n" + //
        //         "         " + P(head.left) + "            " + P(head.right) + "\r\n" + //
        //         "        /   \\           /   \\    \r\n" + //
        //         "      " + P(head.left.left) + "  " + P(head.left.right) + "       " + P(head.right.left) + "    " + P(head.right.right) + "\r\n" + //
        //                      "     / \\    / \\      / \\       / \\\r\n" + //"");
        //         "   " + P(head.left.left.left) + " " + P(head.left.left.right) + " " + P(head.left.right.left) + " " + P(head.left.right.right) + " " + P(head.right.left.left) + " " + P(head.right.left.right) + " " + P(head.right.right.left) + " " + P(head.right.right.right) + "\n\n");
        //     }

        // public String oldP(Node node) {
        //     if (node == null) {
        //         return "n/n";
        //     } else {
        //         return node.data + "," + node.height;
        //     }
        // }