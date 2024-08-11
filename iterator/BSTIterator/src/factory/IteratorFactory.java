package factory;

import enums.TraversalType;
import interfaces.Iterator;
import iterator.*;
import tree.Node;

public class IteratorFactory {

    public Iterator createIterator(TraversalType traversalType, Node node) {
        return switch (traversalType) {
            case TraversalType.PREORDER -> new PreOrderIterator(node);
            case TraversalType.INORDER -> new InOrderIterator(node);
            case TraversalType.POSTORDER -> new PostOrderIterator(node);
            case TraversalType.LEVELORDER -> new LevelOrderIterator(node);
            default -> throw new IllegalArgumentException("Invalid traversal type.");
        };
    }
}
