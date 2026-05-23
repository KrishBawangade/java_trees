package imp_questions.cousins_binary_tree;

import java.util.*;

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

    public boolean isCousins(int x, int y) {

        if(root == null){
            return false;
        }

        TreeNode nodeX = findNode(root, x);
        TreeNode nodeY = findNode(root, y);

        return (level(root, nodeX, 0) == level(root, nodeY, 0) && !isSiblings(root, nodeX, nodeY));
    }

    TreeNode findNode(TreeNode node, int val){
        if(node == null){
            return node;
        }

        if(node.val == val){
            return node;
        }

        TreeNode left = findNode(node.left, val);
        if(left != null){
            return left;
        }

        return findNode(node.right, val);
    }

    int level(TreeNode node, TreeNode lvlNode, int level){
        if(node == null){
            return 0;
        }

        if(node == lvlNode){
            return level;
        }

        int leftLevel = level(node.left, lvlNode, level+1);
        if(leftLevel !=0){
            return leftLevel;
        }
        return level(node.right, lvlNode, level+1);
    }

    boolean isSiblings(TreeNode node, TreeNode x, TreeNode y){
        if(node == null){
            return false;
        }

        return ( 
            (node.left == x && node.right == y) || (node.right == x && node.left == y) 
            || isSiblings(node.left, x, y)
            || isSiblings(node.right, x, y)
        );
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
