package Lab_9.Task_1;

import java.util.Queue;
import java.util.LinkedList; 

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
        if (parent.data < value) {
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

    public void delete(int value) { 
        System.out.println("Deliting: " + value);
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
                    return;
                }
            }
        }
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
