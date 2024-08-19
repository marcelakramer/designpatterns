import interfaces.Iterator;
import enums.TraversalType;
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

        System.out.println("Iterator Test: \n");

        Iterator iterator;

        iterator = bst.createIterator(TraversalType.PREORDER);
        System.out.println("PRE ORDER:");
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext() + " ");
        }

        iterator = bst.createIterator(TraversalType.INORDER);
        System.out.println("IN ORDER:");
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext() + " ");
        }

        iterator = bst.createIterator(TraversalType.POSTORDER);
        System.out.println("POST ORDER:");
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext() + " ");
        }

        iterator = bst.createIterator(TraversalType.LEVELORDER);
        System.out.println("LEVEL ORDER:");
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext() + " ");
        }

        System.out.println("\nPrototype Test: \n");

        BinarySearchTree<Integer> cloneBst = (BinarySearchTree<Integer>) bst.clone();
        cloneBst.add(9);
        cloneBst.add(20);
        cloneBst.add(19);
        cloneBst.add(8);


        Iterator cloneBstIterator;

        cloneBstIterator = cloneBst.createIterator(TraversalType.PREORDER);
        System.out.println("PRE ORDER:");
        while (cloneBstIterator.hasNext()) {
            System.out.println(cloneBstIterator.getNext() + " ");
        }

        cloneBstIterator = cloneBst.createIterator(TraversalType.INORDER);
        System.out.println("IN ORDER:");
        while (cloneBstIterator.hasNext()) {
            System.out.println(cloneBstIterator.getNext() + " ");
        }

        cloneBstIterator = cloneBst.createIterator(TraversalType.POSTORDER);
        System.out.println("POST ORDER:");
        while (cloneBstIterator.hasNext()) {
            System.out.println(cloneBstIterator.getNext() + " ");
        }

        cloneBstIterator = cloneBst.createIterator(TraversalType.LEVELORDER);
        System.out.println("LEVEL ORDER:");
        while (cloneBstIterator.hasNext()) {
            System.out.println(cloneBstIterator.getNext() + " ");
        }

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
