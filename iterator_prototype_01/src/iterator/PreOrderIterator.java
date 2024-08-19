package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderIterator<T extends Comparable<T>> implements Iterator<T> {
    private final Stack<Node<T>> stack;

    public PreOrderIterator(Node<T> root) {
        this.stack = new Stack<>();
        this.stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T getNext() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes in the tree.");
        }

        Node<T> current = this.stack.pop();

        if (current.right != null) {
            this.stack.push(current.right);
        }

        if (current.left != null) {
            this.stack.push(current.left);
        }

        return current.value;
    }
}
