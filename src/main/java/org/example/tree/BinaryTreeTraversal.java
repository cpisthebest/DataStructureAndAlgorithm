package org.example.tree;

public class BinaryTreeTraversal {
    static class TreeNode{

        private char data;
        private TreeNode left;
        private TreeNode right;
        TreeNode(char data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static void preOrderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" , ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }
    public static void inOrderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data+" , ");
        inOrderTraversal(node.right);
    }
    public static void postOrderTraversal(TreeNode node){
        if(node==null){
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data+" , ");
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode('R');
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');

        root.left=a;
        root.right=b;

        a.left=c;
        a.right=d;

        b.left=e;
        b.right=f;

        f.left=g;

        System.out.println(root.left.left.data);
        System.out.println("Pre order traversal :-");
        preOrderTraversal(root);
        System.out.println("");
        System.out.println("In order traversal :-");
        inOrderTraversal(root);
        System.out.println("");
        System.out.println("Post order traversal :-");
        postOrderTraversal(root);
    }
}
