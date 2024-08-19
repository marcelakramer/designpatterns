package iterator;

import interfaces.Iterator;
import tree.Node;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LevelOrderIterator<T extends Comparable<T>> implements Iterator<T> {
    private final Queue<Node<T>> queue;

    public LevelOrderIterator(Node<T> root) {
        this.queue = new LinkedList<>();
        if (root != null) {
            this.queue.add(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T getNext() {
        while (this.hasNext()) {
            if (!hasNext()) {
                throw new NoSuchElementException("No more nodes in the tree.");
            }

            Node<T> current = queue.poll();

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }

            return current.value;
        }

        return  null;
    }
}
