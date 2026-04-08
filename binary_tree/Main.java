package binary_tree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        bt.populate(sc);
        // bt.prettyDisplay();
        // bt.preOrder();
        // System.out.println("\n");
        // bt.inOrder();
        // System.out.println("\n");
        // bt.postOrder();

        bt.breadthFirstSearchDisplay();
    }
}
