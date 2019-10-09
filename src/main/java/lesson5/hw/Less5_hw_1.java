package lesson5.hw;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 */
public class Less5_hw_1 {
    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }

    static long pow(int number, int degree){


        return pow(number, degree - 1) * degree;
    }
}
