package lesson3.hw.task1b;

import java.util.Arrays;
import java.util.Random;

class Test1b {
    int size = 8;
    int count;
    MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(5);
    private Random random = new Random();

    void run(){
        //Test1. Добавляем элементы в конец очереди без переполнения
        test1(5);//OK
        //0 6 9 2 5
        //After Test1. 5 random priority elements have been Inserted: array length: 5
        //[0, 2, 5, 6, 9]

        //Test2. Удаляем элементы из конца очереди
        test2();//OK
        //9 6
        //After Test2. Removed some elements with highest priority: array length: 5
        //[0, 2, 5, null, null]

        //Test3. Добавляем элементы в конец очереди с переполнением
        //Массив должен увеличить вместимость и скопировать элементы текущего массива
        test3(3);//OK
        //8 7 0
        //After Test3. 0 random priority elements have been inserted: array length: 15
        //[0, 0, 2, 5, 7, 8, null, null, null, null, null, null, null, null, null]

        //Test4. Добавляем элемента в начало очереди(слева при нормальном порядке) (Test1)
        //Массив должен увеличить вместимость и скопировать элементы текущего массива в прямом порядке
        //test4();//OK
        //After Test10. Filling array in right order: array length: 10
        //[33, 32, 31, 30, 29, 24, 25, 26, 27, 28]
        //34
        //After Test1. Inserting left: array length: 20
        //[null, null, null, null, 34, 33, 32, 31, 30, 29, 24, 25, 26, 27, 28, null, null, null, null, null]


    }

    //Test1. Добавляем элементы в конец очереди
    private void test1(int edge){
        System.out.println("\n***Test1. Trying to insert without overloading...***");
        for (int i = 0; i < edge; i++) {
            count = random.nextInt(10);
            System.out.print(count + " ");
            mpq.insert(count);
        }
        System.out.println("\nAfter Test1. " + count + " random priority elements have been Inserted: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));
        //System.out.println(mpq.toString());
    }

    //Test2. Удаляем элементы из конца очереди
    private void test2(){
        System.out.println("\n***Test2. Trying to remove some elements...***");
        for (int i = 0; i < 2; i++) {
            System.out.print(mpq.remove() + " ");
        }
        System.out.println("\nAfter Test2. Removed some elements with highest priority: array length: " + mpq.size());
        //System.out.println(mpq.toString());
        System.out.println(Arrays.toString(mpq.getList()));
    }

    //Test3. Добавляем элементы в конец очереди
    private void test3(int edge){
        System.out.println("\n***Test3. Trying to insert with overloading...***");
        for (int i = 0; i < edge; i++) {
            count = random.nextInt(10);
            System.out.print(count + " ");
            mpq.insert(count);
        }
        System.out.println("\nAfter Test3. " + count + " random priority elements have been inserted: array length: " + mpq.size());
        //System.out.println(mpq.toString());
        System.out.println(Arrays.toString(mpq.getList()));
    }

    //Test10. Последовательно наполняем массив полностью в прямом порядке без зацикливания(Test1, Test2).
    //Затем добавляем элемент в начало очереди(слева при нормальном порядке) (Test1)
    //Массив должен увеличить вместимость и скопировать элементы текущего массива в прямом порядке
    private void test4(){
        System.out.println("\n***Test10. Trying to insert left in right order without looping...***");
        System.out.println("With array increasing when the queue in reverse order case!");
        //наполняем массив справа в прямом порядке
        //test2(5);

        System.out.println("\nAfter Test10. Filling array in right order: array length: " + mpq.size());
        System.out.println(mpq.toString());

        System.out.println("\nAfter Test10. Inserting left: array length: " + mpq.size());
        System.out.println(mpq.toString());
    }

}
