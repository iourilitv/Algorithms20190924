package lesson3.hw;

import java.util.EmptyStackException;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Домашняя работа.
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 *  a) Добавить в стек увеличение массива при переполнении стека.
 *  б) Добавить в приоритетную очередь оптимизацию при поиске в отсортированном массиве.
 * 2. Создать программу, которая переворачивает вводимые строки (читает справа налево).
 * 3. Создать класс для реализации дека.
 */
public class Less3_hw_1a {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }
    }


    //TODO Task 3a. Добавление увеличения массива при переполнении.

}

class MyStack<Item> {
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
            throw new StackOverflowError();
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
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
    }
}
