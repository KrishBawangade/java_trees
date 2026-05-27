package imp_questions.flatten_binary_tree_to_linked_list;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        bt.flatten();
        bt.prettyDisplay();
    }
}
