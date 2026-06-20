package imp_questions.two_node_swap;

public class TwoNodeSwap{

    Node first;
    Node second;
    Node prev;

    public void correctBST(Node root){
        iot(root); // Inorder Traversal

        // swap value
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void iot(Node node){

        if(node == null){
            return;
        }

        iot(node.left);

        if(prev != null && prev.val> node.val){
            if(first!=null){
                first = prev;
            }

            second = node;
        }

        prev = node;

        iot(node.right);
    }

    private class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
        }
    }
}