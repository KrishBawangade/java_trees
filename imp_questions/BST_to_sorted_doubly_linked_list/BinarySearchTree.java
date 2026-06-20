package imp_questions.BST_to_sorted_doubly_linked_list;

public class BinarySearchTree{
    Node root;
    
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

        System.out.println(details+node.val);
        display(node.left, "Left Child of "+node.val+": ");
        display(node.right, "Right Child of "+node.val+": ");
    }

    public void insert(int val){
        root = insert(val, root);
    }

    private Node insert(int val, Node node){
        if(node == null){
            node = new Node(val);
            return node;
        }

        if(val>node.val){
            node.right = insert(val, node.right);
        }else{
            node.left = insert(val, node.left);
        }

        node.height = Math.max(height(node.left), height(node.right))+1;

        return node;
    }

    public void populate(int[] nums){
        for(int i=0; i<nums.length; i++){
            insert(nums[i]);
        }
    }

    LLNode head;
    LLNode tail;

    public void convertToDoublyLinkedList(){
        convert(root);

        displayDoublyLinkedList();
    }

    private LLNode convert(Node node){
        if(node == null){
            return null;
        }

        LLNode prevNode = convert(node.left);

        LLNode current = new LLNode(node.val);

        tail = current;

        if(head==null){
            head = current;
        }

        if(prevNode !=null){
            prevNode.next = current;
            current.prev = prevNode;
        }

        LLNode nextNode = convert(node.right);

        if(nextNode!=null){
            nextNode.prev = current;
            current.next = nextNode;
            tail = nextNode;
        }

        return tail;
    }

    public void displayDoublyLinkedList(){
        LLNode temp = head;

        while(temp!=null){
            System.out.print(temp.val);
            
            if(temp.next != null){
                System.out.print(" <-> ");
            }
            
            temp = temp.next;
        }
    }

    private class LLNode{
        private int val;
        private LLNode prev;
        private LLNode next;

        public LLNode(int val){
            this.val = val;
        }

    }


    private class Node{
        private int val;
        private int height;
        private Node left;
        private Node right;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, int height){
            this.val = val;
            this.height = height;
        }

        public int getValue(){
            return val;
        }

    }
}