package lesson8.hw.task2;

import java.util.Random;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int capacity = 50;
        LinearProbingHashMap<Integer,String> map = new LinearProbingHashMap<>(capacity);

        for (int i = 0; i < capacity - 1; i++) {
            int r = random.nextInt(1000);
            map.put(r, "" + i);
        }
        int key;
        int value;

        System.out.println(map);
        System.out.println(map.getSet().toString());

        key = sc.nextInt();
        System.out.println("deleted key: " + key + ". value: " + map.delete(key));
        System.out.println(map);

        key = sc.nextInt();
        System.out.println("changing value of key: " + key + ". value: " + map.get(key));
        map.put(key, "" + map.get(key) + 0);
        System.out.println(map);

        while(true){
            key = sc.nextInt();
            value = sc.nextInt();
            System.out.println("putted key: " + key + ". value: " + value);
            map.put(key, "" + value);
            System.out.println(map);

        }

//        key = 125;
//        System.out.println("deleted key: " + key + ". value: " + map.delete(key));
//        System.out.println(map);
//
//        key = 875;
//        System.out.println("changing value of key: " + key + ". value: " + map.get(key));
//        map.put(key, "" + map.get(key) + 0);
//        System.out.println(map);

    }
}
//***LinearProbingHashMap***
//[300(17), 745(47), 648(48), 703(28), 203(34), 255(14), 156(2), 207(9), 56(20), 509(10),
// 709(21), 511(19), 562(31), 158(36), 710(42), 662(43), 666(15), 260(44), 818(25), 765(45),
// 120(26), 221(18), 572(4), 323(0), 23(22), 125(16), 422(27), 377(6), 77(12), 179(1),
// 875(29), 527(33), 824(37), 828(38), 134(8), 435(7), 986(32), 570(40), 72(41), 489(5),
// 740(3), 569(46), null(null), null(null), 94(30), 895(23), 795(24), 246(35), 348(39), 149(13)]
//
//[0:300(17), 10:260(44), 10:710(42), 11:511(19), 12:562(31),
// 12:662(43), 15:765(45), 16:666(15), 18:818(25), 19:569(46),
// 20:120(26), 20:570(40), 21:221(11), 21:221(18), 22:422(27),
// 22:572(4), 22:72(41), 23:23(22), 23:323(0), 24:824(37),
// 25:125(16), 25:875(29), 27:377(6), 27:527(33), 27:77(12),
// 28:828(38), 29:179(1), 34:134(8), 35:435(7), 36:986(32),
// 39:489(5), 3:203(34), 3:703(28), 40:740(3), 44:94(30),
// 45:745(47), 45:795(24), 45:895(23), 46:246(35), 48:348(39),
// 48:648(48), 49:149(13), 5:255(14), 6:156(2), 6:56(20),
// 7:207(9), 8:158(36), 9:509(10), 9:709(21)]