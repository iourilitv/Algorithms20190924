package lesson3.hw.task3;

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
        new Test3().run();
    }
}

class MyDEK<Item> {
    private Item[] list;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDEK(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("bad size " + capacity);
        }
        list = (Item[]) new Object[capacity];
        initDEK();
    }

    public MyDEK() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
        initDEK();
    }

    //Устанавливаем начальные значения индексов начала и конца очереди
    private void initDEK(){
        begin = list.length / 2;
        end = begin;
    }

    //добавляем элемент в конец очереди(справа при нормальном порядке)
    public void insertRight(Item item) {
        if (isFull()) {
            //если массив заполнен полностью, увеличиваем его
            reCapacity(queueLength() + DEFAULT_CAPACITY);
        }
        //сдвигаем хвост очереди наружу, кроме случая если очередь пустая
        if(!isEmpty()){
            end = shiftEndOutward();
        }
        list[end] = item;
    }

    //добавляем элемент в начало очереди(слева при нормальном порядке)
    public void insertLeft(Item item) {
        if (isFull()) {
            reCapacity(queueLength() + DEFAULT_CAPACITY);
        }
        //сдвигаем голову очереди наружу, кроме случая если очередь пустая
        if(!isEmpty()){
            begin = shiftBeginOutward();
        }
        list[begin] = item;
    }

    //удаляем элемент из начала очереди(левый при нормальном порядке)
    public Item removeLeft() {
        //запоимнаем элемент в начале очереди
        Item value = peekLeft();
        //обнуляем ссылку на объект в ячейке элемента
        list[begin] = null;
        //сдвигаем начало внутрь
        begin = shiftBeginInward();
        return value;
    }

    //удаляем элемент из конца очереди(правый при нормальном порядке)
    public Item removeRight() {
        Item value = peekRight();
        list[end] = null;
        end = shiftEndInward();
        return value;
    }

    //читаем элемент в начале очереди(левый при нормальном порядке)
    public Item peekLeft() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }


    //читаем элемент в конце очереди(правый при нормальном порядке)
    public Item peekRight() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[end];
    }

    //сдвигаем индекс на следующий элемент справа
    private int nextRightIndex(int index) {
        return (index + 1) % list.length;
    }

    //сдвигаем индекс на следующий элемент слева, если не ноль и сдвигаем на конец массива, если ноль
    private int nextLeftIndex(int index) {
        return index != 0 ? index - 1 : list.length - 1;
    }

    //сдвигает начало очереди наружу в зависимости от порядка
    private int shiftBeginOutward(){
        return isOrder() ? nextLeftIndex(begin) : nextRightIndex(begin);
    }

    //сдвигает конец очереди наружу в зависимости от порядка
    private int shiftEndOutward(){
        return isOrder() ? nextRightIndex(end) : nextLeftIndex(end);
    }


    //сдвигает начало очереди внутрь  в зависимости от порядка
    private int shiftBeginInward(){
        return isOrder() ? nextRightIndex(begin) : nextLeftIndex(begin);
    }

    //сдвигает конец очереди внутрь в зависимости от порядка
    private int shiftEndInward(){
        return isOrder() ? nextLeftIndex(end) : nextRightIndex(end);
    }

    //возвращает длину очереди - ноль, если нет элементов, или положительное, если не ноль
    //при не нулевой очереди всегда end != begin
    private int queueLength() {
        //если индексы начала и конца не равны
        if(end != begin){
            //если есть, возвращаем количество элементов в очереди
            return isOrder() ? end - begin + 1: list.length - begin + end + 1;//e2 b5 = 8 (10 - 5 + 2 + 1)
        } else {//если равны
            //если они указывают на не нулевые элементы
            if (list[begin] != null && list[end] != null) {
            //if (peekLeft() != null && peekRight() != null) {//TODO удалить
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

    //проверяем не пустой ли массив. Да - длина очереди равна нулю
    public boolean isEmpty() {
        return queueLength() == 0;
    }

    //проверяем полностью ли заполнен массив. да - длина очереди равна длине массива
    public boolean isFull() {
        return queueLength() == list.length;
    }

    //определяем какой порядок расположения.
    // Прямой порядок(true) - если конец очереди справа от начала или их индексы равны
    private boolean isOrder(){
        return end >= begin;
    }

    //увеличивает массив при полном его заполнении(создает новую копию большего размера)
    private void reCapacity(int newCapacity){
        Item[] tempArr = (Item[]) new Object[newCapacity];
        //если порядок в очереди прямой или длина очереди 1
        if(isOrder()){
            System.arraycopy(list, begin, tempArr, begin + DEFAULT_CAPACITY / 2, queueLength());
        } else {//если порядок очереди обратный
            //копируем левый кусок
            System.arraycopy(list, 0, tempArr, DEFAULT_CAPACITY / 2, end + 1);
            //копируем правый кусок
            System.arraycopy(list, begin, tempArr, begin + DEFAULT_CAPACITY / 2, list.length - begin + 1);
        }
        list = tempArr;
    }

    public Item[] getList() {
        return list;
    }

    //возвращает размер массива
    public int size() {
        return list.length;
    }

    public int getQueueLength() {
        return queueLength();
    }
}
