package lesson3.classbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
public class JavaStack {
    /**
     * @param args the command line arguments
     */
    public static void main ( String [] args ) throws IOException {
        String input;
        while ( true ) {
            input = getString ();
            if ( input . equals ( "" )) break;
            Bracket br = new Bracket ( input );
            br . check ();
        }
    }
    public static String getString () throws IOException{
        InputStreamReader isr = new InputStreamReader ( System . in );
        BufferedReader br = new BufferedReader ( isr );
        return br . readLine ();
    }
}

//f(i = 0) {sE.push((char) (i + 65));System.out.print(sE.getStackArr()[sE.getTop()]);}""