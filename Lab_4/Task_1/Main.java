package Lab_4.Task_1;

public class Main {
    public static void main (String[] args) {
        System.out.println("Lab 4.1\n");

        MinStack<Integer> stack = new MinStackImpl();

        stack.push(74);
        System.out.println(stack.min());
        stack.push(42);
        System.out.println(stack.min());
        stack.push(1243);
        System.out.println(stack.min());
        stack.push(9);
        System.out.println(stack.min());
        stack.push(1211);
        System.out.println(stack.min());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.min());
        System.out.println(stack.top());
        System.out.println("\nEND OF Lab 4.1");
    }
}
