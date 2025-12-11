package org.example.queue;

// https://www.youtube.com/watch?v=va_6RmSrKCg
public class ArrayQueue {

    static class Queue{
        int[] data;
        int size;
        int rear=-1;

        Queue(int capacity){
            this.size = capacity;
            this.data = new int[capacity];
        }
        public boolean isFull(){
            return rear==size-1;
        }
        public boolean isEmpty(){
            return rear==-1;
        }
        public void enqueue(int value){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            data[rear]=value;
        }
        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front=data[0];
            for(int i=0;i<rear;i++){
                data[i]=data[i+1];
            }
            rear--;
            return front;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is full");
                return -1;
            }
            return data[0];
        }
    }
    public static void main(String[] args){
        Queue queue = new Queue(6);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println("First element of queue is "+queue.peek());
        System.out.println("Removed element from queue -> "+queue.dequeue());
        System.out.println("First element of queue is "+queue.peek());
    }
}
