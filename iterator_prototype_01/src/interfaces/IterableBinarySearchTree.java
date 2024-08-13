package interfaces;

import enums.TraversalType;

public interface IterableBinarySearchTree {
    Iterator createIterator(TraversalType traversalType);
}
