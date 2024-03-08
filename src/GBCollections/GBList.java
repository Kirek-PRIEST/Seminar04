package GBCollections;

public interface GBList<T> extends Iterable<T>{
    void add(T value);
    void add(int index, T value);
    T get(int index);

    void removeByIndex(int index);
    public void removeByValue(T value);
    int size();
}
