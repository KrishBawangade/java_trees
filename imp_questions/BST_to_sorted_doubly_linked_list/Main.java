package imp_questions.BST_to_sorted_doubly_linked_list;

public class Main{
    public static void main(String[] args){
        BinarySearchTree tree = new BinarySearchTree();

        int[] nums = {15, 10, 20, 5, 11};

        tree.populate(nums);
        
        tree.convertToDoublyLinkedList();
    }
}