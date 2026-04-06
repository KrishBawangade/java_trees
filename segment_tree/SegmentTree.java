package segment_tree;

public class SegmentTree{

    Node root;

    public SegmentTree(int[] arr){
        root = constructTree(arr, 0, arr.length-1);
    }

    private Node constructTree(int[] arr, int startIndex, int endIndex){
        if(startIndex == endIndex){
            Node node = new Node(startIndex, endIndex);
            node.data = arr[startIndex];
            return node;
        }

        int mid = startIndex + (endIndex - startIndex)/2;

        Node left = constructTree(arr, startIndex, mid);
        Node right = constructTree(arr, mid+1, endIndex);

        Node node = new Node(startIndex, endIndex);
        node.data = left.data + right.data;

        node.left = left;
        node.right = right;

        return node;
    }

    public int findSumBetweenTwoIndices(int startIndex, int endIndex){
        return findSumBetweenTwoIndices(startIndex, endIndex, root);
    }

    private int findSumBetweenTwoIndices(int startIndex, int endIndex, Node node){

        if(node == null){
            return 0;
        }

        if(node.startIndex >= startIndex && node.endIndex <= endIndex){
            return node.data;
        }

        if(node.startIndex > endIndex && node.endIndex < startIndex){
            return 0;
        }

        int leftSum = findSumBetweenTwoIndices(startIndex, endIndex, node.left);
        int rightSum = findSumBetweenTwoIndices(startIndex, endIndex, node.right);

        return leftSum + rightSum;
    }

    public void update(int index, int newValue){
        root = update(index, newValue, root);
    }

    private Node update(int index, int newValue, Node node){
        if(node == null){
            return node;
        }

        if(index < node.startIndex || index > node.endIndex){
            return node;
        }

        if(node.startIndex == index && node.endIndex == index){
            node.data = newValue;
            return node;
        }

        Node left = update(index, newValue, node.left);
        Node right = update(index, newValue, node.right);

        node.data = left.data + right.data;

        return node;
    }

    public void display(){
        display(root, "Root Node: ");
    }

    private void display(Node node, String details){
        if(node == null){
            return;
        }

        System.out.printf("%s: %d ([%d, %d])\n", details, node.data, node.startIndex, node.endIndex);
        display(node.left, "Left Child of "+node.data+": ");
        display(node.right, "Right Child of "+node.data+": ");
    }


    private static class Node{
        private int data;
        private int startIndex;
        private int endIndex;
        private Node left;
        private Node right;

        public Node(int startIndex, int endIndex){
            this.data = data;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }
}