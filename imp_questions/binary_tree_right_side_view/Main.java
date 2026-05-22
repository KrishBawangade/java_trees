package imp_questions.binary_tree_right_side_view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.rightSideView());
    }
}
