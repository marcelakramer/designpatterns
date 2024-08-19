package factory;

import enums.TraversalType;
import interfaces.*;
import iterator.*;
import tree.Node;

public class BinarySearchTreeIteratorFactory<T extends Comparable<T>> implements IteratorFactory<T> {

    public Iterator<T> createIterator(TraversalType traversalType, Node<T> node) {
        return switch (traversalType) {
            case TraversalType.PREORDER -> new PreOrderIterator<T>(node);
            case TraversalType.INORDER -> new InOrderIterator<T>(node);
            case TraversalType.POSTORDER -> new PostOrderIterator<T>(node);
            case TraversalType.LEVELORDER -> new LevelOrderIterator<T>(node);
            default -> throw new IllegalArgumentException("Invalid traversal type.");
        };
    }
}
