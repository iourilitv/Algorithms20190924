package additional.dynamic_programming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Книга Адитья Бхаргава.Грокаем алгоритмы. Aditya Bhargava.Grokking Algorithms.2017
 * Глава 9. Динамическое программирование(dynamic programming) - это метод разбивания
 * большой задачи на однотипные подзадачи, результаты выполнения которых используется в следующей.
 * Translated by Yuriy Litvinenko from Python to Java.
 * Задача "Уложить рюкзак"(knapsack problem).
 * Дан рюкзак с определенной вместимостью по весу и массив вещей с весом и стоимостью.
 * Суммарный вес всех вещей больше, чем может принять рюкзак.
 * Нужно выбрать и уложить  в рюкзак такие вещи, чтобы итоговый вес рюкзака был максимально близким
 * к его вместимости.
 * Решение.
 * Перебрать матрицу поиска решений, где:
 *  - строки это вещи;
 *  - колонки вместимости подрюкзаков с шагом равном минимальной разнице между весом вещей;
 *  - ячейки - самое большое значение итогового веса вещей в рюкзаке.
 */
public class MainDP {
    public static void main(String[] args) {
        //инициируем список вещей в виде хэш таблицы с ключами - их названиями и
        // объектов вещей с их параметрами
        final HashMap<String, Thing> things = new HashMap<>();
        //наполняем список вещей
        things.put("water", new Thing("water", 3, 10));
        things.put("book", new Thing("book", 1, 3));
        things.put("food", new Thing("food", 2, 9));
        things.put("jacket", new Thing("jacket", 2, 5));
        things.put("camera", new Thing("book", 1, 6));

        DynamicP dynamicP = new DynamicP(1, things);
//        System.out.println(things);
//        System.out.println("Best stations list: " + greedyA.getResult());

    }
}
