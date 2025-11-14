package Lab_4.Task_2;

import java.util.List;
import java.util.ArrayList;

public class PriorityQueueImpl implements PriorityQueue<Integer> {
    private Integer i = 0;
    private List<Node> heap = new ArrayList<>();
    public class Node {
        private final Integer data;
        private final Integer index;

        Node(Integer data, Integer index) {
            this.data = data;
            this.index = index;


        }
        private int parent() {return (index - 1) / 2;}
        private int left() {return index * 2 + 1;}
        private int right() {return index * 2 + 2;}
    }
    
    @Override
    public void enqueue(Integer value) {
	    heap.add(new Node(value, i++));
        System.out.println("\nTHIS IS I: " + i);
            System.out.println("CHECK");
            int thisData = heap.get(i - 1).data;
            int parentData = heap.get(heap.get(i - 1).parent()).data;
            if (parentData < thisData) {
                System.out.println("NO EQUAL");
                
            }
    }

    @Override
    public Integer dequeueMax() {
	// TODO
        return null;
    }

    @Override
    public void increment(long operation, Integer addition) {
	// TODO
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
        " " + heap.get(3).data + "  " + heap.get(4).data + "  " + heap.get(5).data + "  " + heap.get(6).data);
        
        return "This function print massiv of heap;";
        //       13
        //     /    \
        //    11     8
        //   / \    / \
        //  4  15  11  1
        
        // System.out.print("      13\r\n" + //
        //                 "    /    \\\r\n" + //
        //                 "   11     8\r\n" + //
        //                 "  / \\    / \\\r\n" + //
        //                 " 4  15  11  1");
    } 
}