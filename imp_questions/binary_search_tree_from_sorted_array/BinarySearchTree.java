package imp_questions.binary_search_tree_from_sorted_array;


public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree(){

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

    public TreeNode sortedArrayToBST(int[] nums) {
        root = BSTFromSortedArray(0, nums.length-1, nums);
        return root;
    }

    private TreeNode BSTFromSortedArray(int low, int high, int[] nums){
        if(low>high){
            return null;
        }

        int mid = low + (high-low)/2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = BSTFromSortedArray(low, mid-1, nums);
        node.right= BSTFromSortedArray(mid+1, high, nums);

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
