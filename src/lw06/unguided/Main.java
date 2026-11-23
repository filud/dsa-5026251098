import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        BinarySearchTree tree = new BinarySearchTree();

        // Write your main code here
        String firstLine = read.nextLine();
        String[] numbers = firstLine.split(" ");

        Node root = null;

        for(int i = 0; i < numbers.length; i++) {
            int value = Integer.parseInt(numbers[i]);
            tree.insert(value);
        }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        tree.preOrder();

        System.out.print("Inorder : ");
        tree.inOrder();

        System.out.print("Postorder : ");
        tree.postOrder();

        System.out.print("Search " + target + " : " + tree.search(target));

        System.out.print("\nMinimum : ");
        tree.findMin();

        System.out.print("\nMaximum : ");
        tree.findMax();

        read.close();
    }
}