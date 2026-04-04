package avl_tree;

public class Main {
    public static void main(String[] args){
        AVLTree tree = new AVLTree();

        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        tree.populate(nums);
        tree.display();
        System.out.println(tree.height());
    }
}
