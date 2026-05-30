package imp_questions.binary_tree_serialize_deserialize;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    TreeNode root;

    public BinaryTree(){

    }

    public void populate(Scanner sc){
        System.out.print("Enter the root node: ");
        int value = sc.nextInt();
        root = new TreeNode(value);

        populate(sc, root);
    }

    private void populate(Scanner sc, TreeNode node){
        System.out.printf("Do you want to enter left of %d: ", node.val);
        boolean isLeft = sc.nextBoolean();

        if(isLeft){
            System.out.print("Enter the value of the left node: ");
            int value = sc.nextInt();
            TreeNode left = new TreeNode(value);
            node.left = left;
            populate(sc, left);
        }

        System.out.printf("Do you want to enter right of %d: ", node.val);
        boolean isRight = sc.nextBoolean();

        if(isRight){
            System.out.print("Enter the value of the right node: ");
            int value = sc.nextInt();
            TreeNode right = new TreeNode(value);
            node.right = right;
            populate(sc, right);
        }

    }


    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(TreeNode node, int level){
        if(node == null){
            return;
        }

        prettyDisplay(node.right, level+1);

        if(level != 0){
            for(int i=0; i<level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+ node.val);
        }else{
            System.out.println(node.val);
        }

        prettyDisplay(node.left, level+1);

    }

    // Encodes a tree to a single string.
    public String serialize() {
        StringBuilder sb = new StringBuilder("[");
        preorder(root, sb);

        if(root != null){
            sb.deleteCharAt(sb.length()-1);
        }

        sb.append("]");

        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("n,");
            return;
        }

        sb.append(node.val+",");

        preorder(node.left, sb); 
        preorder(node.right, sb); 
    }

    // Decodes your encoded data to tree.
    public void deserialize(String data) {
        List<Integer> preorder = new ArrayList<>();

        String content = data.substring(1, data.length() -1);
        
        String[] tokens = content.split(",");

        for(String str: tokens){
            if(str.equals("n")){
                preorder.add(null);
            }else{
                preorder.add(Integer.parseInt(str));
            }
        }

        root = buildTree(preorder);
    }
    int k = 0;
    private TreeNode buildTree(List<Integer> preorder){
        if(preorder.get(k) == null){
            k++;
            return null;
        }

        TreeNode node = new TreeNode(preorder.get(k));
        k++;
        node.left = buildTree(preorder);
        node.right = buildTree(preorder);

        return node;
    }


    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.val = value;
        }
    }
}
