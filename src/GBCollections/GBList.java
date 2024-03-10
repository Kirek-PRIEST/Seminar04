package GBCollections;

public interface GBList<T> extends Iterable<T> {
    void add(T value);

    T getByIndex(int index);

    T removeByIndex(int index);

    public boolean removeByValue(T value);

    int size();
}
