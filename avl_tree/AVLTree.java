package avl_tree;

public class AVLTree {
    Node root;

    public int height(){
        return root.height;
    }
    
    public int height(Node node){

        if(node == null){
            return -1;
        }

        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
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

    private Node insert(int value, Node node){
        if(node == null){
            node = new Node(value);
            return node;
        }

        if(value>node.value){
            node.right = insert(value, node.right);
        }else{
            node.left = insert(value, node.left);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return rotate(node);
    }

    private Node rotate(Node node){
        // left heavy
        if(height(node.left) - height(node.right) > 1){

            // left - left case
            if(height(node.left.left) - height(node.left.right) > 0){
                return rightRotate(node);
            }

            // left - right case
            if(height(node.left.left) - height(node.left.right) < 0){
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }   
        } 

        // right heavy
        if(height(node.left) - height(node.right) < -1){
            // right - left case
            if(height(node.right.left) - height(node.right.right) > 0){
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            // right - right case
            if(height(node.right.left) - height(node.right.right) < 0){
                return leftRotate(node);
            }
        }
        
        return node;
    }

    private Node rightRotate(Node p){
        Node c = p.left;
        Node rightSubtree = c.right;
        c.right = p;
        p.left = rightSubtree;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;

        return c;
    }

    private Node leftRotate(Node p){
        Node c = p.right;
        Node leftSubtree = c.left;
        c.left = p;
        p.right = leftSubtree;

        p.height = Math.max(height(p.left), height(p.right))+1;
        c.height = Math.max(height(c.left), height(c.right))+1;

        return c;
    }


    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    public void populateSorted(int[] nums){
        populateSorted(0, nums.length-1, nums);
    }

    private void populateSorted(int low, int high, int[] nums){

        if(low > high){
            return;
        }

        int mid = low + ((high-low)/2);
        insert(nums[mid]);

        populateSorted(low, mid-1, nums);
        populateSorted(mid+1, high, nums);
        
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node){
        if(node == null){
            return true;
        }

        return (Math.abs(height(node.left) - height(node.right))<=1) && isBalanced(node.left) && isBalanced(node.right);
    }


    private class Node{
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, int height){
            this.value = value;
            this.height = height;
        }

        public int getValue(){
            return value;
        }

    }
    
}
