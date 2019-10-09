package lesson5.hw;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * 3*. Добавить в рекурсивный метод recMultiply возможность перемножения отрицательных чисел.
 */
public class Less5_hw_3 {
    public static void main(String[] args) {
        System.out.println(multiply(4, 7));
    }

    static int multiply(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        return value;
    }

    static int recMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }
}
