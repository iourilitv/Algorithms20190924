package lesson3.hw.task1b;

import java.util.Arrays;
import java.util.Random;

class Test1b {
    int size = 8;
    int count;

    //MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(5);
    MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>();

    private Random random = new Random();

    void run(){
        //Test1. Добавляем элементы в конец очереди без переполнения
        test1(5);//OK
        //2 0 6 9 9
        //After Test1. 5 random priority elements have been inserted: array length: 5
        //[0, 2, 6, 9, 9]

        //Test2. Удаляем элементы из конца очереди
        test2();//OK
        //9 9
        //After Test2. Removed some elements with highest priority: array length: 5
        //[0, 2, 6, null, null]

        //Test3. Добавляем элементы в конец очереди с переполнением
        //Массив должен увеличить вместимость и скопировать элементы текущего массива
        test3(3);//OK
        //1 0 6
        //After Test3. 6 random priority elements have been inserted: array length: 15
        //[0, 0, 1, 2, 6, 6, null, null, null, null, null, null, null, null, null]
        test3(5);

        //Test4. Удаляем все элементы из очереди
        //Массив должен вернуться к дефолтной вместимости, когда опустошится полностью
        test4();//OK
        //6 6 2 1 0 0
        //After Test4. Removed all elements: array length: 10
        //[null, null, null, null, null, null, null, null, null, null]

        test1(1);//OK
        //8
        //After Test1. 1 random priority elements have been inserted: array length: 10
        //[8, null, null, null, null, null, null, null, null, null]

    }

    //Test1. Добавляем элементы в конец очереди
    private void test1(int edge){
        System.out.println("\n***Test1. Trying to insert without overloading...***");
        for (int i = 0; i < edge; i++) {
            count = random.nextInt(10);
            System.out.print(count + " ");
            mpq.insert(count);
        }
        System.out.println("\nAfter Test1. " + edge + " random priority elements have been inserted: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));
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
        System.out.println(Arrays.toString(mpq.getList()));
    }


    //Test4. Удаляем все элементы из очереди
    //Массив должен вернуться к дефолтной вместимости, когда опустошится полностью
    private void test4(){
        System.out.println("\n***Test4. Trying to remove all elements...***");
        System.out.println("With array decreasing when the queue became empty!");
        int edge = mpq.getQueueLength();
        for (int i = 0; i < edge; i++) {
            int temp = mpq.remove();
            System.out.print(temp + " ");
        }
        System.out.println("\nAfter Test4. Removed all elements: array length: " + mpq.size());
        System.out.println(Arrays.toString(mpq.getList()));
    }

}