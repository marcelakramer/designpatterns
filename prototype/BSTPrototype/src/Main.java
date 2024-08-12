import tree.BinarySearchTree;


public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(8);

        bst.add(3);
        bst.add(10);
        bst.add(1);
        bst.add(6);
        bst.add(4);
        bst.add(7);
        bst.add(14);
        bst.add(13);

        BinarySearchTree<Integer> cloneBst = bst.clone();
        cloneBst.add(9);
        cloneBst.add(20);
        cloneBst.add(19);
        cloneBst.add(8);

        System.out.println("Original tree:");
        bst.preorder();
        bst.inorder();
        bst.postorder();
        System.out.println();

        System.out.println("Clone tree:");
        cloneBst.preorder();
        cloneBst.inorder();
        cloneBst.postorder();
        System.out.println();

        System.out.println("Search 3 in original tree: " + bst.search(3));
        System.out.println("Search 9 in original tree: " + bst.search(9));

        System.out.println("Search 3 in clone tree: " + cloneBst.search(3));
        System.out.println("Search 9 in clone tree: " + cloneBst.search(9));

        cloneBst.delete(3);

        System.out.println("Search 3 in original tree after removal from clone: " + bst.search(3));
        System.out.println("Search 3 in clone tree after removal from clone: " + cloneBst.search(3));

        System.out.println("Original tree size: " + bst.size());
        System.out.println("Clone tree size: " + cloneBst.size());
    }
}