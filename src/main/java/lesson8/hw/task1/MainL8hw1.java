package lesson8.hw.task1;

import lesson8.hw.task2.LinearProbingHashMap;

import java.util.Random;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 8. Хеш-таблицы
 * Быстрый поиск и вставка с помощью хеш-таблиц.
 * Рассмотрим методы хеширования: цепочек.
 * Домашнее задание.
 * 1. Реализовать удаление в методе цепочек.
 */
public class MainL8hw1 {
    public static void main(String[] args) {

        ChainingHashMap<Integer ,String> map = new ChainingHashMap<>();
        map.put(1,"one");
        map.put(2,"two");
        map.put(12,"12");
        map.put(15,"15");

        System.out.println(map);
        System.out.println("map.get(155): " + map.get(155));
        System.out.println("map.delete(2): " + map.delete(2));
        System.out.println("map.delete(2) again: " + map.delete(2));
        System.out.println(map);

//        Random random = new Random();
//        for (int i = 0; i < 50; i++) {
//            map.put(random.nextInt(1000),"");
//        }
//        System.out.println(map);

    }
}
