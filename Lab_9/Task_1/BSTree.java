package Lab_9.Task_1;

public class BSTree {
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
    
    // public int max(Node head) {
    //     Node current = head;
    //     while (true) {
    //         if (current.right != null) {
    //             current = current.right;
    //         } else {
    //             return current.data;
    //         }
    //     }
    // }

    //для дебаггинга вместо null написано new Node(0, null, null).
    public void delete(int value) {
        Node current = head;
        Node parent = null;
        
        while (current != null) {
            if (current.data < value) {
                parent = current;
                current = current.right;
            } else if (current.data > value) {
                parent = current;
                current = current.left;
            } else {
                if (current.right != null) {
                    parent = current;
                    Node parent2 = current;
                    current = current.right;
                    if (current.left != null) {
                        while(current.left != null) {
                            parent2 = current;
                            current = current.left;
                        }
                        // parent2.setLeft(null); //должно быть это везде
                        parent2.setLeft(new Node(0, null, null));
                        // МОЖННО помечать удаленные как 0, для использования printTree, для наглядности.
                        parent.data = current.data;
                    } else {
                        parent2.setRight(new Node(0, null, null));
                        parent2.data = current.data;
                    }
                } else if (current.left != null) {
                    parent.setRight(current.left);
                    return;
                } else {
                    System.out.println(parent.data);
                    if (parent.right.data == current.data) {
                        parent.setRight(new Node(0, null, null));
                    } else {
                        parent.setLeft(new Node(0, null, null));
                    }
                    return;
                }
            }
        }
    }

// public int getDiffHeight(Node node) {
//         if (node.left != null) {
//             if (node.right != null) {
//                 return node.left.height - node.right.height;
//             } else {
//                 return node.left.height;
//             }
//         } else if (node.right != null) {
//             return -node.right.height;
//         } else {
//             return 0;
//         }
//     }

public int updateHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = updateHeight(node.left);
        int rightHeight = updateHeight(node.right);
        node.height = 1 + Math.max(leftHeight, rightHeight);
        return node.height;
    }

    public int sayRank(int digit) {
        int rank = 0;
        while (digit != 0) {
            rank++;
            digit /= 10;
        }
        return rank;
    }
    
    // print tree interactive || Inputable tree.length must be = 15 || tree must be ABS(balanced) when you input numbers.
    public void printTree() {
        
        Node current = head;
        int maxEl;
        while (true) {
            if (current.right != null) {
                current = current.right;
            } else {
                maxEl = current.data;
                break;
            }
        }

        maxEl = 423; //Dimension of table
        int tableRank = sayRank(maxEl);
        System.out.println(tableRank);

        int height = updateHeight(head);

        int skips = (int)Math.pow(2, height - 1 + tableRank) - tableRank;
        
        System.out.println("\n" + height + " -Высота!  skips- " + skips + "\n");

        
        if (height > 0) {
            System.out.println(" ".repeat((skips) / 2) + head.data);
        }
        int pos = 1; // Elements in table
        int iterations = 1;
        for (int i = height; i > 1; i--) {
            skips = (skips) / 2 - 1;
            int dinamicSkips = skips / 2;
            for (int j = iterations; j > 0; j--) {
                System.out.print(" ".repeat(dinamicSkips) + "/" + " ".repeat(skips + tableRank) + "\\");
                dinamicSkips = skips;
            }
            System.out.println();
            dinamicSkips = skips / 2;
            for (int j = iterations; j > 0; j--) {
                int rank = sayRank(pos) + sayRank(pos + 1) - 2;
                System.out.print(" ".repeat(dinamicSkips) + pos++ + " ".repeat(skips + tableRank - rank) + pos++);
                dinamicSkips = skips;
            }
            System.out.println();
            iterations = iterations * 2;
        }
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

//                1
//        /               \
//        8               8
//    /       \       /       \
//    4       1       4       1
//  /   \   /   \   /   \   /   \
//  2   6   1   1   2   6   1   1
// / \ / \ / \ / \ / \ / \ / \ / \
// 0 3 5 7 9 1 1 3 1 5 0 3 5 7 9 1
