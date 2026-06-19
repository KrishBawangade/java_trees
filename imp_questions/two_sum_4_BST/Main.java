package imp_questions.two_sum_4_BST;

public class Main{
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();

        int[] nums = {5,3,6,2,4,7};

        tree.populate(nums);

        System.out.println(tree.findTarget(28));
        
    }
}