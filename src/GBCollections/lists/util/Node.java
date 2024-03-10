package GBCollections.lists.util;

public class Node <E>{
    public E value;
    public Node <E> next;
    public Node<E> prev;

    public Node(Node<E> prev, E value, Node<E> next) {
        this.prev = prev;
        this.value = value;
        this.next = next;
    }

    public E getCurrentValue(){
        return value;
    }
    public void setCurrentValue(E value){
        this.value = value;
    }
    public Node<E> getNextNode(){
        return next;
    }
    public void setNextNode(Node<E> nextNode){
        next = nextNode;
    }
    public Node<E> getPrevNode(){
        return prev;
    }
    public void setPrevNode(Node<E> prevNode){
        prev = prevNode;
    }
}
