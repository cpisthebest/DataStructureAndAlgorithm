package org.example.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashSetExample {
    public static void main(String[] args){
        SimpleHashSet simpleHashSet = new SimpleHashSet(4);
        simpleHashSet.add("A");
        simpleHashSet.add("B");
        simpleHashSet.add("C");
        simpleHashSet.add("D");
        simpleHashSet.add("B");
        simpleHashSet.add("Adele");
        simpleHashSet.add("Bob");
        System.out.println("Hash set contains B ? "+simpleHashSet.contains("C"));
        System.out.println("Removed B");
        simpleHashSet.remove("B");
        System.out.println("Hast set contains B ? "+simpleHashSet.contains("B"));
        simpleHashSet.printSet();
    }
    static class SimpleHashSet{
        private final int size;
        private final List<List<String>> buckets;
        public SimpleHashSet(int size){
            this.size = size;
            this.buckets=new ArrayList<>(size);
            for(int i=0;i<size;i++){
                //using arraylist for the buckets
                buckets.add(new ArrayList<>());
            }
        }
        public void add(String data){
            int bucketIndex = hashFunction(data);
            if(!buckets.get(bucketIndex).contains(data)){
                buckets.get(bucketIndex).add(data);
            }
        }
        public void remove(String data){
            int bucketIndex = hashFunction(data);
            buckets.get(bucketIndex).remove(data);
        }
        private int hashFunction(String data){
            return data.chars().reduce(0,Integer::sum)%size;
        }
        public Boolean contains(String data){
            int bucketIndex = hashFunction(data);
            return buckets.get(bucketIndex).contains(data);
        }
        public void printSet(){
            //buckets.forEach(i-> i.forEach(System.out::println));
            for(int i =0;i<buckets.size();i++){
                System.out.println("Bucket "+i+" contains "+buckets.get(i));
            }
        }
    }
}
