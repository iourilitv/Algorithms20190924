package lesson3.classbook;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Примеры стека.
 * Добавлять и удалять элементы будем с левой стороны стека.
 * Стек не является сложной структурой данных, все его методы связаны только с одним элементом,
 * который находится на его вершине ( top ).
 * В классе специально были созданы методы i sEmpty и i sFull, чтобы перенести ответственность за
 * проверку стека на пользователя, а не вносить их в методы push и pop.
 * Эффективность всех операций — O(1).
 */
public class StackMain {
    public static void main(String[] args) {
        new Stack(10);
    }
}

class Stack {
    private int maxSize;//значение максимального размера стека.
    private int [] stack;
    private int top;//вершина стека(последний не нулевой элемент)

    public Stack ( int size ){
        this . maxSize = size;
        this . stack = new int [ this . maxSize ];
        this . top = - 1;//стек пустой
    }

    //Метод добавления элемента в конец стека
    public void push ( int i ){
        //Префиксная форма инкремента сначала прибавляет к полю t op единицу, а уже потом с новым
        //индексом присваивает элементу стека значение
        this . stack [++ this . top ] = i;
    }

    //Метод удаления элемента из конца стека(значение top)
    public int pop (){
        return this . stack [ this . top --];
    }

    //Метод получения элемента стека, который находится в позиции top
    public int peek () {
        return this . stack [ this . top ];
    }

    //Метод проверки стека на пустоту
    public boolean isEmpty (){
        return ( this . top == - 1 );
    }

    //Метод проверки стека на переполненность
    public boolean isFull (){
        return ( this . top == this . maxSize - 1 );
    }

}
