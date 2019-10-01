package lesson2.hw;

public class SelectSort<Item extends Comparable> extends Sort{
    private MyArraylist myArraylist;
    private int size;
    private Item[] list;

    public SelectSort(MyArraylist myArraylist) {
        super(myArraylist);
        this.myArraylist = myArraylist;
        this.size = myArraylist.size();
        this.list = (Item[]) myArraylist.getList();
    }

    /**
     * Метод сортировки "выбором" в обычном порядке
     */
    public void sort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (myArraylist.less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            myArraylist.swap(i, iMin);
        }
    }
}
