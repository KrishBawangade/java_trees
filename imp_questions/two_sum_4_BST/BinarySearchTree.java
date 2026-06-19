package imp_questions.two_sum_4_BST;

import java.util.*;

public class BinarySearchTree{
    TreeNode root;
    
    public int height(TreeNode node){

        if(node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root TreeNode: ");
    }

    private void display(TreeNode node, String details){
        if(node == null){
            return;
        }

        System.out.println(details+node.val);
        display(node.left, "Left Child of "+node.val+": ");
        display(node.right, "Right Child of "+node.val+": ");
    }

    public void insert(int val){
        root = insert(val, root);
    }

    private TreeNode insert(int val, TreeNode node){
        if(node == null){
            node = new TreeNode(val);
            return node;
        }

        if(val>node.val){
            node.right = insert(val, node.right);
        }else{
            node.left = insert(val, node.left);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    public boolean findTarget(int k) {
        Set<Integer> visited = new HashSet<>();

        return find(root, k, visited);
    }

    private boolean find(TreeNode node, int k, Set<Integer> visited){
        if(node == null){
            return false;
        }

        if(visited.contains(k-node.val)){
            return true;
        }

        if(!visited.contains(node.val)){
            visited.add(node.val);
        }

        boolean left = find(node.left, k, visited);

        if(!left){
            return find(node.right, k, visited);
        }

        return left;
    }

    private class TreeNode{
        private int val;
        private int height;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, int height){
            this.val = val;
            this.height = height;
        }

        public int getValue(){
            return val;
        }

    }
}