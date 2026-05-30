package imp_questions.binary_tree_serialize_deserialize;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        String data = bt.serialize();
        System.out.println(data);
        bt.deserialize(data);
        bt.prettyDisplay();
    }
}
