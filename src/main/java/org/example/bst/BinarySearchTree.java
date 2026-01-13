package org.example.bst;

public class BinarySearchTree {
    static class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
        TreeNode(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
    static void inOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(13);
        TreeNode node7=new TreeNode(7);
        TreeNode node15=new TreeNode(15);
        TreeNode node3=new TreeNode(3);
        TreeNode node8=new TreeNode(8);
        TreeNode node14=new TreeNode(14);
        TreeNode node19=new TreeNode(19);
        TreeNode node18=new TreeNode(18);

        root.left=node7;
        root.right=node15;

        node7.left=node3;
        node7.right=node8;

        node15.left=node14;
        node15.right=node19;

        node19.left=node18;
        inOrderTraversal(root);
        //time complexity is O(h) - h - height of the tree
        TreeNode result18 = searchInBST(root,18);
        if(result18!=null) {
            System.out.println("Searching in BST. Found 18 ? true");
        }
        else{
            System.out.println("Did not find 18");
        }
        TreeNode result180 = searchInBST(root,180);
        if(result180!=null) {
            System.out.println("Searching in BST. Found 180 ? true");
        }
        else{
            System.out.println("Did not find 180");
        }

        //insert in BST
        System.out.println("Inserted 45 for root -> " + insertNode(root,45).value);
        inOrderTraversal(root);

        System.out.println("Lowest value -> "+lowestValue(root).value);
    }

    private static TreeNode lowestValue(TreeNode root) {
        TreeNode current = root;
        while(current!=null && current.left!=null){
            current=current.left;
        }
        return current;
    }

    //BST has unique values. Insertion is done at the end of tree
    private static TreeNode insertNode(TreeNode root, int data){
        if(root == null){
            return new TreeNode(data);
        }
        else{
            if(root.value>data){
                root.left = insertNode(root.left,data);
            }
            else if(data>root.value){
                root.right = insertNode(root.right,data);
            }
        }
        return root;
    }
    private static TreeNode searchInBST(TreeNode root,int searchData) {

        if(root==null){
            return null;
        }
        else if(root.value==searchData){
            return root;
        }
        else if(root.value>searchData){
            return searchInBST(root.left,searchData);
        }
        else{
            return searchInBST(root.right,searchData);
        }
    }
}
