package imp_questions.binary_tree_zig_zag_level_order;

import java.util.*;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.zigzagLevelOrder());
    }
}
