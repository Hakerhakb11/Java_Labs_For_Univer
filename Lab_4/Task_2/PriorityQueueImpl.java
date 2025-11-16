package Lab_4.Task_2;

import java.util.List;
import java.util.ArrayList;

public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private Integer count = 0;
    private List<Node> heap = new ArrayList<>();
    public class Node {
        private Integer data;
        private final Integer index;

        Node(Integer data, Integer index) {
            this.data = data;
            this.index = index;
        }
        private int parent(int index) {return (index - 1) / 2;}
        private int left(int index) {return index * 2 + 1;}
        private int right(int index) {return index * 2 + 2;}
    }
    
    @Override
    public void enqueue(Integer value) {
	    heap.add(new Node(value, ++count));
        // System.out.println("\nTHIS IS I: " + count);
        int k = count - 1;
        int thisData = heap.get(k).data;
        int parentData = heap.get(heap.get(k).parent(k)).data;
        // System.out.println("11111 \n\nTHISDATA: " + thisData + "\nPARENTDATA: " + parentData);


        if (parentData < thisData) {
            while(k != 0 && parentData < thisData) {
                // System.out.println("\n\nTHISDATA: " + thisData + "\nPARENTDATA: " + parentData);
                Node temp = heap.get(k);
                heap.set(k, heap.get(heap.get(k).parent(k)));
                heap.set(heap.get(k).parent(k), temp);

                k = (k - 1) / 2;
                // System.out.println("\n\nTHIS IS K !!!!!!!!!!!(" + k + ") \n\n");
                thisData = heap.get(k).data;
                parentData = heap.get(heap.get(k).parent(k)).data;
                // for (int j = 0; j < count; j++) {
                //     System.out.print(heap.get(j).data + " " + heap.get(j).index);
                //     System.out.println(" Parents: " + heap.get(heap.get(j).parent(k)).data + " Index: " + heap.get(j).index);
                // }
            }
        }
        //       15
        //     /    \
        //    13     11
        //   / \    / \
        //  4   9  8  10
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            System.out.println("*");
            return null;
        }
        System.out.println("MAX element: " + heap.get(0).index + " " + heap.get(0).data);
        // Node removed = heap.get(0);
        
        int i = 0;
        int leftIndex = heap.get(i).left(i);
        int rightIndex = heap.get(i).right(i);
        heap.set(i, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        count--;

        
        while (leftIndex < heap.size()) {
            if (rightIndex < heap.size()) {
                // System.out.println("\nTHIRD PRINT!!!!! LeftIndex: " + leftIndex + "\nRightIndex: " + rightIndex);
                if (heap.get(i).data < heap.get(leftIndex).data || heap.get(i).data < heap.get(rightIndex).data) {
                    // System.out.println("\nLeftIndex: " + leftIndex + "\nRightIndex: " + rightIndex);
                    if (heap.get(leftIndex).data > heap.get(rightIndex).data) {
                        Node temp = heap.get(i);
                        heap.set(i, heap.get(leftIndex));
                        heap.set(leftIndex, temp);
                        i = leftIndex;
                    } else {
                        Node temp = heap.get(i);
                        heap.set(i, heap.get(rightIndex));
                        heap.set(rightIndex, temp);
                        i = rightIndex;
                    }
                    leftIndex = heap.get(i).left(i);
                    rightIndex = heap.get(i).right(i);
                    // System.out.println("\nSECOND PRINTOUT! LeftIndex: " + leftIndex + "\nRightIndex: " + rightIndex);
                } else {
                    leftIndex = heap.size();
                }
            } else {
                if (heap.get(i).data < heap.get(leftIndex).data) {
                    Node temp = heap.get(i);
                    heap.set(i, heap.get(leftIndex));
                    heap.set(leftIndex, temp);
                    i = leftIndex;
                    leftIndex = heap.get(i).left(i);
                    rightIndex = heap.get(i).right(i);
                } else {
                    leftIndex = heap.size();
                }
            }
        }
        return null;
    }

    @Override
    public void increment(long operation, Integer addition) {
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).index == operation) {
                heap.get(i).data += addition;
            }
        }
    }

    // func to debug print Heap
    @Override
    public String toString() {
        for (int j = 0; j < heap.size(); j++) {
            System.out.print(heap.get(j).data + " " + heap.get(j).index);
            System.out.println(" Parents: " + heap.get(heap.get(j).parent(j)).data);
        }
        System.out.println("");

        //print heap interactive || heap.size() = must be 7
        // System.out.print("      " + heap.get(0).data + "\r\n" + //
        // "    /    \\\r\n" + //
        // "   " + heap.get(1).data + "     " + heap.get(2).data + "\r\n" + //
        // "  / \\    / \\\r\n" + //
        // " " + heap.get(3).data + "  " + heap.get(4).data + "  " + heap.get(5).data + "   " + heap.get(6).data);
        return "This function print massiv of heap;";
        
        // System.out.print("      13\r\n" + //
        //                 "    /    \\\r\n" + //
        //                 "   11     8\r\n" + //
        //                 "  / \\    / \\\r\n" + //
        //                 " 4  15  11  1");
    } 
}