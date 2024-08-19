package interfaces;

import enums.TraversalType;

public interface IterableBinarySearchTree<T extends Comparable<T>> {
    Iterator<T> createIterator(TraversalType traversalType);
}
