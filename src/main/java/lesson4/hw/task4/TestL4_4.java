package lesson4.hw.task4;

import lesson4.hw.task1.MyLinkedList;

import java.util.Iterator;
import java.util.ListIterator;

class TestL4_4 {
    MyLinkedList<String> mll = new MyLinkedList<>();

    void run(){
        //Test1. Тест итератора. Добавляем элементы в начало связанного списка
        test1();//OK
        //After Test1. Some elements have been added in the first. List length: 3
        //Lyba Maria Katia

        //Test6. Тест итератора. Выводим элементы связанного списка
        //test6();//
        //

        //Test7. Тест итератора. Удаляем элементы, начинающиеся на "V" из связанного списка
        //с помощью цикла while
        //test7();//
        //

    }
    //Test1. Тест итератора. Добавляем элементы в начало связанного списка
    private void test1(){
        System.out.println("***Test1. Trying to added first before current elements...***");
        ListIterator lIter = mll.listIterator();
        lIter.add("Katia");
        lIter.add("Maria");
        lIter.add("Lyba");
        System.out.println("After Test1. Some elements have been added in the first. List length: " + mll.size());
        while (lIter.hasNext()){
            System.out.print(lIter.next() + " ");
        }
        System.out.println();
    }

    //Test6. Тест итератора. Выводим элементы связанного списка
    /*private void test6(){
        ListIterator lIter = mll.listIterator();
        System.out.println("\n***Test6. Trying to test iterator...***");
        System.out.println("***Test6.1. Using foreach...***");
        for (String s : mll) {
            //здесь s - текущий элемент!
            System.out.print(s + " " + lIter.hasNext() + ", ");
        }
        System.out.println();
        System.out.println("\n***Test6.2. Using while...***");
        while (lIter.hasNext()){
            System.out.print(lIter.next() + " " + lIter.hasNext() + ", ");
        }
        System.out.println();
    }*/

    //Test7. Тест итератора. Удаляем элемент, начинающийся на "M" из связанного списка
    //с помощью цикла while
    /*private void test7(){
        ListIterator lIter = mll.listIterator();
        System.out.println("\n***Test7. Trying to test iterator Using while...***");
        String str = "";
        while (lIter.hasNext()){
            str = (String)lIter.next();
            if(str.startsWith("M")){
                lIter.remove();//удаляет текущий элемент, если он начинается с V
                System.out.println("After Test7. The element " + str + " have been removed");
                break;
            }
        }
        for (String s : mll) {
            System.out.print(s + " ");
        }
        System.out.println();
    }*/


}
