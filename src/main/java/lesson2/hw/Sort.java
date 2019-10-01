package lesson2.hw;

import java.util.Comparator;

public abstract class Sort<Item extends Comparable> {
    private MyArraylist myArraylist;
    private int size;
    private Item[] list;

    public Sort(MyArraylist myArraylist) {
        this.myArraylist = myArraylist;
        this.size = myArraylist.size();
        this.list = (Item[]) myArraylist.getList();
    }

    public abstract void sort();

    public Item[] getList() {
        return list;
    }
}
