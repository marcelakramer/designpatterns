package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderIterator implements Iterator {
    private Stack<Node> stack;

    public PreOrderIterator(Node root) {
        this.stack = new Stack<>();
        this.stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public <T> T getNext() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more nodes in the tree.");
        }

        Node current = this.stack.pop();

        if (current.right != null) {
            this.stack.push(current.right);
        }

        if (current.left != null) {
            this.stack.push(current.left);
        }

        return (T) current.value;
    }
}
