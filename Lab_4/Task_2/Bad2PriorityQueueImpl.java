package Lab_4.Task_2;

import java.util.List;
import java.util.ArrayList;

public class Bad2PriorityQueueImpl implements PriorityQueue<Integer> {
    private Integer i = -1;
    private List<Node> heap = new ArrayList<>();
    public class Node {
        private Integer data;
        private final Integer index;

        Node(Integer data, Integer index) {
            this.data = data;
            this.index = index;
        }
        private int parent() {return (index - 1) / 2;}
        // private int left() {return index * 2 + 1;}
        // private int right() {return index * 2 + 2;}
    }
    
    @Override
    public void enqueue(Integer value) {
	    heap.add(new Node(value, ++i));
        System.out.println("\nTHIS IS I: " + i);
        int k = i;
        int thisData = heap.get(k).data;
        int parentData = heap.get(heap.get(k).parent()).data;


        if (parentData < thisData) {
            while(k != 0 && parentData < thisData) {
                System.out.println("\n\nTHISDATA: " + thisData + "\nPARENTDATA: " + parentData);
                int temp = heap.get(heap.get(k).parent()).data;
                heap.get(heap.get(k).parent()).data = heap.get(k).data;
                heap.get(k).data = temp;
                k = (k - 1) / 2;
                System.out.println("\n\nTHIS IS K !!!!!!!!!!!(" + k + ") \n\n");
                thisData = heap.get(k).data;
                parentData = heap.get(heap.get(k).parent()).data;
                for (int j = 0; j <= i; j++) {
                    System.out.print(heap.get(j).data + " " + heap.get(j).index);
                    System.out.println(" Parents: " + heap.get(heap.get(j).parent()).data);
                }
            }
        }
        //       13
        //     /    \
        //    11     8
        //   / \    / \
        //  4  15  11  1

        // if (parentData < thisData) {
        //     System.out.println("NO EQUAL");
        // }
        System.out.print("\nOUT OUT OUT OUT OUT\n");
            
    }

    @Override
    public Integer dequeueMax() {
	
        return null;
    }

    @Override
    public void increment(long operation, Integer addition) {
	
    }

    // func to debug print Heap
    @Override
    public String toString() {
        for (int j = 0; j < i; j++) {
            System.out.print(heap.get(j).data + " " + heap.get(j).index);
            System.out.println(" Parents: " + heap.get(heap.get(j).parent()).data);
        }

        //print heap interactive
        System.out.print("      " + heap.get(0).data + "\r\n" + //
        "    /    \\\r\n" + //
        "   " + heap.get(1).data + "     " + heap.get(2).data + "\r\n" + //
        "  / \\    / \\\r\n" + //
        " " + heap.get(3).data + "  " + heap.get(4).data + "  " + heap.get(5).data + "   " + heap.get(6).data);
        
        return "This function print massiv of heap;";
        
        // System.out.print("      13\r\n" + //
        //                 "    /    \\\r\n" + //
        //                 "   11     8\r\n" + //
        //                 "  / \\    / \\\r\n" + //
        //                 " 4  15  11  1");
    } 
}