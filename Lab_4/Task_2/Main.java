package Lab_4.Task_2;

public class Main {
    public static void main (String[] args) {
        System.out.println("Lab 4.2\n");

        PriorityQueue<Integer> pbeg = new PriorityQueueImpl();
        
        pbeg.enqueue(13);
        pbeg.enqueue(11);
        pbeg.enqueue(8);
        pbeg.enqueue(4);
        pbeg.enqueue(15);
        pbeg.enqueue(11);
        pbeg.enqueue(1);

        pbeg.toString();


        System.out.println("\nEND OF Lab 4.2");
    }
}
//       13
//     /    \
//    11     8
//   / \    / \
//  4  15  11  1