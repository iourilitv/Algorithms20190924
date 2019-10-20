package lesson8.classbook.linear2h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 8. Хеш-таблицы
 * Быстрый поиск и вставка с помощью хеш-таблиц.
 * Рассмотрим метод хеширования открытая адресация c Двойным хешированием.
 * Для устранения проблем, связанных с первичной и вторичной группировкой, используется метод
 * двойного хеширования. Создаются две хеш-функции, которые будут генерировать разную
 * последовательность для ключей, хешируемых в один и тот же индекс.
 * Такая задача решается за счет повторного хеширования ключа другой хеш-функцией. Она не должна
 * совпадать с первой функцией, а ее результат никогда не должен быть равен 0. Опыт и время
 * показали, что для этого хорошо подходит функция такого типа:
 * смещение = константа − (ключ % константа)
 * где константа — простое число, которое меньше размера массива.
 */
public class HashAppL2H {
    public static void main ( String [] args ) throws IOException {
        Item aDataItem ;
        int aKey , size , n , keysPerCell;

        // Ввод размеров
        System . out . print ( "Enter size of hash table: " );
        size = getInt ();
        System . out . print ( "Enter initial number of items: " );
        n = getInt ();
        keysPerCell = 10;

        // Создание таблицы
        HashTable theHashTable = new HashTable ( size );
        for ( int j = 0 ; j < n ; j ++){
            aKey = ( int )( java . lang . Math . random () * keysPerCell * size );
            aDataItem = new Item ( aKey );
            theHashTable . insert ( aDataItem );
        }
        while ( true ){
            System . out . print ( "Enter first letter of " );
            System . out . print ( "show, insert, delete, or find: " );
            char choice = getChar ();
            switch ( choice ){
                case 's':
                    theHashTable . display ();
                    break;
                case 'i':
                    System . out . print ( "Enter key value to insert: " );
                    aKey = getInt ();
                    aDataItem = new Item ( aKey );
                    theHashTable . insert ( aDataItem );
                    break ;
                case 'd' :
                    System . out . print ( "Enter key value to delete: " );
                    aKey = getInt ();
                    theHashTable . delete ( aKey );
                    break ;
                case 'f' :
                    System . out . print ( "Enter key value to find: " );
                    aKey = getInt ();
                    aDataItem = theHashTable . find ( aKey );
                    if ( aDataItem != null ){
                        System . out . println ( "Found " + aKey );
                    } else
                        System . out . println ( "Could not find " + aKey );
                    break;
                default:
                    System . out . print ( "Invalid entry\n" );
            }
        }
    }

    private static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader( System . in );
        BufferedReader br = new BufferedReader ( isr );
        String s = br . readLine ();
        return s;
    }

    private static char getChar() throws IOException{
        String s = getString ();
        return s . charAt ( 0 );
    }
    private static int getInt() throws IOException{
        String s = getString ();
        return Integer . parseInt ( s );
    }
}
