package lesson3.hw;

import java.util.EmptyStackException;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Домашняя работа.
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 *  б) Добавить в приоритетную очередь оптимизацию при поиске в отсортированном массиве.
 */
public class Less3_hw_1b {
    public static void main(String[] args) {
        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>();
        mpq.insert(7);
        System.out.println(mpq);
        mpq.insert(3);
        System.out.println(mpq);
        mpq.insert(4);
        System.out.println(mpq);
        mpq.insert(2);
        System.out.println(mpq);
        System.out.println(mpq.remove());
        System.out.println(mpq);
    }
}

class MyPriorityQueue<Item extends Comparable> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyPriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Comparable[capacity];
    }

    public MyPriorityQueue() {
        list = (Item[]) new Comparable[DEFAULT_CAPACITY];
    }

    //TODO Task 3a. Добавление оптимизации при поиске в отсортированном массиве.
    public void insert(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        //TODO Added.
        int sortedMinIndex = -1;
        int sortedMaxIndex = size + 1;

        list[size] = item;
        size++;
        int i = size - 1;

        while (i > 0 && list[i].compareTo(list[i - 1]) < 0) {//(list[i]/*правый меньше*/ - list[i - 1]) < 0

            //если проверяемый элемент больше индекса максимального элемента в сортированной части на 1
            if(0 <= list[i].compareTo(list[sortedMaxIndex]) && list[i].compareTo(list[sortedMaxIndex]) <= 1){
                sortedMaxIndex = i;
                break;
            }else{
                swap(i, i - 1);
            }
            i--;
        }
    }

    public Item remove() {
        Item temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    private Item peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity(int newCapacity) {
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(list, 0, tempArr, 0, size);
        list = tempArr;
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