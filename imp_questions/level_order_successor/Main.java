package imp_questions.level_order_successor; 

import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        BinaryTree bt = new BinaryTree();

        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        System.out.println(bt.levelOrderSuccessor(5));
    }
}