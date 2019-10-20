package lesson8.classbook.linear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 8. Хеш-таблицы
 * Быстрый поиск и вставка с помощью хеш-таблиц.
 * Рассмотрим метод хеширования открытая адресация c Линейным пробированием.
 * Метод линейного пробирования заключается в последовательном поиске свободной ячейки. Если
 * ячейка, которая была рассчитана с помощью хеш-функции, занята, выбирается следующая. Если и
 * она занята, переходим к последующей. И так далее, пока не будет обнаружена свободная.
 */
public class HashAppL {
    public static void main ( String [] args ) throws IOException{
        Item aDataItem ;
        int aKey , size , n , keysPerCell;

        //TODO Correction.Deleted
//        System . out . print ( "Enter size of hash table: " );
//        size = getInt ();
//        System . out . print ( "Enter initial number of items: " );
//        n = getInt ();
        //TODO Correction.Added
        //Ввод размеров
        do{
            System . out . print ( "Enter size of hash table: " );
            size = getInt ();
        }
        while(size <= 0);
        do{
            System . out . print ( "Enter initial number of items(less than size * 0.6): " );
            n = getInt ();
        }
        while(!isItemsNumberCorrect(size, n));
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

                    //TODO Correction.Added
                    if(theHashTable.isFull()){
                        System.out.println("The HashTable is full!");
                        break;
                    }

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

    //TODO Correction.Added
    private static boolean isItemsNumberCorrect(int size, int n) {
        return n > 0 && n < size * 0.6;
    }

    //TODO Correction.Deleted
    /*public static String getString () throws IOException {
        InputStreamReader isr = new InputStreamReader ( System . in );
        BufferedReader br = new BufferedReader ( isr );
        String s = br . readLine ();
        return s;
    }*/
    //TODO Correction.Added
    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (isr);
        return br.readLine ();
    }

    private static char getChar() throws IOException{
        String s = getString ();
        return s . charAt ( 0 );
    }

    private static int getInt () throws IOException{
        String s = getString ();
        return Integer . parseInt ( s );
    }


}
