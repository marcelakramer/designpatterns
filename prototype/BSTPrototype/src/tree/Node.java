package tree;

import interfaces.Prototype;

public class Node<T extends Comparable<T>> implements Prototype {
    public T value;
    public Node<T> left;
    public Node<T> right;

    Node(T value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
    
    public String toString() {
    	return value.toString();
    }
    
    public int compareTo(Node<T> otherNode) {
    	return this.value.compareTo(otherNode.value);
    }

    @Override
    public Node clone() {
        Node newNode = new Node(this.value);
        if (this.left != null) {
            newNode.left = this.left.clone();
        }
        if (this.right != null) {
            newNode.right = this.right.clone();
        }
        return newNode;
    }
}


