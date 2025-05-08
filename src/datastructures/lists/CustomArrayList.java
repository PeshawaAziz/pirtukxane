package datastructures.lists;

import datastructures.interfaces.List;
import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        if (t == null)
            throw new NullPointerException("Cannot add null to the list.");

        if (size == elements.length) {
            Object[] resizedElements = Arrays.copyOf(elements, elements.length * 2);
            elements = resizedElements;
        }

        elements[size++] = t;

        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Object object : elements)
            if (object.equals(o))
                return true;

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException("Cannot remove null from the list.");

        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                elements[i] = null;

                int j;
                for (j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[j] = null;

                size--;
            }
        }

        return true;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);

        elements[index] = element;

        return (T) elements[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The index is invalid.");
    }
}