package interfaces;

public interface Iterator {
    boolean hasNext();
    <T> T getNext();
}
