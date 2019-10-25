package additional.dynamic_programming;

import java.util.HashMap;

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
        things.put("camera", new Thing("camera", 1, 6));

        DynamicP dynamicP = new DynamicP(1, things);
        Knapsack knapsack = dynamicP.getResultKnapsack();
        System.out.println("\nThe maximum cost set of goods: " + knapsack.getThingsInside());
        System.out.println("The total weight of set of goods: " + knapsack.getWeightOfThingsInside());
        System.out.println("The total cost of set of goods: " + knapsack.getCostOfThingsInside());

        //columns: [1, 2, 3]
        //rows[0]=book={weight=1, cost=3}: [Knapsack{capacity=1, thingsInside=[book={weight=1, cost=3}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=2, thingsInside=[book={weight=1, cost=3}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=3, thingsInside=[book={weight=1, cost=3}], weightOfThingsInside=0, costOfThingsInside=0}]
        //rows[1]=jacket={weight=2, cost=5}: [Knapsack{capacity=1, thingsInside=[jacket={weight=2, cost=5}, book={weight=1, cost=3}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=2, thingsInside=[jacket={weight=2, cost=5}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=3, thingsInside=[jacket={weight=2, cost=5}, book={weight=1, cost=3}], weightOfThingsInside=1, costOfThingsInside=3}]
        //rows[2]=camera={weight=1, cost=6}: [Knapsack{capacity=1, thingsInside=[camera={weight=1, cost=6}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=2, thingsInside=[camera={weight=1, cost=6}, jacket={weight=2, cost=5}, book={weight=1, cost=3}], weightOfThingsInside=3, costOfThingsInside=8}, Knapsack{capacity=3, thingsInside=[camera={weight=1, cost=6}, jacket={weight=2, cost=5}], weightOfThingsInside=2, costOfThingsInside=5}]
        //rows[3]=water={weight=3, cost=10}: [Knapsack{capacity=1, thingsInside=[camera={weight=1, cost=6}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=2, thingsInside=[camera={weight=1, cost=6}, jacket={weight=2, cost=5}, book={weight=1, cost=3}], weightOfThingsInside=3, costOfThingsInside=8}, Knapsack{capacity=3, thingsInside=[water={weight=3, cost=10}], weightOfThingsInside=0, costOfThingsInside=0}]
        //rows[4]=food={weight=2, cost=9}: [Knapsack{capacity=1, thingsInside=[camera={weight=1, cost=6}, food={weight=2, cost=9}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=2, thingsInside=[food={weight=2, cost=9}], weightOfThingsInside=0, costOfThingsInside=0}, Knapsack{capacity=3, thingsInside=[camera={weight=1, cost=6}, food={weight=2, cost=9}], weightOfThingsInside=1, costOfThingsInside=6}]
        //
        //The maximum cost set of goods: [camera={weight=1, cost=6}, food={weight=2, cost=9}]
        //The total weight of set of goods: 3
        //The total cost of set of goods: 15
    }
}
