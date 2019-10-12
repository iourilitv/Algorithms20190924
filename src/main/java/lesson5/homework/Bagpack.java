package lesson5.homework;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 * @author Fanzil Kusyapkulov
 */
class Bagpack {

    private Item[] items;

    Bagpack(Item[] items) {
        this.items = items;
    }

    int findBestSum(int i, int weight) {
        if (i < 0) {
            return 0;
        }
        if (items[i].weight > weight) {
                return findBestSum(i - 1, weight);
        } else {
            return Math.max(
                    findBestSum(i - 1, weight),
                findBestSum(i - 1, weight - items[i].weight) + items[i].price
                            );
        }
    }
}