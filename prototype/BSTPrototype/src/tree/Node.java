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

    Node(Node node) {
        this.value = (T) node.value;
        this.right = node.right != null ? node.right.clone() : null;
        this.left = node.left != null ? node.left.clone() : null;
    }

    @Override
    public Node<T> clone() {
        return new Node<T>(this);
    }

    public String toString() {
    	return value.toString();
    }
    
    public int compareTo(Node<T> otherNode) {
    	return this.value.compareTo(otherNode.value);
    }
}


