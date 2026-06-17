package imp_questions.vertical_order_traversal_binary_tree;

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

    public List<List<Integer>> verticalTraversal() {
        if(root == null){
            return new ArrayList<>();
        }

        int minCol = 0;
        int maxCol = 0;
        HashMap<Integer, List<int[]>> colMap = new HashMap<>();

        List<List<Integer>> verticalTraversalList = new ArrayList<>();

        Queue<Map.Entry<TreeNode, int[]>> queue = new ArrayDeque<>();

        queue.offer(new AbstractMap.SimpleEntry<>(root, new int[] {0,0}));

        while(!queue.isEmpty()){
            Map.Entry<TreeNode, int[]> removed = queue.poll();
            
            TreeNode node = removed.getKey();
            int[] coordinates = removed.getValue();

            int row = coordinates[0];
            int col = coordinates[1];
            
            List<int[]> colList = colMap.getOrDefault(col, new ArrayList<>());

            colList.add(new int[] {row, node.val});
            colMap.put(col, colList);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if(node.left != null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.left, new int[] {row+1, col-1}));
            }

            if(node.right != null){
                queue.offer(new AbstractMap.SimpleEntry<>(node.right, new int[] {row+1, col+1}));
            }
        }

        for(int i=minCol; i<=maxCol; i++){
            List<int[]> colList = colMap.getOrDefault(i, new ArrayList<>());
            List<Integer> current = new ArrayList<>();

            if(colList.isEmpty()){
                continue;
            }

            Collections.sort(colList, (a, b) -> {
                if(a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);  
                }
                return Integer.compare(a[1], b[1]); 
            });

            for(int[] pair: colList){
                current.add(pair[1]);
            }

            verticalTraversalList.add(current);
        }

        return verticalTraversalList;
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