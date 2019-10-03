package lesson3.hw.task1a;

import java.util.EmptyStackException;

public class MyStack<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Object[capacity];
    }

    MyStack() {
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

}
