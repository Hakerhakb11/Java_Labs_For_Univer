package Lab_4.Task_2;

public class Main {
    public static void main (String[] args) {
        System.out.println("Lab 4.2\n");

        PriorityQueue<Integer> heap = new PriorityQueueImpl();
        
        // heap.enqueue(15);
        // heap.enqueue(13);
        // heap.enqueue(11);
        // heap.enqueue(4);
        // heap.enqueue(9);
        // heap.enqueue(8);
        // heap.enqueue(10);

        // heap.enqueue(152);
        // heap.enqueue(64);
        // heap.enqueue(6);
        // heap.enqueue(13);
        // heap.enqueue(12);
        // heap.enqueue(6);
        // heap.enqueue(10);

        heap.enqueue(13);
        heap.enqueue(11);
        heap.enqueue(8);
        heap.enqueue(4);
        heap.enqueue(15);
        heap.enqueue(9);
        heap.enqueue(10);

        heap.increment(2, 1000);

        heap.toString();


        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.toString();
        // heap.enqueue(9);
        // heap.enqueue(10);
        // heap.dequeueMax();
        // heap.increment(2, 1000);
        // heap.dequeueMax();
        // heap.dequeueMax();

        System.out.println("\nEND OF Lab 4.2");
    }
}
//       13
//     /    \
//    11     8
//   / \    / \
//  4  15  11  1