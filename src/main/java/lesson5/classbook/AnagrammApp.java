package lesson5.classbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Урок 5. Рекурсия.
 * Листинг программы по построению анаграмм только для слов из 3 букв.
 */
public class AnagrammApp {
    static int size;
    static int count;
    static char [] arr = new char [ 3 ];

    public static void main ( String [] args ) throws IOException{
        String input = getString ();
        size = input . length ();
        count = 0;
        for ( int i = 0 ; i < size ; i ++){
            arr [ i ] = input . charAt ( i );
        }
        getAnagramm ( size );
    }

    //рекурсивный метод получения анаграм
    public static void getAnagramm ( int newSize ){
        if ( newSize == 1)
            return;
        for ( int i = 0 ; i < newSize ; i ++){
            getAnagramm ( newSize - 1 );
            if ( newSize == 2)
                display ();
            rotate ( newSize );
        }
    }

    //Метод осуществляет циклический сдвиг на одну позицию влево для каждой буквы слова.
    public static void rotate ( int newSize ){
        int i;
        int pos = size - newSize;
        char temp = arr [ pos ];
        for ( i = pos + 1 ; i < size ; i ++){
            arr [ i - 1 ] = arr [ i ];
        }
        arr [ i - 1 ] = temp;
    }

    //Метод выводит на экран полученную анаграмму.
    public static void display (){
        for ( int i = 0 ; i < size ; i ++){
            System . out . print ( arr [ i ]);
        }
        System . out . println ( "" );
    }

    //Метод принимает строку в консоль
    public static String getString () throws IOException {
        InputStreamReader isr = new InputStreamReader ( System . in );
        BufferedReader br = new BufferedReader ( isr );
        return br . readLine ();
    }
}
