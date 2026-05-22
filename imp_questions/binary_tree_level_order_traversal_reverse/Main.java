package imp_questions.binary_tree_level_order_traversal_reverse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.levelOrderReverse());
    }
}
