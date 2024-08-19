package interfaces;

public interface Iterator<T extends Comparable<T>> {
    boolean hasNext();
    T getNext();
}
