package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class PostOrderIterator<T extends Comparable<T>> implements Iterator<T> {
    private final Stack<Node<T>> stack;
    private Node<T> lastVisitedNode;

    public PostOrderIterator(Node<T> root) {
        this.stack = new Stack<>();
        this.lastVisitedNode = null;
        this.pushLeftmostNodes(root);
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

        while (hasNext()) {
            Node<T> current = stack.peek();

            if (current.right == null || current.right == lastVisitedNode) {
                lastVisitedNode = stack.pop();
                return lastVisitedNode.value;
            } else {
                current = current.right;
                pushLeftmostNodes(current);
            }
        }

        return null;
    }

    private void pushLeftmostNodes(Node<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
