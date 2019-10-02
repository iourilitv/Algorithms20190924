package lesson3.classbook;

import java.io.IOException;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Практический пример приоритетной очереди.
 * Приоритетная очередь похожа на обычную. У нее есть начало и конец, элементы извлекаются из
 * начала очереди, а вот попадают в нее немного по-другому. Данные, которые находятся в
 * приоритетной очереди, упорядочены по ключу. В начале очереди находится элемент, у которого ключ
 * имеет минимальное значение — иначе говоря, наивысший приоритет. Когда происходит вставка
 * нового элемента, он занимает позицию согласно своему ключу, чтобы не нарушить сортировку.
 * Эффективность приоритетных очередей:
 * ● Вставка — O(N);
 * ● Удаление — O(1).
 */
public class PriorityQApp{
    public static void main ( String [] args ) throws IOException {
        PriorityQueue q = new PriorityQueue ( 5 );
        q . insert ( 30 );
        q . insert ( 50 );
        q . insert ( 10 );
        q . insert ( 40 );
        q . insert ( 20 );
        while ( ! q . isEmpty () )
        {
            int item = q . remove ();
            System . out . print ( item + " " );
        }
        System . out . println ( "" );
    }
}
class PriorityQueue{
    private int maxSize;//размер массива
    private int [] queueArray;
    private int items;//длина очереди

    public PriorityQueue ( int i ){
        maxSize = i;
        queueArray = new int [ maxSize ];
        items = 0;
    }

    //Метод вставки элемента в соответствии с значением его приоритета.
    public void insert ( int item ){
        int i;
        if ( items == 0 )//тоже что и isEmpty()
            queueArray [ items ++] = item;
        else{
            for ( i = items - 1 ; i >= 0 ; i --){
                if ( item > queueArray [ i ] )
                    queueArray [ i + 1 ] = queueArray [ i ];
                else
                    break;
            }
            queueArray [ i + 1 ] = item ; // Вставка элемента
            items ++;
        }
    }

    public int remove (){
        return queueArray [-- items ];
    }

    //TODO удаляет самый правый элемент в очереди(с минимальным значением приоритета - наивысший)?
    public long peek (){
        return queueArray [ items - 1 ];
    }

    public boolean isEmpty (){
        return ( items == 0 );
    }

    public boolean isFull (){
        return ( items == maxSize );
    }
}
