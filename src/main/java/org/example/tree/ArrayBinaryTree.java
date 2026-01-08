package org.example.tree;

public class ArrayBinaryTree {
    public static void main(String[] args){

        Character[] arrayBinaryTree = {'R','A','B','C','D','E','F',null,null,null,null,null,null,'G'};
        int rightIndex = getRightIndex(0);
        int leftOfRightIndex = getLeftIndex(rightIndex);
        System.out.println("Data at left of right of root -> "+getCharacter(arrayBinaryTree,leftOfRightIndex).toString());
    }
    public static int getRightIndex(int index){
        return 2*index+2;
    }
    public static int getLeftIndex(int index){
        return 2*index+1;
    }
    public static Character getCharacter(Character[] arr,int index){
        if(index>=0 && index<arr.length){
            return arr[index];
        }
        return null;
    }
}
