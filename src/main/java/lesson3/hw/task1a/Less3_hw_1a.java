package lesson3.hw.task1a;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 3. Стек и очередь.
 * Обзор структуры данных. Стек, очередь и приоритетная очередь
 * Домашняя работа.
 * 1. Реализовать рассмотренные структуры данных в консольных программах.
 * DONE a) Добавить в стек увеличение массива при переполнении стека.
 */
public class Less3_hw_1a {
    public static void main(String[] args) {
        new Test1a().run();

        /*int size = 5;
        MyStack<Integer> stack = new MyStack<>(5);

        for (int i = 0; i < size; i++) {
            stack.push(i);
        }

        System.out.println("\nAfter pushing #1: array length: " + stack.size());
        System.out.println(Arrays.toString(stack.getList()));
        //After pushing #1: array length: 5
        //[0, 1, 2, 3, 4]

        for (int i = 0; i < size; i++) {
            stack.push(i);
        }

        System.out.println("\nAfter pushing #2: array length: " + stack.size());
        System.out.println(Arrays.toString(stack.getList()));
        //After pushing #2: array length: 10
        //[0, 1, 2, 3, 4, 0, 1, 2, 3, 4, null, null, null, null, null]

        System.out.println("\nTrying to pop...");
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop() + " ");
        }
        //4 3 2 1 0

        System.out.println("\nAfter popping #1: array length: " + stack.size());
        System.out.println(Arrays.toString(stack.getList()));
        //After popping #1: array length: 5
        //[0, 1, 2, 3, 4, null, null, null, null, null, null, null, null, null, null]*/
    }
}