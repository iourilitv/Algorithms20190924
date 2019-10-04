package lesson3.hw.task1b;

import java.util.Arrays;

class Test1b {
    int size = 8;
    int count = 1;
    MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(5);

    void run(){
        //Test2. Добавляем элементы в конец очереди(справа при нормальном порядке)
        test2(1);//OK
        //3
        //After Test2. Inserting right: array length: 8
        //[null, null, null, 2, 1, 3, null, null]

        //Test3. Удаляем элементы из конца очереди(справа при нормальном порядке)
        test3();//OK
        //3
        //After Test3. Removing right: array length: 8
        //[null, null, null, 2, 1, null, null, null]

        //Test10. Последовательно наполняем массив полностью в прямом порядке без зацикливания(Test1, Test2).
        //Затем добавляем элемент в начало очереди(слева при нормальном порядке) (Test1)
        //Массив должен увеличить вместимость и скопировать элементы текущего массива в прямом порядке
        test10();//OK
        //After Test10. Filling array in right order: array length: 10
        //[33, 32, 31, 30, 29, 24, 25, 26, 27, 28]
        //34
        //After Test1. Inserting left: array length: 20
        //[null, null, null, null, 34, 33, 32, 31, 30, 29, 24, 25, 26, 27, 28, null, null, null, null, null]


    }

    //Test2. Добавляем элементы в конец очереди(справа при нормальном порядке)
    private void test2(int edge){
        System.out.println("\n***Test2. Trying to insert right in right order without looping...***");
        for (int i = 0; i < edge; i++) {
            mpq.insert(count++);
            System.out.print(mpq.peek() + " ");
        }
        System.out.println("\nAfter Test2. Inserting right: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));
    }

    //Test3. Удаляем элементы из конца очереди(справа при нормальном порядке)
    private void test3(){
        System.out.println("\n***Test3. Trying to remove right without looping...***");
        for (int i = 0; i < 1; i++) {
            System.out.print(mpq.remove() + " ");
        }
        System.out.println("\nAfter Test3. Removing right: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));
    }

    //Test10. Последовательно наполняем массив полностью в прямом порядке без зацикливания(Test1, Test2).
    //Затем добавляем элемент в начало очереди(слева при нормальном порядке) (Test1)
    //Массив должен увеличить вместимость и скопировать элементы текущего массива в прямом порядке
    private void test10(){
        System.out.println("\n***Test10. Trying to insert left in right order without looping...***");
        System.out.println("With array increasing when the queue in reverse order case!");
        //наполняем массив справа в прямом порядке
        test2(5);

        System.out.println("\nAfter Test10. Filling array in right order: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));

        System.out.println("\nAfter Test10. Inserting left: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));
    }

}
