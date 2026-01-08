package org.example.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTreePreOrder {
        static int index = -1;

        static TreeNode buildTree(int[] arr) {
            index++;
            if (arr[index] == -1) {
                return null;
            }
            TreeNode treeNode = new TreeNode(arr[index]);
            treeNode.left = buildTree(arr);
            treeNode.right = buildTree(arr);
            return treeNode;
        }

        static void preOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            System.out.print(node.data+" ");
            preOrder(node.left);
            preOrder(node.right);
        }

        static void postOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+" ");
        }

        static void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
        static void levelOrder(TreeNode root){
            if(Objects.isNull(root)){
                return;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while(!queue.isEmpty()){
                TreeNode currentNode = queue.remove();
                if(currentNode==null){
                    System.out.println();
                    if(queue.isEmpty()){
                        break;
                    }
                    else {
                        queue.add(null);
                    }
                }
                else {
                    System.out.print(currentNode.data+" ");

                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
            }

        }

        static int numberOfNodes(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftNodes = numberOfNodes(root.left);
            int rightNodes = numberOfNodes(root.right);
            return leftNodes+rightNodes+1;
        }
        static int sumOfNodes(TreeNode root){
            if(root==null){
                return 0;
            }
            int sumOfLeftNodes = sumOfNodes(root.left);
            int sumOfRightNodes = sumOfNodes(root.right);
            return sumOfLeftNodes+sumOfRightNodes+root.data;
        }
        static int heightOfTree(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
        //calculating diameter - time complexity -> O(n^2)
        static int diameterOfTree(TreeNode root){
            if(root==null){
                return 0;
            }
            int leftDiameter = diameterOfTree(root.left);
            int rightDiameter = diameterOfTree(root.right);
            int rootDiameter = heightOfTree(root.left)+heightOfTree(root.right)+1;
            return Math.max(rootDiameter,Math.max(leftDiameter,rightDiameter));
        }
        public static void main(String[] args) {
            int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            TreeNode root = buildTree(arr);
            System.out.println("Root of pre order tree is " + root);
            System.out.println("Pre order -> ");
            preOrder(root);
            System.out.println();
            System.out.println("Post order -> ");
            postOrder(root);
            System.out.println();
            System.out.println("In order -> ");
            inOrder(root);
            System.out.println();
            levelOrder(root);
            System.out.println("Number of nodes -> "+numberOfNodes(root));
            System.out.println("Sum of nodes -> "+sumOfNodes(root));
            System.out.println("Height of tree -> "+heightOfTree(root));
            //Diameter of tree - number of nodes is the longest path between two nodes - time complexity - O(n^2)
            System.out.println("Diameter of the tree -> "+diameterOfTree(root));
            //Diameter of tree - time complexity - O(n)
            System.out.println("Diameter of tree using O(n) -> "+diameterOfTreeUsingOn(root).diameter);

        }

        private static TreeInfo diameterOfTreeUsingOn(TreeNode root) {
            if(root==null){
                return new TreeInfo(0,0);
            }
            TreeInfo leftInfo = diameterOfTreeUsingOn(root.left);
            TreeInfo rightInfo = diameterOfTreeUsingOn(root.right);

            int height = Math.max(leftInfo.height,rightInfo.height)+1;
            int leftDiameter = leftInfo.diameter;
            int rightDiameter = rightInfo.diameter;
            int heightDiameter = leftInfo.height+rightInfo.height+1;
            int diameter = Math.max(heightDiameter,Math.max(leftDiameter,rightDiameter));

            return new TreeInfo(height,diameter);
        }
        private static class TreeInfo{
            private int height;
            private int diameter;
            TreeInfo(int height,int diameter){
                this.diameter=diameter;
                this.height=height;
            }
        }
    }
}
