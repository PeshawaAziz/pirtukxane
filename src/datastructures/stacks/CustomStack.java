package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;
import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;

    public CustomStack() {
        list = new CustomLinkedList<>();
        setCapacity(capacity);
    }

    @Override
    public boolean add(Object t) {
        try {
            if (list.size() < capacity) {
                list.addFirst((T) t);
                return true;
            } else
                throw new IllegalStateException("Cannot add the provided object to the stack. Stack is full.");
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean offer(Object t) {
        try {
            if (list.size() < capacity) {
                list.addFirst((T) t);
                return true;
            } else
                return false;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public T remove() {
        if (list.isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        else {
            T first = list.getFirst();
            list.removeFirst();
            return first;
        }
    }

    @Override
    public T poll() {
        if (list.isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        else {
            T first = list.getFirst();
            list.removeFirst();
            return first;
        }
    }

    @Override
    public T element() {
        if (list.isEmpty())
            throw new NoSuchElementException("The queue is empty.");
        else
            return list.getFirst();
    }

    @Override
    public T peek() {
        if (list.isEmpty())
            return null;
        else
            return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    private void setCapacity(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("The queue capacity cannot be negative.");
        else
            this.capacity = capacity;
    }
}