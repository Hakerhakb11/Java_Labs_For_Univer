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
        switchUp(count - 1);
    }
    
    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty()) {
            System.out.println('*');
            return null;
        }
        System.out.println("MAX element: " + heap.get(0).index + " " + heap.get(0).data);
        Node removed = heap.get(0);
        int i = 0;
        heap.set(i, heap.get(heap.size() - 1));
        count--;
        heap.remove(heap.size() - 1);
        if (heap.isEmpty()) {
            return removed.data;
        }
        switchDown(i);
        return removed.data;
    }
    
    @Override
    public void increment(long operation, Integer addition) {
        int j = 0;
        for (int i = 0; i < heap.size(); i++) {
            if (heap.get(i).index == operation) {
                heap.get(i).data += addition;
                j = i;
            }
        }
        switchUp(j);
    }
    
    public void switchUp(int count) {
        int k = count;
        int thisData = heap.get(k).data;
        int parentData = heap.get(heap.get(k).parent(k)).data;
        if (parentData < thisData) {
            while(k != 0 && parentData < thisData) {
                Node temp = heap.get(k);
                heap.set(k, heap.get(heap.get(k).parent(k)));
                heap.set(heap.get(k).parent(k), temp);
                k = (k - 1) / 2;
                thisData = heap.get(k).data;
                parentData = heap.get(heap.get(k).parent(k)).data;
            }
        }
    }
    public void switchDown(int i) {
        int leftIndex = heap.get(i).left(i);
        int rightIndex = heap.get(i).right(i);
        while (leftIndex < heap.size()) {
            if (rightIndex < heap.size()) {
                if (heap.get(i).data < heap.get(leftIndex).data || heap.get(i).data < heap.get(rightIndex).data) {
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
    }
    
    // func to debug print Heap
    @Override
    public String toString() {
        // System.out.println("");
        // for (int j = 0; j < heap.size(); j++) {
        //     System.out.print(heap.get(j).data + " id:" + heap.get(j).index);
        //     System.out.println(" Parents: " + heap.get(heap.get(j).parent(j)).data);
        // }
        // System.out.println("");

        // print heap interactive || heap.size() = must be 7
        System.out.print("      " + heap.get(0).data + "\r\n" + //
        "    /    \\\r\n" + //
        "   " + heap.get(1).data + "     " + heap.get(2).data + "\r\n" + //
        "  / \\    / \\\r\n" + //"");
        " " + heap.get(3).data + "  " + heap.get(4).data + "  " + heap.get(5).data + "   " + heap.get(6).data + "\n\n");
        return "This function print massiv of heap;";
    } 
}
