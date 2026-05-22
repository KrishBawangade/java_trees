package imp_questions.binary_tree_next_right_pointer;

import java.util.*;

public class BinaryTree {
    Node root;

    public BinaryTree(){

    }

    public void populate(Scanner sc){
        System.out.print("Enter the root node: ");
        int value = sc.nextInt();
        root = new Node(value);

        populate(sc, root);
    }

    private void populate(Scanner sc, Node node){
        System.out.printf("Do you want to enter left of %d: ", node.val);
        boolean isLeft = sc.nextBoolean();

        if(isLeft){
            System.out.print("Enter the value of the left node: ");
            int value = sc.nextInt();
            Node left = new Node(value);
            node.left = left;
            populate(sc, left);
        }

        System.out.printf("Do you want to enter right of %d: ", node.val);
        boolean isRight = sc.nextBoolean();

        if(isRight){
            System.out.print("Enter the value of the right node: ");
            int value = sc.nextInt();
            Node right = new Node(value);
            node.right = right;
            populate(sc, right);
        }

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
            System.out.println("|------->"+ node.val);
        }else{
            System.out.println(node.val);
        }

        prettyDisplay(node.left, level+1);

    }

    public Node connectRightNext() {

        if(root == null){
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Node> currentLevelList = new ArrayList<>(levelSize);
            
            for(int i=0; i<levelSize; i++){

                Node node = queue.remove();
                
                currentLevelList.add(node);
                
                if(node.left!=null){
                    queue.add(node.left);
                }
        
                if(node.right!=null){
                    queue.add(node.right);
                }

                if(i==0){
                    continue;
                }

                currentLevelList.get(i-1).next = node;
                
            }

        }
        return root;
    }


    private static class Node{
        int val;
        Node left;
        Node right;
        Node next;

        public Node(int value){
            this.val = value;
        }
    }
}
