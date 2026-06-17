package imp_questions.vertical_order_traversal_binary_tree;

import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        BinaryTree bt = new BinaryTree();

        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.verticalTraversal());
    }
}