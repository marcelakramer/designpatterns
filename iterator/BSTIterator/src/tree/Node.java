package tree;

public class Node<T extends Comparable<T>> {
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
}


