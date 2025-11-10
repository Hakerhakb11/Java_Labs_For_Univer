package Lab_4.Task_1;

public class MinStackImpl implements MinStack<Integer> {
    private Node head = null;

    private class Node {
        private final Integer data;
        private final Node back;
        private final Integer min;
        
        Node (Integer data, Node back) {
            this.data = data;
            this.back = back;
            if(this.back == null || this.data < this.back.min) {
                this.min = data;
            } else {
                this.min = this.back.min;
            }
        }
    }
    
    @Override
    public void push(Integer value) {
        head = new Node(value, head);
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        } else {
            head = head.back;
            return null;
        }
    }

    @Override
    public Integer top() {
	    if (head == null) {
            return null;
        }
        return head.data;
    }

    @Override
    public Integer min() {
	    if (head == null) {
            return null;
        }
        return head.min;
    }
} 