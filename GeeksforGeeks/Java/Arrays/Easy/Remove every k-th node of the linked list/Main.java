/*
Given a singly linked list, the task is to remove every kth node of the linked list. Assume that k is always less than or equal to the length of the Linked List.

Examples : 

Input: LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6, k = 2
Output: 1 -> 3 -> 5 
Explanation: After removing every 2nd node of the linked list, the resultant linked list will be: 1 -> 3 -> 5 .

Input: LinkedList: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10, k = 3
Output: 1 -> 2 -> 4 -> 5 -> 7 -> 8 -> 10
Explanation: After removing every 3rd node of the linked list, the resultant linked list will be: 1 -> 2 -> 4 -> 5 -> 7 -> 8 -> 10.
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
    public static void printList(Node head){
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data);
            if(temp.next!=null){
                System.out.print("->");
            }
            temp = temp.next;
        }
    }
    
    static Node deletePost(Node head, int k) {
        Node cur = head;
        Node prev = null;
        int count = 1;
        if (head == null || k <= 0)
            return head;
        while(cur!=null) {
            if(count == k){
                count = 0;
                if (prev!=null) {
                    prev.next = cur.next;   
                }else {
                    head = cur.next;
                }
            }else {
                prev = cur;
            }
            cur = cur.next;
            count++;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        
        int k =3;
        
        head = deletePost(head, k);
        printList(head);
    }
}