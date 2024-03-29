package GBCollections.lists;

import GBCollections.GBList;
import GBCollections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GBArrayList<E> implements GBList<E> {
    private E[] values;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public GBArrayList() {
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (E[]) new Object[capacity];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }


    }

    private void addCapacity() {
        capacity = capacity + capacity / 2;
        E[] array = (E[]) new Object[capacity];
        System.arraycopy(values, 0, array, 0, values.length);
        this.values = array;
    }

    @Override
    public void add(E value) {
        if (size == capacity) {
            addCapacity();
        }
        values[size++] = value;
    }


    @Override
    public E getByIndex(int index) {
        return values[index];
    }

    //    @Override
//    public void removeByIndex(E value) {
//        for (int i = 0; i < values.length; i++) {
//            if (values[i].equals(value)) {
//                removeByIndex(i);
//                return;
//            }
//        }
//        throw  new RuntimeException("Element is not found");
//    }
//    @Override
//    @SuppressWarnings("unchecked")
//    public void remove(int index) {
//        try {
//            E[] temp = values;
//            values = (E[]) new Object[temp.length - 1];
//            System.arraycopy(temp, 0, values, 0, index);
//            int amountElementsAfterIndex = temp.length - index - 1;
//            System.arraycopy(temp, index + 1, values, index, amountElementsAfterIndex);
//        } catch (ClassCastException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @Override
    public E removeByIndex(int index) {
        capacity -= 1;
        E value = values[index];
        E[] res = (E[]) new Object[capacity];
        System.arraycopy(values, 0, res, 0, index);
        int amountElementsAfterIndex = values.length - index - 1;
        System.arraycopy(values, index + 1, res, index, amountElementsAfterIndex);
        size--;
        values = res;
        return value;
    }

    @Override
    public boolean removeByValue(E value) {
    return false;
    }

    //    @Override
//    public void remove(int index) {
//
//        E[] res = values;
//        values = (E[]) new Object[capacity];
//        System.arraycopy(res, 0, values, 0, index);
//        int amountElementsAfterIndex = res.length - index - 1;
//        System.arraycopy(res, index + 1, values, index, amountElementsAfterIndex);
//        size --;
//    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
