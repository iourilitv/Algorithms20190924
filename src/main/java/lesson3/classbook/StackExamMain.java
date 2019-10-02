package lesson3.classbook;

import java.util.Arrays;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Практический пример стека.
 * Представим, что мы пишем I DE для языка Java, и в этой среде разработки необходимо проверять код
 * программы на правильность написания скобок.
 * Задача нашей программы — проверить соответствие открывающих и закрывающих круглых,
 * фигурных и квадратных скобок в представленном методе. Каждая открывающаяся скобка должна
 * иметь пару. Если это соответствие нарушено, программа должна выводить на экран ошибку.
 * Здесь реализован класс StackExam , который содержит методы по добавлению и удалению элемента
 * стека. Класс Bracket содержит метод проверки строки на соответствие скобок. В пользовательском
 * классе JavaStack создан метод getString() , который принимает строку, введенную с клавиатуры.
 */
public class StackExamMain {
    public static void main(String[] args) {
        int size = 10;
        StackExam sE = new StackExam(size);

        for (int i = 0; i < size; i++) {
            sE.push((char) (i + 65));
            System.out.print(sE.getStackArr()[sE.getTop()] + " ");
        }

        System.out.println("\nAfter push: " + Arrays.toString(sE.getStackArr()));

        for (int i = 0; i < size; i++) {
            System.out.print(sE.pop() + " ");
        }

        System.out.println("\nAfter pop: " + Arrays.toString(sE.getStackArr()));
    }
}

class StackExam {
    private static final char NULL = '\u0000';//0x0000; тоже работает
    private int maxSize;
    private char [] stackArr;
    private int top;

    public StackExam ( int size ){
        this . maxSize = size;
        this . stackArr = new char [ size ];
        this . top = - 1;
    }
    public void push ( char i ){
        stackArr [++ top ] = i;
    }

    /**
     * Метод удаления из стека
     * //TODO Ошибка в методичке! Остаются старые ссылки в массиве!
     * After pop: [A, B, C, D, E, F, G, H, I, J]//Ошибка!
     * After pop: [ ,  ,  ,  ,  ,  ,  ,  ,  ,  ]//Правильно.
     * @return
     */
    //TODO deleted.
    public char pop (){
        return stackArr [ top --];
    }
    //TODO added.
    /*public char pop (){
        char temp = stackArr [top];
        stackArr [top] = NULL;
        top--;
        return temp;
    }*/

    public boolean isEmpty (){
        return ( top == - 1 );
    }

    public char[] getStackArr() {
        return stackArr;
    }

    public int getTop() {
        return top;
    }
}


