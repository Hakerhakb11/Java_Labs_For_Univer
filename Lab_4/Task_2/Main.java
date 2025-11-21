package Lab_4.Task_2;

public class Main {
    public static void main (String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueueImpl();

        heap.enqueue(13);
        heap.enqueue(11);
        heap.enqueue(8);
        heap.enqueue(4);
        heap.enqueue(15);
        heap.enqueue(9);
        heap.enqueue(10);
        heap.toString();

        heap.increment(2, 1000);
        heap.toString();
        // heap.increment(6, 1000);
        heap.increment(5, -4);
        heap.toString();

        // heap.dequeueMax();
        // heap.toString();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.dequeueMax();
        // heap.toString();
    }
}
