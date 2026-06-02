package imp_questions.path_exists_from_any_node;

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

    public int countPaths(int targetSum) {
        return count(root, targetSum, new ArrayList<>());
    }

    private int count(TreeNode node, int targetSum, List<Integer> path){
        if(node == null){
            return 0;
        }

        path.add(node.val);
        int count =0;
        int sum = 0;

        ListIterator<Integer> itr = path.listIterator(path.size());

        while(itr.hasPrevious()){
            sum+=itr.previous();

            if(sum==targetSum){
                count++;
            }
        }

        count+= count(node.left, targetSum, path) + count(node.right, targetSum, path);
        path.remove(path.size()-1);

        return count;
    }

    List<List<Integer>> findPaths(int targetSum){
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        find(root, targetSum, path, paths)
        return paths;
    }

    List<List<Integer>> find(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> paths){
        if(node == null){
            return new ArrayList<>();
        }

        path.add(node.val);

        if(node.val == targetSum && node.left == null && node.right == null){
            return new ArrayList<>(path);
        }else{
            find(node.left, targetSum - node.val, path, paths);
            find(node.right, targetSum - node.val, path, paths);
        }

        path.remove(path.size()-1);
        return paths;
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