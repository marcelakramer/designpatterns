package tree;

import enums.TraversalType;
import factory.BinarySearchTreeIteratorFactory;
import interfaces.IterableBinarySearchTree;
import interfaces.Iterator;
import interfaces.Prototype;

public class BinarySearchTree<T extends Comparable<T>> implements IterableBinarySearchTree, Prototype {
	private Node<T> root;
	private BinarySearchTreeIteratorFactory iteratorFactory;

	public BinarySearchTree(T value) {
		this.root = new Node<>(value);
		this.iteratorFactory = new BinarySearchTreeIteratorFactory();
	}

	public BinarySearchTree(BinarySearchTree binarySearchTree) {
		this.root =  binarySearchTree.root != null ? binarySearchTree.root.clone() : null;
		this.iteratorFactory = binarySearchTree.iteratorFactory;
	}

	@Override
	public BinarySearchTree<T> clone() {
		return new BinarySearchTree<T>(this);
	}

	public T getRoot() {
		return root != null ? root.value : null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public T search(T value) {
		if (!isEmpty()) {
			Node<T> node = search(root, value);
			return node != null ? node.value : null;
		}
		return null;
	}

	private Node<T> search(Node<T> root, T key) {
		if (root == null) return null;
		if (key.compareTo(root.value) < 0) return search(root.left, key);
		if (key.compareTo(root.value) > 0) return search(root.right, key);
		return root;
	}

	public boolean contains(T key) {
		return contains(root, key);
	}

	private boolean contains(Node<T> root, T key) {
		if (root == null) return false;
		if (key.compareTo(root.value) < 0) return contains(root.left, key);
		if (key.compareTo(root.value) > 0) return contains(root.right, key);
		return true;
	}

	public void add(T value) {
		this.root = addRecursive(this.root, value);
	}

	private Node<T> addRecursive(Node<T> root, T value) {
		if (root == null) return new Node<>(value);
		if (value.compareTo(root.value) < 0) root.left = addRecursive(root.left, value);
		else if (value.compareTo(root.value) > 0) root.right = addRecursive(root.right, value);
		return root;
	}

	public T delete(T key) {
		T node = search(key);
		if (node != null) {
			this.root = delete(root, key);
			return node;
		}
		return null;
	}

	private Node<T> delete(Node<T> root, T data) {
		if (root == null) return null;
		if (data.compareTo(root.value) < 0) root.left = delete(root.left, data);
		else if (data.compareTo(root.value) > 0) root.right = delete(root.right, data);
		else {
			if (root.left == null && root.right == null) return null;
			if (root.right == null) return root.left;
			if (root.left == null) return root.right;
			root.value = findMax(root.left);
			root.left = delete(root.left, root.value);
		}
		return root;
	}

	private T findMax(Node<T> root) {
		while (root.right != null) root = root.right;
		return root.value;
	}

	public int size() {
		return size(root);
	}

	public int size(Node<T> root) {
		if (root == null) return 0;
		return 1 + size(root.left) + size(root.right);
	}

	public Iterator createIterator(TraversalType traversalType) {
		return this.iteratorFactory.createIterator(traversalType, this.root);
	}
}
