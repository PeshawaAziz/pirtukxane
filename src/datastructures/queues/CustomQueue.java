package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;

    public CustomQueue(int capacity) {
        list = new CustomLinkedList<>();
        setCapacity(capacity);
    }

    @Override
    public boolean add(Object t) {
        try {
            if (list.size() < capacity)
                return list.add((T) t);
            else
                throw new IllegalStateException("Cannot add the provided object to the queue. Queue is full.");
        } catch (ClassCastException e) {
            System.out.println("Cannot add the provided object to the queue. Invalid type.");
            return false;
        }
    }

    @Override
    public boolean offer(Object t) {
        try {
            if (list.size() < capacity)
                return list.add((T) t);
            else
                return false;
        } catch (ClassCastException e) {
            System.out.println("Cannot add the provided object to the queue. Invalid type.");
            return false;
        }
    }

    @Override
    public T remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public T poll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'poll'");
    }

    @Override
    public T element() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'element'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    private final void setCapacity(int capacity) {
        if (capacity < 0)
            throw new IllegalArgumentException("The queue capacity cannot be negative.");
        else
            this.capacity = capacity;

    }

}