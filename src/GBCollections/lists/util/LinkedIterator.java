package GBCollections.lists.util;

import GBCollections.lists.GBLinkedList;

import java.util.Iterator;

public class LinkedIterator<E> implements Iterator {
    GBLinkedList<E> node;
    int index;

    public LinkedIterator(GBLinkedList<E> node) {
        this.node = node;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < node.size( );
    }

    @Override
    public Object next() {
        return node.getByIndex(index++);
    }
}
