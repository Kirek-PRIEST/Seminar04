package GBCollections.lists;


import GBCollections.GBList;
import GBCollections.lists.util.Node;

import java.util.Iterator;

import java.util.NoSuchElementException;

public class GBLinkedList<E> implements GBList<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> first;

    public GBLinkedList() {
        head = new Node<>(first, null, null);
        first = new Node<>(null, null, head);

    }

    public void addFirst(E value) {
        Node<E> next = first;
        next.setCurrentValue(value);
        first = new Node<>(null, null, next);
        next.setPrevNode(first);
        size++;
    }

    private Node<E> getNextNode(Node<E> current) {
        return current.getNextNode();
    }

    private E unlink(Node<E> n) {
        E element = n.value;
        Node<E> prev = n.prev;
        Node<E> next = n.next;
        n.prev = next;
        n.next = prev;


        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            n.prev = null;
        }

        if (next == null) {
            head = prev;
        } else {
            next.prev = prev;
            n.next = null;
        }

        n.value = null;
        size--;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        E element = l.value;
        Node<E> prev = l.prev;
        l.value = null;
        l.prev = null; // help GC
        l.next = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        E element = f.value;
        Node<E> next = f.next;
        f.value = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            head = null;
        else
            next.prev = null;
        size--;

        return element;
    }

    public E removeLast() {
        final Node<E> l = head;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    public E removeFirst() {
        final Node<E> l = first;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkFirst(l);
    }

    @Override
    public void add(E value) {
        head.setCurrentValue(value);
        Node<E> prev = head;
        head = new Node<>(prev, null, null);
        prev.setNextNode(head);
        size++;
    }

    @Override
    public E getByIndex(int index) {
        Node<E> target = first.getNextNode();
        for (int i = 0; i < index; i++) {

            target = getNextNode(target);

        }
        return target.getCurrentValue();
    }

    @Override
    public E removeByIndex(int index) {
        Node<E> target = first.getNextNode();
        for (int i = 0; i < index; i++) {
            target = getNextNode(target);
        }
        return unlink(target);

    }


    @Override
    public boolean removeByValue(E value) {
        Node<E> target = first.getNextNode();
        int i = 0;
        while (i < size) {
            if (value.equals(target.value)){
               unlink(target);
               return true;
            }
//            else  if (i == size-1) {
//                System.out.println("Элемент " + value + " не найден");
//                break;
//            }
            else {
                target = getNextNode(target);
                i++;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public Object next() {
                return getByIndex(counter);
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int j = 0; j < size; j++) {
            builder.append(getByIndex(j)).append(", ");
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}


