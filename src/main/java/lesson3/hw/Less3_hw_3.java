package lesson3.hw;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Домашняя работа.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека.
 */
public class Less3_hw_3 {
    public static void main(String[] args) {
        int size = 5;
        MyDEK<Integer> myDEK = new MyDEK<>(5);

        for (int i = 0; i < size; i++) {
            //myDEK.insert(i);
        }

        //System.out.println("\nAfter inserting #1: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
        //

        for (int i = 0; i < size; i++) {
            //myDEK.insert(i);
        }

        //System.out.println("\nAfter inserting #2: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
        //

        System.out.println("\nTrying to remove...");
        for (int i = 0; i < 5; i++) {
            System.out.print(myDEK.removeLeft() + " ");
        }
        //

        //System.out.println("\nAfter removing #1: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
        //

    }
}

class MyDEK<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    public MyDEK(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyDEK() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    //добавляем элемент в конец очереди(справа)
    public void insertRight(Item item) {
        if (isFull()) {
            //TODO Added.
            reCapacity(size + DEFAULT_CAPACITY);
            //throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextRightIndex(end);
    }

    //добавляем элемент в начало очереди(слева)
    public void insertLeft(Item item) {
        if (isFull()) {
            //TODO Added.
            reCapacity(size + DEFAULT_CAPACITY);
            //throw new StackOverflowError();
        }
        size--;
        list[begin] = item;
        begin = nextLeftIndex(begin);
    }

    //удаляем элемент в начале очереди(слева)
    public Item removeLeft() {
        Item value = peekLeft();
        size--;
        list[begin] = null;
        begin = nextRightIndex(begin);
        return value;
    }

    //удаляем элемент в конце очереди(справа)
    public Item removeRight() {
        Item value = peekRight(); //peekLeft();//peekFront();

        //TODO Deleted
        //size--;

        list[end] = null;
        end = nextLeftIndex(end);
        return value;
    }

    //читаем элемент в начале очереди(слева)
    private Item peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }


    //читаем элемент в конце очереди(справа)
    private Item peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[end];
    }

    //сдвигаем индекс на следующий элемент справа
    private int nextRightIndex(int index) {
        return (index + 1) % list.length;
    }

    //сдвигаем индекс на следующий элемент слева
    private int nextLeftIndex(int index) {
        return (index - 1) % list.length;
    }

    //возвращает длину очереди - ноль, если нет элементов, или положительное, если не ноль
    //при не нулевой очереди всегда end != begin
    private int queueLength() {
        //если индексы начала и конца не равны
        if(end != begin){
            //если есть, возвращаем количество элементов в очереди
            return end > begin ? end - begin + 1: list.length - begin + end + 1;//e2 b5 = 8 (10 - 5 + 2 + 1)
        } else {//если равны
            //если они указывают на не нулевые элементы
            if (list[begin] != null && list[end] != null) {
                //значит в очереди один элемент
                return 1;
            } else {
                //если какой-то элемент нулевой, значит в очереди никого нет
                return 0;

                //если какой-то элемент нулевой выбрасываем исключение//TODO удалить
                //throw new NullPointerException("There is a null element in the queue!"); //EmptyStackException();
            }
        }
    }

    //FIXME Delete
    /*public int size() {
        return size;
    }*/

    //проверяем не пустой ли массив. Да - длина очереди равна нулю
    public boolean isEmpty() {
        return queueLength() == 0;
    }

    //проверяем полностью ли заполнен массив. да - длина очереди равна длине массива
    public boolean isFull() {
        return queueLength() == list.length;
    }

    //увеличивает массив при полном его заполнении(создает новую копию большего размера)
    private void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        //FIXME привязать к begin и end

        if(begin < end){
            System.arraycopy(list, begin, tempArr, begin + DEFAULT_CAPACITY / 2, queueLength());
        } else if(end < begin){
            //System.arraycopy(list, 0, tempArr, begin + DEFAULT_CAPACITY / 2, queueLength());//FIXME
        }
        //System.arraycopy(list,0, tempArr,0, size);
        list = tempArr;
    }

    public Item[] getList() {
        return list;
    }
}
