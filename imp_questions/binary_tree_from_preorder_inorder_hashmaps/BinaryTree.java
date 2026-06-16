package imp_questions.binary_tree_from_preorder_inorder_hashmaps;

import java.util.*;
import javax.print.attribute.standard.PresentationDirection;

public class BinaryTree{
    TreeNode root;

    public BinaryTree(){

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

    public void constructBinaryTree(int[] preorder, int[] inorder){
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            indexMap.put(inorder[i], i);
        }

        root= construct(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, indexMap);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> indexMap){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int inorderIndex = indexMap.get(node.val);

        int leftSize = inorderIndex - inStart;

        node.left = construct(
                preorder,
                inorder,
                preStart + 1,
                preStart + leftSize,
                inStart,
                inorderIndex - 1,
                indexMap);

        node.right = construct(
                preorder,
                inorder,
                preStart + leftSize + 1,
                preEnd,
                inorderIndex + 1,
                inEnd,
                indexMap);

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