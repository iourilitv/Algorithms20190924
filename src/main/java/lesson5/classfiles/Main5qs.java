package lesson5.classfiles;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main5qs {
    public static void main(String[] args) {
        Random random = new Random();
        int capacity = 100;//100000;
        int bound = 10;//10000;
//        MyArraylist<Integer> malSel = new MyArraylist<>(capacity);
//        MyArraylist<Integer> malIns = new MyArraylist<>(capacity);
//        MyArraylist<Integer> malBub = new MyArraylist<>(capacity);
        MyArraylist<Integer> malQs = new MyArraylist<>(capacity);

        Integer value;
        for (int i = 0; i < capacity; i++) {
            value = random.nextInt(bound);
//            malSel.add(value);
//            malIns.add(value);
//            malBub.add(value);
            malQs.add(value);
        }

        long end;
        long begin;
        //System.out.println(malSel);
//        begin = System.currentTimeMillis();
//        malSel.selectionSort();
//        end = System.currentTimeMillis();
//        System.out.println("Selection sorting(mc): " + (end - begin));
        //System.out.println(malSel);

        //System.out.println(malIns);
//        begin = System.currentTimeMillis();
//        malIns.insertionSort();
//        end = System.currentTimeMillis();
//        System.out.println("Insertion sorting(mc): " + (end - begin));
        //System.out.println(malIns);

        //System.out.println(malBub);
//        begin = System.currentTimeMillis();
//        malBub.bubbleSort();
//        end = System.currentTimeMillis();
//        System.out.println("Bubble sorting(mc): " + (end - begin));
        //System.out.println(malBub);

        //System.out.println(malQs);
        begin = System.currentTimeMillis();
        malQs.qSort();
        end = System.currentTimeMillis();
        System.out.println("Quick sorting(mc): " + (end - begin));
        //System.out.println(malQs);

        //Selection sorting(mc): 28402
        //Insertion sorting(mc): 22321
        //Bubble sorting(mc): 78467
        //Quick sorting(mc): 176

//        mal.bubbleSort(Comparator.naturalOrder());
//        mal.bubbleSort(Comparator.reverseOrder());

//        mal.sort();
//        mal.parallelSort();

//        System.out.println(mal);


//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
//        msal.add(7);
//        msal.add(9);
//        msal.add(3);
//        msal.add(5);
//
//        System.out.println(msal);
//        System.out.println(msal.binaryFind(7));


//        MySortedArrayList<Integer> msal = new MySortedArrayList();
//        for (int i = 0; i < 10 ; i++) {
//            msal.add(random.nextInt(20));
//        }
//        System.out.println(msal);
//        System.out.println(msal.binaryFind(15));

    }
}
