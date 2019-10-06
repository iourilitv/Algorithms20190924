package lesson4.hw.task3;

import lesson4.hw.task1.MyLinkedList;

public class MyLinkedQueue<Item> {
    private MyLinkedList<Item> queue = new MyLinkedList<>();

    //добавляет элемент в конец очереди
    public void insert(Item item){
        queue.insertLast(item);
    }

    //удаляет и возвращает элемент из начала очереди
    public Item remove(){
        return queue.removeFirst();
    }

    //возвращает элемент из начала очереди
    public Item peek(){
        return queue.getFirst();
    }

    //возвращает true, если очередь пустая
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    //возвращает размер очереди
    public int size(){
        return queue.size();
    }

    @Override
    public String toString(){
        return queue.toString();
    }
}
