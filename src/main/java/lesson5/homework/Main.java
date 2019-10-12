package lesson5.homework;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 * @author Fanzil Kusyapkulov
 */
public class Main {
    public static void main(String[] args) {

        // ���������� � �������
        System.out.println("task1");
        System.out.println(" 2 ^ 3 = " + exponentiation(2, 3));
        System.out.println(" 2 ^ 0 = " + exponentiation(2, 0));
        System.out.println(" 5 ^ 2 = " + exponentiation(5, 2));
        System.out.println("-5 ^ 3 = " + exponentiation(-5, 3));
        System.out.println("-4 ^ 2 = " + exponentiation(-4, 2));
        System.out.println(" 6 ^ -1 = " + exponentiation(6, -1));
        System.out.println(" 3 ^ -3 = " + exponentiation(3, -3));
        System.out.printf(" 10 ^ -3 = %f \n", exponentiation(10, -3));

        // ������ � �������

//        W=13,N=5
//        w1=3,p1=1
//        w2=4,p2=6
//        w3=5,p3=4
//        w4=8,p4=7
//        w5=9,p5=6
//        ����� �������, � ����� ������ 2 � 4 �������.
//        ��������� �������: 6+7=13
//        ��� �������: 4+8=12

        Item[] arrOfItems = {new Item(1, 3),
                new Item(6, 4),
                new Item(4, 5),
                new Item(7, 8),
                new Item(6, 9)};

        Bagpack bagpack = new Bagpack(arrOfItems);
        int bagpackCapacity = 13; // ����������� �������
        System.out.println("task2");
        System.out.println(bagpack.findBestSum(arrOfItems.length - 1, bagpackCapacity));
    }

    private static double exponentiation(double value, int power) {
        if (value == 0 && power <= 0) {
            throw new ArithmeticException("����������������");
        }
        if (power == 0) {
            return 1;
        } else if (power < 0) {
            return 1 / value * exponentiation(value, ++power);
        } else {
            return value * exponentiation(value, --power);
        }
    }
}
