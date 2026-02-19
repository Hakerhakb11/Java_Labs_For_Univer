package Lab_9.Task_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

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

    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public void insert(int value) {
        if (head == null) {
            head = new Node(value, null, null);    
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node current = head;
        Node parent = null;
        while (current != null) {
            stack.push(current);
            parent = current;
            if (current.data < value) { 
                current = current.right;
            } else if (current.data > value) {
                current = current.left;
            } else {
                return;
            }
        }
        if (parent.data < value) {
            parent.setRight(new Node(value, null, null)); 
        } else {
            parent.setLeft(new Node(value, null, null));
        }
        balanceWithStack(stack);
        return;
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
        if (head.height < 2) {
            return 0;
        }
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
        if (head.height < 2) {
            return 0;
        }
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
    
    public void balanceWithStack(Deque<Node> stack) {
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.height = 1 + Math.max(height(node.left), height(node.right));
            Node balanced = balance(node);

            if (!stack.isEmpty()) {
                Node grandParent = stack.peek();
                if (grandParent.left == node) {
                    grandParent.left = balanced;
                } else {
                    grandParent.right = balanced;
                }
            } else {
                head = balanced;
            }
        }
    }

    public void delete(int value) {
        System.out.println("Deleting: " + value);
        Deque<Node> stack = new ArrayDeque<>();
        Node current = head;
        Node parent = null;
        
        while (current != null) {
            if (current.data < value) {
                stack.push(current);
                parent = current;
                current = current.right;
            } else if (current.data > value) {
                stack.push(current);
                parent = current;
                current = current.left;
            } else {
                if (current.right != null) {
                    stack.push(current);
                    parent = current;
                    Node parent2 = current;
                    current = current.right;
                    if (current.left != null) {
                        while(current.left != null) {
                            stack.push(current);
                            parent2 = current;
                            current = current.left;
                        }
                        parent2.setLeft(null);
                        parent.data = current.data;
                    } else {
                        parent2.setRight(null);
                        parent2.data = current.data;
                    }
                } else if (current.left != null) {
                    if (head.data == value) {
                        head = head.left;
                        return;
                    }
                    if (parent.left == current) {
                        parent.setLeft(current.left);
                    } else {
                        parent.setRight(current.left);
                    }
                    balanceWithStack(stack);
                    return;
                } else {
                    if (head.data == value) {
                        head = null;
                        return;
                    }
                    if (parent.right == current) {
                        parent.setRight(null);
                    } else {
                        parent.setLeft(null);
                    }
                    balanceWithStack(stack);
                    return;
                }
            }
        }
    }
   
    public int max(Node head) {
        Node current = head;
        while (true) {
            if (current.right != null) {
                current = current.right;
            } else {
                return current.data;
            }
        }
    }

    public int sayRank(int digit) {
        int rank = 0;
        while (digit != 0) {
            rank++;
            digit /= 10;
        }
        if (rank == 0) {
            return 1;
        }
        return rank;
    }

    public int[] BFS(Node head) {
        Node temp = new Node(0, null, null); // for don't exists Nodes
        int height = updateHeight(head); // qtyty of floors in the tree
        int size = (int)Math.pow(2, height); // max qtyty elem in tree
        int number = size;
        int[] arr = new int[(int)Math.pow(2, height)];
        Queue<Node> queue = new LinkedList<>();
        
        int i = 0;
        if (head != null) {
            queue.offer(head);
        }
        for (int k = 1; k < size; k++) {
            Node current = queue.poll();
            arr[i++] = current.data;
            if (current.left != null) {
                queue.offer(current.left);
            } else {
                if (number > size / 2 + 1) {
                    queue.offer(temp);
                }
            }
            if (current.right != null) {
                queue.offer(current.right);
            } else {
                if (number > size / 2 + 1) {
                    queue.offer(temp);
                }
            }
            number--;
        }
        return arr;
    }

    // print tree interactive
    public void printTree() {
        int height = updateHeight(head);
        if (height <= 0) {
            System.out.println("Дерево пусто..");
            return;
        }
        int maxEl = max(head);
        int tableRank = sayRank(maxEl); // Table Width ex: for x, for xx, for xxx.
        int skips = (int)Math.pow(2, height - 1 + tableRank) - tableRank;
        
        // first elem. Print alone
        System.out.println("--------------------------------\n" + " ".repeat((skips) / 2) + head.data);
        
        int[] arr = BFS(head); // Elements in table
        int numInTable = 1; // variable of number, which been getted from BFS
        int iterations = 1; // variable of Qtyty iteration in every floor
        
        for (int i = height; i > 1; i--) {
            skips = (skips) / 2;
            int dinamicSkips = skips / 2;
            for (int j = iterations; j > 0; j--) {
                System.out.print(" ".repeat(dinamicSkips) + "/" + " ".repeat(skips) + "\\");
                dinamicSkips = skips;
            }
            System.out.println();
            dinamicSkips = skips / 2;
            for (int j = iterations; j > 0; j--) {
                int rank = sayRank(arr[numInTable]) + sayRank(arr[numInTable + 1]) - 2;
                System.out.print(" ".repeat(dinamicSkips) + arr[numInTable++] + " ".repeat(skips - rank) + arr[numInTable++]);
                dinamicSkips = skips;
            }
            System.out.println();
            iterations = iterations * 2;
        }
    }
}
// second variant of delete()
// public void delete(int value) {
//     head = deleteRec(head, value);
// }
// private Node deleteRec(Node node, int value) {
//     if (node == null) return null;
//     if (value < node.data) {
//         node.left = deleteRec(node.left, value);
//     } else if (value > node.data) {
//         node.right = deleteRec(node.right, value);
//     } else {
//         // узел найден
//         if (node.left == null) return node.right;
//         if (node.right == null) return node.left;
//         // два потомка
//         Node minNode = findMin(node.right);
//         node.data = minNode.data;
//         node.right = deleteRec(node.right, minNode.data);
//     }
//     // обновляем высоту и балансируем
//     node.height = 1 + Math.max(height(node.left), height(node.right));
//     return balance(node);
// }
// private Node findMin(Node node) {
//     while (node.left != null) node = node.left;
//     return node;
// }

