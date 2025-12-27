package org.example.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashMapExample {
    static class SimpleHashMap{

        private final List<List<Pair>> buckets;
        SimpleHashMap(int size){
            this.buckets=new ArrayList<>(size);
            for(int i=0;i<size;i++){
                buckets.add(new ArrayList<Pair>());
            }
        }

        public void put(String key , String value){
            int bucketIndex = hashFunction(key);
            for(Pair p:buckets.get(bucketIndex)){
                if(p.key.equals(key)){
                    p.value=value; //if key is present, replace its value
                    return;
                }
            }
            buckets.get(bucketIndex).add(new Pair(key,value)); //if key not present, add it
        }
        public Boolean remove(String key){
            int bucketIndex = hashFunction(key);
            List<Pair> bucket = buckets.get(bucketIndex);
            return bucket.removeIf(p->p.key.equals(key));
        }
        public Pair get(String key){
            int bucketIndex = hashFunction(key);
            for(Pair p:buckets.get(bucketIndex)) {
                if (p.key.equals(key)) {
                    return p;
                }
            }
            return null; //if key not found
        }
        private void printMap(){
            for(int i=0;i<buckets.size();i++){
                System.out.print("Bucket "+i+" -> ");
                buckets.get(i).forEach(p->System.out.println(p.key+" "+p.value));
            }
        }
        private int hashFunction(String key){
            return key.chars().filter(Character::isDigit)
                    .map(Character::getNumericValue).sum()%buckets.size();
        }
    }
    static class Pair{
        private String key;
        private String value;
        public Pair(String key, String value){
            this.key=key;
            this.value=value;
        }
    }
    public static void main(String[] args){
        SimpleHashMap simpleHashMap = new SimpleHashMap(4);
        simpleHashMap.put("123-4567","2");
        simpleHashMap.put("123-4568","4");
        simpleHashMap.put("123-4569","6");
        simpleHashMap.put("123-4570","8");
        simpleHashMap.put("123-4568","14");
        simpleHashMap.printMap();
        System.out.println("");
        System.out.println("Fetching key 1234 -> "+simpleHashMap.get("1234"));
        System.out.println("Removing 123-4569");
        System.out.println(simpleHashMap.remove("123-4569"));
        simpleHashMap.printMap();
    }
}
