/*
Given the head of singly linked list, find middle node of the linked list.

If the number of nodes is odd, return the middle node.
If the number of nodes is even, there are two middle nodes, so return the second middle node.
*/

class Node {
    int data;
    Node next;
    
    Node (int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    
    static int getMiddleElement(Node head) {
        Node fast_ptr = head;
        Node slow_ptr = head;
        
        while (fast_ptr!=null && fast_ptr.next!=null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        
        return slow_ptr.data;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        
        System.out.println(getMiddleElement(head));
    }
}