// OLD VERSION
// //Check node. If this null, func doesn't printed .this
// private String P(Node node, String path) {
//     if (node == null) {
//         return "null";
//     }
//     String[] steps = path.split("\\.");
//     Node current = node;
//     for (String step : steps) {
//             if (current == null) {
//                 return "null";
//             }
//             if (step.equals("left")) {
//                 current = current.left;
//             } else if (step.equals("right")) {
//                 current = current.right;
//             }
//         }
//         if (current == null) {
//             return "null";
//         }
//         return current.data + "," + current.height;
//     }
    
//     // print tree interactive || Inputable tree.length must be = 15 || tree must be ABS(balanced) when you input numbers.
//     public void printTree() {
//         System.out.print("\n                 " + P(head, "") + "\r\n" + //
//         "            /          \\ \r\n" + //
//         "         " + P(head, "left") + "            " + P(head, "right") + "\r\n" + //
//         "        /   \\           /   \\    \r\n" + //
//         "      " + P(head, "left.left") + "  " + P(head, "left.right") + "       " + P(head, "right.left") + "    " + P(head, "right.right") + "\r\n" + //
//         "     / \\    / \\      / \\       / \\\r\n" + //"");
//         "   " + P(head, "left.left.left") + " " + P(head, "left.left.right") + " " + P(head, "left.right.left") + " " + P(head, "left.right.right") + " " + P(head, "right.left.left") + " " + P(head, "right.left.right") + " " + P(head, "right.right.left") + " " + P(head, "right.right.right") + "\n\n");
//     }
