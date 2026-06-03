package imp_questions.dfs_using_stack;

import java.util.*;

public class BinaryTree{
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

    public List<Integer> preorderStack(){
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            preorder.add(node.val);

            if(node.right!=null){
                stack.push(node.right);
            }

            if(node.left !=null){
                stack.push(node.left);
            }

        }

        return preorder;
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