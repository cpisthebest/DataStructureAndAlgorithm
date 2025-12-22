package org.example.queue;

public class ArrayDeque {
    static class Deque{
        static int arr[];
        static int size;
        static int rear=-1;
        static int front=-1;
        Deque(int size){
            this.size=size;
            this.arr = new int[size];
        }
        public static boolean isEmpty(){
            return front==-1 && rear==-1;
        }

        static boolean isFull(){
            return (rear+1)%size==front;
        }
        public void enqueue(int value){
            if(isFull()){
                System.out.println("Queue is full. So cannot add "+value);
                return;
            }
            //1st element add
            if(front==-1){
                front++;
            }
            rear = (rear+1)%size;
            arr[rear]=value;
        }
        //dequeue - O(1)
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty. So cannot dequeue");
                return -1;
            }
            int frontValue = arr[front];
            //single element condition
            if(front==rear){
                front=rear=-1;
            }
            else {
                front = (front + 1) % size;
            }
            return frontValue;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty. So cannot peek");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args){
        Deque deque = new Deque(6);
        deque.enqueue(1);
        deque.enqueue(2);
        deque.enqueue(3);
        deque.enqueue(4);
        deque.enqueue(5);
        deque.enqueue(6);
        deque.enqueue(7);
        System.out.println("Element dequeued is -> "+deque.dequeue());
        deque.enqueue(8);
        while (!deque.isEmpty()){
            System.out.println("Element peeked is -> "+deque.peek());
            System.out.println("Element removed is -> "+deque.dequeue());
        }
    }
}
