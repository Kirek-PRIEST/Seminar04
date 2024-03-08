import GBCollections.GBList;
import GBCollections.lists.GBArrayList;

public class Main {
    public static void main(String[] args) {

        GBList<Integer> list = new GBArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.size());
        System.out.println(list);
        list.removeByIndex(1);
        list.removeByValue(4);
        System.out.println(list);
    }
}