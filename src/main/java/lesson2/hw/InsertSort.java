package lesson2.hw;

public class InsertSort<Item extends Comparable> extends Sort {
    private MyArraylist myArraylist;
    private int size;
    private Item[] list;

    public InsertSort(MyArraylist myArraylist) {
        super(myArraylist);
        this.myArraylist = myArraylist;
        this.size = myArraylist.size();
        this.list = (Item[]) myArraylist.getList();
    }

    /**
     * Метод сортировки "вставкой" в обычном порядке
     */
    public void sort() {
        Item key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];

            while (j > 0 && myArraylist.less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }
}
