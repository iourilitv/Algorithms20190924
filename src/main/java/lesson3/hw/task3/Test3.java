package lesson3.hw.task3;

import java.util.Arrays;

public class Test3 {
    int size = 8;
    int count = 1;
    MyDEK<Integer> myDEK = new MyDEK<>(size);

    void run(){
        //Test1. Добавляем элементы в начало очереди(слева при нормальном порядке)
        test1();//OK
        //1 2
        //After Test1. Inserting left: array length: 8
        //[null, null, null, 2, 1, null, null, null]

        //Test2. Добавляем элементы в конец очереди(справа при нормальном порядке)
        test2();//OK
        //3
        //After Test2. Inserting right: array length: 8
        //[null, null, null, 2, 1, 3, null, null]

        //Test3. Удаляем элементы из конца очереди(справа при нормальном порядке)
        test3();//OK
        //3
        //After Test3. Removing right: array length: 8
        //[null, null, null, 2, 1, null, null, null]

        //Test4. Удаляем элементы из начала очереди(слева при нормальном порядке)
        test4();//OK
        //2
        //After Test4. Removing left: array length: 8
        //[null, null, null, null, 1, null, null, null]

        //Test5. Добавляем элементы в начало очереди(слева при нормальном порядке) с зацикливанием
        test5();//
        //

        //Test6. Удаляем элементы из начала очереди(слева при обратном порядке) без зацикливания
        test6();//
        //

        //Test7. Удаляем элементы из конца очереди(справа при обратном порядке) без зацикливания
        test7();//
        //

        //Test8. Добавляем элементы в конец очереди(справа при обратном порядке) с зацикливанием
        test8();//
        //


    }

    //Test1. Добавляем элементы в начало очереди(слева при нормальном порядке)
    void test1(){
        System.out.println("***Test1. Trying to insert left in right order without looping...***");
        for (int i = 0; i < 2; i++) {
            myDEK.insertLeft(count++);
            System.out.print(myDEK.peekLeft() + " ");
        }
        System.out.println("\nAfter Test1. Inserting left: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test2. Добавляем элементы в конец очереди(справа при нормальном порядке)
    void test2(){
        System.out.println("***\nTest2. Trying to insert right in right order without looping...***");
        for (int i = 0; i < 1; i++) {
            myDEK.insertRight(count++);
            System.out.print(myDEK.peekRight() + " ");
        }
        System.out.println("\nAfter Test2. Inserting right: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test3. Удаляем элементы из конца очереди(справа при нормальном порядке)
    void test3(){
        System.out.println("\n***Test3. Trying to remove right without looping...***");
        for (int i = 0; i < 1; i++) {
            System.out.print(myDEK.removeRight() + " ");
        }
        System.out.println("\nAfter Test3. Removing right: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test4. Удаляем элементы из начала очереди(слева при нормальном порядке)
    void test4(){
        System.out.println("\n***Test4. Trying to remove left without looping...***");
        for (int i = 0; i < 1; i++) {
            System.out.print(myDEK.removeLeft() + " ");
        }
        System.out.println("\nAfter Test4. Removing left: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test5. Добавляем элементы в начало очереди(слева при нормальном порядке) с зацикливанием
    void test5(){
        System.out.println("\n***Test5. Trying to insert left in right order with looping...***");
        int edge = myDEK.size() - myDEK.getQueueLength() + 1;
        for (int i = 0; i < edge; i++) {
            myDEK.insertLeft(count++);
            System.out.print(myDEK.peekLeft() + " ");
        }
        System.out.println("\nAfter Test5. Inserting left: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test6. Удаляем элементы из начала очереди(слева при обратном порядке) без зацикливания
    void test6(){
        System.out.println("\n***Test6. Trying to remove left in reverse order without looping...***");
        for (int i = 0; i < 1; i++) {
            System.out.print(myDEK.removeLeft() + " ");
        }
        //
        System.out.println("\nAfter Test6. Removing left: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test7. Удаляем элементы из конца очереди(справа при обратном порядке) без зацикливания
    void test7(){
        System.out.println("\n***Test7. Trying to remove right in reverse order without looping...***");
        for (int i = 0; i < 1; i++) {
            System.out.print(myDEK.removeRight() + " ");
        }
        System.out.println("\nAfter Test7. Removing right: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

    //Test8. Добавляем элементы в конец очереди(справа при обратном порядке) с зацикливанием
    void test8(){
        System.out.println("\n***Test8. Trying to insert right in reverse order with looping...***");
        int edge = myDEK.size() - myDEK.getQueueLength() + 1;
        for (int i = 0; i < edge; i++) {
            myDEK.insertRight(count++);
            System.out.print(myDEK.peekRight() + " ");
        }
        System.out.println("\nAfter Test8. Inserting right: array length: " + myDEK.size());
        System.out.println(Arrays.toString(myDEK.getList()));
    }

}
