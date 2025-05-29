package datastructures.lists;

import datastructures.interfaces.LinkedList;

public class CustomLinkedList implements LinkedList {
    private static class Node {
        Object data;
        Node next;
        Node prev;

        Node(Object data) {
            this.data = data;
        }
    }

    private Node head, tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for (Node current = head; current != null; current = current.next) {
            if (current.data == null) {
                if (o == null) return true;
            } else if (current.data.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        for (Node current = head; current != null; current = current.next) {
            if (current.data == null) {
                if (o == null) {
                    unlink(current);
                    return true;
                }
            } else if (current.data.equals(o)) {
                unlink(current);
                return true;
            }
        }
        return false;
    }

    private void unlink(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        size--;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    @Override
    public Object set(int index, Object element) {
        checkIndex(index);
        Node node = node(index);
        Object oldValue = node.data;
        node.data = element;
        return oldValue;
    }

    @Override
    public void addFirst(Object t) {
        Node newNode = new Node(t);
        Node oldHead = head;
        newNode.next = oldHead;
        head = newNode;
        if (oldHead == null) {
            tail = newNode;
        } else {
            oldHead.prev = newNode;
        }
        size++;
    }

    @Override
    public void addLast(Object t) {
        Node newNode = new Node(t);
        Node oldTail = tail;
        newNode.prev = oldTail;
        tail = newNode;
        if (oldTail == null) {
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    @Override
    public Object removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        Object data = head.data;
        unlink(head);
        return data;
    }

    @Override
    public Object removeLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        Object data = tail.data;
        unlink(tail);
        return data;
    }

    @Override
    public Object getFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    @Override
    public Object getLast() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        return tail.data;
    }

    @Override
    public void clear() {
        for (Node current = head; current != null;) {
            Node next = current.next;
            current.data = null;
            current.prev = null;
            current.next = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    private Node node(int index) {
        if (index < (size >> 1)) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }
}
