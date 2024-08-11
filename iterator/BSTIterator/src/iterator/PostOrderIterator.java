package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.NoSuchElementException;
import java.util.Stack;

public class PostOrderIterator implements Iterator {
    private Stack<Node> stack;
    private Node lastVisitedNode;

    public PostOrderIterator(Node root) {
        this.stack = new Stack<>();
        this.lastVisitedNode = null;
        this.pushLeftmostNodes(root);
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

        while (hasNext()) {
            Node current = stack.peek();

            if (current.right == null || current.right == lastVisitedNode) {
                lastVisitedNode = stack.pop();
                return (T) lastVisitedNode.value;
            } else {
                current = current.right;
                pushLeftmostNodes(current);
            }
        }

        return null;
    }

    private void pushLeftmostNodes(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
