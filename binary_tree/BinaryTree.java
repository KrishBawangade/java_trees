package binary_tree;

import java.util.Scanner;

public class BinaryTree{

    private Node root;

    public BinaryTree(){

    }

    public void populate(Scanner sc){
        System.out.print("Enter the root node: ");
        int value = sc.nextInt();
        root = new Node(value);

        populate(sc, root);
    }

    private void populate(Scanner sc, Node node){
        System.out.printf("Do you want to enter left of %d: ", node.value);
        boolean isLeft = sc.nextBoolean();

        if(isLeft){
            System.out.print("Enter the value of the left node: ");
            int value = sc.nextInt();
            Node left = new Node(value);
            node.left = left;
            populate(sc, left);
        }

        System.out.printf("Do you want to enter right of %d: ", node.value);
        boolean isRight = sc.nextBoolean();

        if(isRight){
            System.out.print("Enter the value of the right node: ");
            int value = sc.nextInt();
            Node right = new Node(value);
            node.right = right;
            populate(sc, right);
        }

    }

    public void display(){
        display(root, "");
    }

    private void display(Node node, String indent){
        if(node == null){
            return;
        }

        System.out.println(indent+ node.value);
        display(node.left, indent+"\t");
        display(node.right, indent+"\t");
    }

    public void prettyDisplay(){
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(Node node, int level){
        if(node == null){
            return;
        }

        prettyDisplay(node.right, level+1);

        if(level != 0){
            for(int i=0; i<level-1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+ node.value);
        }else{
            System.out.println(node.value);
        }

        prettyDisplay(node.left, level+1);

    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        
        inOrder(node.left);
        System.out.print(node.value+ " ");
        inOrder(node.right);
    }
    
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+ " ");
    }

    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
        }
    }

}