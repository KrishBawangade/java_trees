package imp_questions.sum_root_to_leaf_nums;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.sumNumbers());
    }
}
