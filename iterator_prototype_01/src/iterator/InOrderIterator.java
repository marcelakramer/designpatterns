package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class InOrderIterator<T extends Comparable<T>> implements Iterator<T> {
    private final Stack<Node<T>> stack;
    private Node<T> current;

    public InOrderIterator(Node<T> root) {
        this.stack = new Stack<>();
        this.current = root;
    }

    @Override
    public boolean hasNext() {
        return this.current != null || !stack.isEmpty();
    }

    @Override
    public T getNext() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes in the tree.");
        }

        while (this.current != null) {
            this.stack.push(this.current);
            this.current = this.current.left;
        }

        this.current = this.stack.pop();
        T data = this.current.value;
        this.current = this.current.right;
        return data;

    }
}
