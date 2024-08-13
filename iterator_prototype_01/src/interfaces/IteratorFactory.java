package interfaces;

import enums.TraversalType;
import tree.Node;

public interface IteratorFactory {
    Iterator createIterator(TraversalType traversalType, Node node);
}
