package lesson3.hw.task1b;

import lesson3.hw.task3.MyDeque;

class MyPriorityQueue<Item extends Comparable> extends MyDeque {
    private Item[] list;
    private int size = 0;
    //private final int DEFAULT_CAPACITY = 10;

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public MyPriorityQueue() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    public MyPriorityQueue() {
        super();
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Comparable[capacity];
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    public MyPriorityQueue(int capacity) {
        super(capacity, 0);
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public void insert(Item item) {
        super.insertRight(item);
        if (isFull()) {
            throw new StackOverflowError();
        }
        //TODO Added.
        int sortedMinIndex = -1;
        int sortedMaxIndex = size + 1;

        list[size] = item;
        size++;
        int i = size - 1;

        while (i > 0 && list[i].compareTo(list[i - 1]) < 0) {//(list[i]//правый меньше// - list[i - 1]) < 0

            //если проверяемый элемент больше индекса максимального элемента в сортированной части на 1
            if(0 <= list[i].compareTo(list[sortedMaxIndex]) && list[i].compareTo(list[sortedMaxIndex]) <= 1){
                sortedMaxIndex = i;
                break;
            }else{
                swap(i, i - 1);
            }
            i--;
        }
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    public void insert(Item item) {
        super.insertRight(item);

        /*int sortedMinIndex = -1;
        int sortedMaxIndex = size + 1;

        list[size] = item;
        size++;
        int i = size - 1;

        while (i > 0 && list[i].compareTo(list[i - 1]) < 0) {//(list[i]//правый меньше// - list[i - 1]) < 0

            //если проверяемый элемент больше индекса максимального элемента в сортированной части на 1
            if(0 <= list[i].compareTo(list[sortedMaxIndex]) && list[i].compareTo(list[sortedMaxIndex]) <= 1){
                sortedMaxIndex = i;
                break;
            }else{
                swap(i, i - 1);
            }
            i--;
        }*/
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public Item remove() {
        Item temp = peek();
        size--;
        list[size] = null;
        return temp;
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    public Item remove() {
        return (Item)super.removeRight();
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*private Item peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    Item peek() {
        return (Item)super.peekRight();
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public int size() {
        return size;
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    //размер массива
    public int size() {
        return super.size();
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public boolean isEmpty() {
        return size == 0;
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    public boolean isEmpty() {
        return super.isEmpty();
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*public boolean isFull() {
        return size == list.length;
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    public boolean isFull() {
        return super.isFull();
    }

    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Deleted
    /*private void reCapacity(int newCapacity) {
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
    }*/
    //TODO Task1b. Добавление оптимизации при поиске в отсортированном массиве.Added
    protected void reCapacity(int newCapacity) {
        super.reCapacity(newCapacity);
    }

    private void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + " ");
        }
        return sb.toString();
    }
}
