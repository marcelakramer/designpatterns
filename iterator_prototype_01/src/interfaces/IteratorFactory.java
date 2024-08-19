package interfaces;

import enums.TraversalType;
import tree.Node;

public interface IteratorFactory <T extends Comparable<T>> {
    Iterator<T> createIterator(TraversalType traversalType, Node<T> node);
}
