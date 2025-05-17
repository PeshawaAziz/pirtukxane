package datastructures.lists;

import datastructures.interfaces.LinkedList;

public class CustomLinkedList<T> implements LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public T get(int index) {
        checkIndex(index);

        Node<T> node = node(index);
        if (node == null)
            return null;
        else
            return node.data;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);

        Node<T> node = node(index);
        T oldData = node.data;
        node.data = element;

        return oldData;
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
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;

        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> node = node(o);

        return node != null;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> node = node(o);

        if (node == null)
            return false;

        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;

        size--;

        return true;
    }

    @Override
    public void addFirst(T t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addFirst'");
    }

    @Override
    public void addLast(T t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLast'");
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T getFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }

    @Override
    public T getLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLast'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    private Node<T> node(int index) {
        if (head == null) {
            return null;
        } else {
            Node<T> current;

            if (index < size / 2) {
                current = head;

                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
            } else {
                current = tail;

                for (int i = size - 1; i > index; i--) {
                    current = current.prev;
                }
            }

            return current;
        }
    }

    private Node<T> node(Object o) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(o)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("The index is invalid.");
    }
}