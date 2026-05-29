package imp_questions.binary_tree_from_preorder_inorder;

import java.util.*;

import javax.swing.tree.TreeNode;

public class BinaryTree {
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

    public void buildTree(int[] preorder, int[] inorder) {

        root = build(preorder, inorder);
    }

    private TreeNode build(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }

        int r = preorder[0];
        int index = 0;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == r){
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(r);
        node.left = build(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        node.right = build(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));

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
