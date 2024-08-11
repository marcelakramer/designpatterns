import interfaces.Iterator;
import enums.TraversalType;
import tree.BinarySearchTree;

public class Main {
	public static void main(String[] args) throws Exception {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(8);

		bst.add(3);
		bst.add(10);
		bst.add(1);
		bst.add(6);
		bst.add(4);
		bst.add(7);
		bst.add(14);
		bst.add(13);

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

	}
}
