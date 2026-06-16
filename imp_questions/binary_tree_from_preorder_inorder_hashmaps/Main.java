package imp_questions.binary_tree_from_preorder_inorder_hashmaps;

public class Main{
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        int[] preorder = {1,2,3,4,5,6,7};
        int[] inorder = {4,3,2,5,1,6,7};

        bt.constructBinaryTree(preorder, inorder);

        bt.prettyDisplay();
    }
}