package lesson8.classfiles;

import java.util.Random;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 8. Хеш-таблицы
 * Быстрый поиск и вставка с помощью хеш-таблиц.
 * Рассмотрим методы хеширования: цепочек и открытая адресация.
 *
 */
public class MainL8clf {
    public static void main(String[] args) {
//        int x = Integer.MIN_VALUE;
//        System.out.println(x);
//        System.out.println(Math.abs(x));
//        int x = 0x10;
//        System.out.println(x);

//        ChainingHashMap<Integer ,String> map = new ChainingHashMap<>();
//        map.put(1,"one");
//        map.put(2,"two");
//        map.put(12,"12");
//        map.put(15,"15");
//
//        System.out.println(map.get(155));
//        System.out.println(map);

        Random random = new Random();
//        for (int i = 0; i < 50; i++) {
//            map.put(random.nextInt(1000),"");
//        }
//        System.out.println(map);

        LinearProbingHashMap<Integer,String> map1 = new LinearProbingHashMap<>();
        map1.put(1,"one");
        map1.put(2,"two");
        map1.put(12,"12");
        map1.put(15,"15");

        System.out.println(map1.get(1));
        map1.put(1,"1");
        System.out.println(map1.get(1));

    }
}
