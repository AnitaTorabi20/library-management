package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

public class CustomStack implements Queue {
    private CustomLinkedList list;

    public CustomStack() {
        list = new CustomLinkedList();
    }

    @Override
    public boolean add(Object t) {
        list.addFirst(t);
        return true;
    }

    @Override
    public boolean offer(Object t) {
        list.addFirst(t);
        return true;
    }

    @Override
    public Object remove() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.removeFirst();
    }

    @Override
    public Object poll() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public Object element() {
        if (list.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return list.getFirst();
    }

    @Override
    public Object peek() {
        if (list.isEmpty()) {
            return null;
        }
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
}
