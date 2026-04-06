package segment_tree;

public class Main {
    public static void main(String[] args){

        int[] arr = {3,8,7,6,-2,-8,4,9};

        SegmentTree tree = new SegmentTree(arr);
        tree.update(3, 7);
        tree.display();
        // System.out.println("Sum between 4 and 7 is "+ tree.findSumBetweenTwoIndices(4,7));
    }
}
