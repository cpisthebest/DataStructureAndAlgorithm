package org.example.queue;

public class QueueUsingLinkedList
{

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }
    static class LinkedListQueue{
        Node head = null;
        Node tail = null;

        public boolean isEmpty(){
            return head == null && tail == null;
        }
        public void add(int data){
            Node newData = new Node(data);
            if(isEmpty()) {
                head=tail= newData;
                return;
            }
            tail.next = newData;
        }
        public Node delete(){
            if(isEmpty()){
                System.out.println("No data found in linked list queue");
                return null;
            }
            Node element = head;
            //single element condition
            if(head==tail && head!=null){
                head=tail=null;
                element.next = null;
                return element;
            }
            head=head.next;
            element.next = null;
            return head;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
            }
            return head.data;
        }
    }
    public static void main(String[] args){
        LinkedListQueue queue = new LinkedListQueue();
        queue.add(1);
        queue.add(2);
        System.out.println("first deleted value - "+queue.delete().data);
        queue.add(3);
        queue.add(4);
        System.out.println("Peeked value - "+queue.peek());
        while(!queue.isEmpty()){
            System.out.println("Removing all data -> "+queue.delete().data);
        }
    }
}
