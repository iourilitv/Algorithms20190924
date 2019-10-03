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
 */
public class Less3_hw_2 {
    public static void main(String[] args) {
        int size = 5;
        MyStack<Integer> stack = new MyStack<>(5);

        for (int i = 0; i < size; i++) {
            stack.push((i));
        }

        System.out.println("\nAfter pushing #1: array length: " + stack.size());
        System.out.println(Arrays.toString(stack.getList()));
        //

        for (int i = 0; i < size; i++) {
            stack.push((i));
        }

        System.out.println("\nAfter pushing #2: array length: " + stack.size());
        System.out.println(Arrays.toString(stack.getList()));
        //

        System.out.println("\nTrying to pop...");
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }
        //

        System.out.println("\nAfter popping #1: array length: " + stack.size());
        System.out.println(Arrays.toString(stack.getList()));
        //

    }
}

/*class MyStack<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    public MyStack() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    //TODO Task 3a. Добавление увеличения массива при переполнении.
    public void push(Item item) {
        if (isFull()) {
            //TODO Added.
            reCapacity(size + DEFAULT_CAPACITY);
            //TODO Deleted.
            //throw new StackOverflowError();
        }
        list[size] = item;
        size++;
    }

    public Item pop() {
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

    private void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        System.arraycopy(list,0, tempArr,0, size);
        list = tempArr;
    }

    public Item[] getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + " ");
        }
        return sb.toString();
    }

}*/
