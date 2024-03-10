import GBCollections.GBList;
import GBCollections.lists.GBArrayList;
import GBCollections.lists.GBLinkedList;

public class Main {
    public static void main(String[] args) {

        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(66);
        list.add(44);
        list.addFirst(5);
        System.out.println(list.size());
        System.out.println("Создан лист: " + list + ". Размер списка = " + list.size());
        System.out.println("Удалён элемент " + list.removeByIndex(2) + " по индексу: " + list + ". Размер списка = " + list.size());
        System.out.println("Состояние удаления: " + list.removeByValue(3));
        System.out.println("Удалён элемент по значению: " + list + ". Размер списка = " + list.size());
        list.removeLast();
        System.out.println("Удалён послендний элемент: " + list + ". Размер списка = " + list.size());
        list.removeFirst();
        System.out.println("Удалён первый элемент: " + list + ". Размер списка = " + list.size());

    }
}