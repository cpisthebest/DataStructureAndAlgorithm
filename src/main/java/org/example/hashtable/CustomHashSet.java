package org.example.hashtable;

import java.util.Arrays;
import java.util.LinkedList;

public class CustomHashSet {
    static LinkedList<String>[] myHastSet = new LinkedList[10];
    public static void main(String[] args){

        for(int i=0; i<myHastSet.length ; i++){
            myHastSet[i]=new LinkedList<>();
        }
        add("Bob");
        add("Ziana");
        add("Dear");
        add("Bob");
        add("Data");
        add("Stuart");
        add("Lisa");
        Arrays.stream(myHastSet).forEach(System.out::println);
        System.out.println("Does myHastSet contain 'Data' value? "+contains("Data"));
    }
    static private void add(String data){
        int index = hashFunction(data);
        LinkedList<String> indexBucket = myHastSet[index];
        if(!indexBucket.contains(data)){
            indexBucket.add(data);
        }
    }
    static private int hashFunction(String data){
        int sum = 0;
        for(int i : data.toCharArray()){
            sum += i;
        }
        return sum%10;
    }
    static private Boolean contains(String data){
        int index = hashFunction(data);
        return myHastSet[index].contains(data);
    }

}
