package datastructures.interfaces;

public interface LinkedList<T> extends List<T> {
    void addFirst(T t);

    void addLast(T t);

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();

    void clear();
}
