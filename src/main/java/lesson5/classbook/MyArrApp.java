package lesson5.classbook;

/**
 * Урок 5. Рекурсия.
 * Листинг программы Рекурсивный двоичный поиск.
 * Допустим, наш отсортированный массив содержит 10 элементов
 * [-10, 20, 25, 26, 40, 45, 75, 80, 82, 91].
 * Ищем элемент, равный 25. Он находится в третьей позиции.
 */
public class MyArrApp {
    public static void main ( String [] args ) {
        MyArr arr = new MyArr ( 10 );
        arr . insert (- 10 );
        arr . insert ( 45 );
        arr . insert ( 26 );
        arr . insert ( 20 );
        arr . insert ( 25 );
        arr . insert ( 40 );
        arr . insert ( 75 );
        arr . insert ( 80 );
        arr . insert ( 82 );
        arr . insert ( 91 );

        int search = - 10;
        System . out . println ( arr . binaryFind ( search ));
    }
}
