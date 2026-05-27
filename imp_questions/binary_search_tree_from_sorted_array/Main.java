package imp_questions.binary_search_tree_from_sorted_array;

public class Main {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();

        int[] nums = {1,2,3,4,5,6,7};

        bst.sortedArrayToBST(nums);
        bst.prettyDisplay();
    }
}
