package binary_search_tree;

public class Main {
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();

        int[] nums = {15, 10, 20, 5, 11};
        int[] numsSorted = {1,2,3,4,5,6,7,8,9,10};

        // tree.populate(nums);
        tree.populateSorted(numsSorted);
        tree.display();
    }
}
