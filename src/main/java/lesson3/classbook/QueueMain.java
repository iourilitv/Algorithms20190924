package lesson3.classbook;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Практический пример очереди.
 * Циклический перенос.
 * Начало и конец очереди помечается маркерами rear и front. При вставке нового элемента остальные
 * остаются на своих местах, а двигается только маркер rear. При удалении элемента - front.
 * Программа реализует очередь. Класс Queue содержит методы вставки, удаления и получения
 * элемента очереди, а также проверку на ее пустоту, переполнение и размер. Создается очередь из
 * десяти ячеек. Сначала заполняются пять из них, потом две удаляются и добавляются еще четыре.
 * В нашей реализации методы insert и delete могут привести к исключительной ситуации, поэтому их
 * необходимо обернуть в конструкцию if и проверить на полноту или пустоту.
 * Эффективность очередей: вставка — O(1), удаление — O(1).
 */
public class QueueMain{
    public static void main ( String [] args ){
        Queue q = new Queue ( 5 );
        q . insert ( 10 );
        q . insert ( 20 );
        q . insert ( 30 );
        q . insert ( 40 );
        q . insert ( 50 );
        q . remove ();
        q . remove ();
        q . insert ( 50 );
        q . insert ( 60 );
        q . insert ( 70 );
        q . insert ( 80 );
        while ( ! q . isEmpty () ){
            int n = q . remove ();
            System . out . println ( n );
        }
    }
}

class Queue {
    private int maxSize;
    private int [] queue;
    private int front;//маркер начала очереди
    private int rear;//маркер конца
    private int items;//количество элементов в очереди

    public Queue ( int s ){
        maxSize = s;
        queue = new int [ maxSize ];
        front = 0;
        rear = - 1;
        items = 0;
    }

    //добавление элемента
    public void insert ( int i ){
        if ( rear == maxSize - 1 )
            rear = - 1;
        queue [++ rear ] = i;
        items ++;
    }

    //удаление элемента
    public int remove (){
        int temp = queue [ front ++];
        if ( front == maxSize )
            front = 0;
        items --;
        return temp;
    }

    //получение элемента
    public int peek (){
        return queue [ front ];
    }

    //проверка на пустоту очереди
    public boolean isEmpty (){
        return ( items == 0 );
    }

    //проверка на переполнение.
    public boolean isFull (){
        return ( items == maxSize );
    }

    //возвращает размер очереди.
    public int size (){
        return items;
    }


}
