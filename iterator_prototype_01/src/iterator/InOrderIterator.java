package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class InOrderIterator implements Iterator {
    private Stack<Node> stack;
    private Node current;

    public InOrderIterator(Node root) {
        this.stack = new Stack<>();
        this.current = root;
    }

    @Override
    public boolean hasNext() {
        return this.current != null || !stack.isEmpty();
    }

    @Override
    public <T> T getNext() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes in the tree.");
        }

        while (this.current != null) {
            this.stack.push(this.current);
            this.current = this.current.left;
        }

        this.current = this.stack.pop();
        T data = (T) this.current.value;
        this.current = this.current.right;
        return data;

    }
}
