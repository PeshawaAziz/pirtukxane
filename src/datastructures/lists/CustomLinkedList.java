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
        Node<T> newNode = new Node<>(t);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    @Override
    public T removeFirst() {
        if (head == null) {
            return null;
        }

        T data = head.data;

        if (head.next != null) {
            head = head.next;
            head.prev = null;
        } else {
            head = null;
            tail = null;
        }

        size--;

        return data;
    }

    @Override
    public T removeLast() {
        if (tail == null) {
            return null;
        }

        T data = tail.data;

        if (tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }

        size--;

        return data;
    }

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
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

    public void display() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}