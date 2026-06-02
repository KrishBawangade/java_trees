package imp_questions.path_exists_from_any_node;

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.countPaths(4));
    }
}