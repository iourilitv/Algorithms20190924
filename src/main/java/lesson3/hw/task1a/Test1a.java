package lesson3.hw.task1a;

import java.util.Arrays;

class Test1a {
    void run() {
        int size = 5;
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
        //[0, 1, 2, 3, 4, null, null, null, null, null, null, null, null, null, null]

    }
}
