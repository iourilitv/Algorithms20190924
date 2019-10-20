package lesson8.hw.task2;

import java.util.Random;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 8. Хеш-таблицы
 * Быстрый поиск и вставка с помощью хеш-таблиц.
 * Рассмотрим методы хеширования: цепочек.
 * Домашнее задание.
 * 2** Реализовать удаление в методе открытой адресации.
 */
public class MainL8hw2 {
    public static void main(String[] args) {

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
