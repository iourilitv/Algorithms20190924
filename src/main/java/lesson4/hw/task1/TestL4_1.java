package lesson4.hw.task1;

import java.util.Iterator;
import java.util.Random;

class TestL4_1 {
    int size = 8;
    int count;
    private Random random = new Random();
    MyLinkedList<String> mll = new MyLinkedList<>();

    void run(){
        //Test1. Добавляем элементы в начало связанного списка
        test1();//OK
        //After Test1. Some elements have been inserted in the first: array length: 3
        //Lyba, Maria, Katia,

        //Test2. Добавляем элемент в конец связанного списка
        test2();//OK
        //After Test2. The last element have been removed: array length: 4
        //Lyba, Maria, Katia, Petia,

        //Test3. Удаляем элемент из начала связанного списка
        test3();//OK
        //Lyba
        //After Test3. The first element have been removed: array length: 3
        //Maria, Katia, Petia,

        //Test4. Удаляем элемент из конца связанного списка
        test4();//OK
        //Petia
        //After Test4. The last element have been removed: array length: 2
        //Maria, Katia,

        //Test5. Добавляем элементы в начало связанного списка
        test5();//OK
        //After Test5. The element have been inserted in the place with 1 index: array length: 3
        //Maria, Vasia, Katia,

        //Test6. Тест итератора. Выводим элементы связанного списка
        test6();//OK
        //Maria Vasia Katia
    }

    //Test1. Добавляем элементы в начало связанного списка
    private void test1(){
        System.out.println("***Test1. Trying to insert first...***");
        mll.insertFirst("Katia");
        mll.insertFirst("Maria");
        mll.insertFirst("Lyba");
        System.out.println("After Test1. Some elements have been inserted in the first: array length: " + mll.size());
        System.out.println(mll);
    }

    //Test2. Добавляем элемент в конец связанного списка
    private void test2(){
        System.out.println("\n***Test2. Trying to insert last...***");
        mll.insertLast("Petia");
        System.out.println("After Test2. The last element have been removed: array length: " + mll.size());
        System.out.println(mll);

    }

    //Test3. Удаляем элемент из начала связанного списка
    private void test3() {
        System.out.println("\n***Test3. Trying to remove the first element...***");
        System.out.println(mll.removeFirst());
        System.out.println("After Test3. The first element have been removed: array length: " + mll.size());
        System.out.println(mll);
    }

    //Test4. Удаляем элемент из конца связанного списка
    private void test4() {
        System.out.println("\n***Test4. Trying to remove the last element...***");
        System.out.println(mll.removeLast());
        System.out.println("After Test4. The last element have been removed: array length: " + mll.size());
        System.out.println(mll);
    }

    //Test5. Добавляем элементы в начало связанного списка
    private void test5(){
        int index = 1;
        System.out.println("\n***Test5. Trying to insert in indexed place...***");
        mll.insert("Vasia", 1);
        System.out.println("After Test5. The element have been inserted in the place with " +
                index + " index: array length: " + mll.size());
        System.out.println(mll);
    }

    //Test6. Тест итератора. Выводим элементы связанного списка
    private void test6(){
        int index = 1;
        System.out.println("\n***Test6. Trying to test iterator...***");
        Iterator<String> iterator = mll.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }


}
