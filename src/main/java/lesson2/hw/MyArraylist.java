package lesson2.hw;

import java.util.Comparator;

public class MyArraylist<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private final double DEFAULT_LOAD_FACTOR = 0.75;

    MyArraylist(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        list = (Item[]) new Comparable[capacity];
    }

    public MyArraylist() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }

    /**
     * Метод добавляет новый элемент в первое пустое место в конце массива.
     * Добавлено увеличение вместимости при превышении размера массива.
     * @param item - добавляемый элемент
     */
    void add(Item item) {
        //проверяем не превышена ли вместимость и увеличиваем вместимость
        ensureCapacity(list.length, size);
        list[size] = item;
        size++;
    }

    /**
     * Метод вставляет новый элемент в требуемое место в массиве.
     * Добавлено увеличение вместимости при превышении размера массива.
     * @param index - индекс куда требуется вставить элемент
     * @param item - добавляемый элемент
     */
    public void add(int index, Item item) {
        //проверяем не превышена ли вместимость и увеличиваем вместимость
        ensureCapacity(list.length, size);
        //если индекс отрицательный, устанавливаем в начало
        if (index < 0) {
            index = 0;
        }
        //если индекс больше размера, устанавливаем на последней не занятой ячейке
        if (index > size) {
            index = size;
        }
        //сдвигаем вправо все элементы правее индекса вставки
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        //вставляем объект
        list[index] = item;
        //инкрементируем значение текущего индекса
        size++;
    }

    public boolean remove(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        size--;
        list[size] = null;
        return true;
    }

    public Item get(int index) {
        return list[index];
    }

    public void set(int index, Item item) {
        list[index] = item;
    }

    public int size() {
        return size;
    }

    public boolean find(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        Item temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    /**
     * Метод увеличивает вместимость массива на требуемое значение + вместимость по умолчанию
     * @param minCapacity - требуемая вместимость
     */
    private void increaseCapacity(int minCapacity){
        //если требуемый размер больше текущего размера массива
        if(minCapacity > list.length){
            //то увеличиваем размер массива на на требуемое значение + вместимость по умолчанию
            createNewArrayInternal(minCapacity);
        }
    }

    /**
     * Метод уменьшает вместимость размер массива до требуемого размера, если требуется
     */
    private void trimToSize(){
        //если текущий индекс(первая пустая ячейка) меньше размера массива + вместимость по умолчанию
        if(size < (int)(list.length * DEFAULT_LOAD_FACTOR)){
            //то создаем новый массив с новой вместимостью
            createNewArrayInternal((int)(size * DEFAULT_LOAD_FACTOR + DEFAULT_CAPACITY));
        }
    }

    /**
     * Метод проверяет не превышена ли вместимость и увеличиваем вместимость
     * @param minCapacity - минимальная вместимость массива
     * @param newSize - запрашиваемый размер
     */
    private void ensureCapacity(int minCapacity, int newSize){
        if(minCapacity * DEFAULT_LOAD_FACTOR <= newSize){
            //если близко переполнение, создаем новый массив
            createNewArrayInternal(newSize);
            //Item[] newList = (Item[]) new Comparable[minCapacity + DEFAULT_CAPACITY];
            //копируем содержимое текущего массива в новый массив
            //copyArrayInternal(0, newSize, newList);

            //присваиваем переменной массива ссылку на новый массив
            //list = newList;

            //TODO временно
            System.out.println("new list.length: " + list.length);
        }
    }

    /**
     * Внутренний метод копирует содержимое текущего массива в новый массив
     * @param minCapacity - требуемая минимальная вместимость массива
     */
    private void createNewArrayInternal(int minCapacity){
        Item[] newList = (Item[]) new Comparable[minCapacity + DEFAULT_CAPACITY];
        //копируем содержимое текущего массива в новый массив
        copyArrayInternal(0, minCapacity, newList);
        //присваиваем переменной массива ссылку на новый массив
        list = newList;
    }

    /**
     * Внутренний метод копирует содержимое текущего массива в новый массив
     * @param startIndex - начальный индекс диапазона
     * @param bound - размер диапазона
     * @param newList - временный новый массив
     * //@return заполненный массив
     */
    private void copyArrayInternal(int startIndex, int bound, Item[] newList){
        //в цикле копируем содержимое текущего массива в новый массив
        for (int i = startIndex; i < bound; i++) {
            newList[i] = list[i];
        }
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        Item key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];

            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        bubbleSort(Comparator.naturalOrder());
//        boolean isSwap;
//        for (int i = size - 1; i > 0; i--) {
//            isSwap = false;
//            for (int j = 0; j < i; j++) {
//                if (less(list[j + 1], list[j])) {
//                    swap(j + 1, j);
//                    isSwap = true;
//                }
//            }
//            if (!isSwap) {
////                System.out.println(i);
//                break;
//            }
//        }
    }

    private void bubbleSort(Comparator comparator) {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
//                if (less(list[j + 1], list[j])) {
                if (comparator.compare(list[j + 1], list[j]) < 0) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if (!isSwap) {
//                System.out.println(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += list[i] + " ";
        }
        return s;
    }

}

