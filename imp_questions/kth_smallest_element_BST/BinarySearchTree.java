package imp_questions.kth_smallest_element_BST;

public class BinarySearchTree {
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

        System.out.println(details+node.value);
        display(node.left, "Left Child of "+node.value+": ");
        display(node.right, "Right Child of "+node.value+": ");
    }

    public void insert(int value){
        root = insert(value, root);
    }

    private TreeNode insert(int value, TreeNode node){
        if(node == null){
            node = new TreeNode(value);
            return node;
        }

        if(value>node.value){
            node.right = insert(value, node.right);
        }else{
            node.left = insert(value, node.left);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    int k;

    public int kthSmallest(int k){
        this.k = k;
        return smallestK(root);
    }

    private Integer smallestK(TreeNode node){
        if(node == null){
            return null;
        }

        Integer left = smallestK(node.left);
        k--;
        if(k==0){
            return node.val;
        }

        if(k<0){
            return left;
        }

        Integer right = smallestK(node.right);

        return right!=null ? right: node.val;

    }

    private class TreeNode{
        private int value;
        private int height;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }

    }
    
}
