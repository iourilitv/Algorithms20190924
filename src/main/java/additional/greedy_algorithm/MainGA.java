package additional.greedy_algorithm;

import java.util.HashMap;

/**
 * Книга Адитья Бхаргава.Грокаем алгоритмы. Aditya Bhargava.Grokking Algorithms.2017
 * Глава 8. Жадный алгоритм(Greedy algorithm).
 * Translated by Yuriy Litvinenko from Python to Java.
 * Задача. "О радиостанциях".
 * Выбрать минимальное количество радиостанций, чтобы покрыть всю территории вещания.
 *
 */
public class MainGA {
    public static void main(String[] args) {
        //инициируем взвешенный граф в виде хэш таблицы хэш таблиц весов ребер
        final HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        //наполняем граф узлами
        graph.put("book", new HashMap<>());
        graph.put("poster", new HashMap<>());
        graph.put("vinyl", new HashMap<>());
        graph.put("guitar", new HashMap<>());
        graph.put("drum", new HashMap<>());
        graph.put("piano", new HashMap<>());
        //наполняем узлы весами ребер
        graph.get("book").put("poster", 0);
        graph.get("book").put("vinyl", 5);
        graph.get("poster").put("guitar", 30);
        graph.get("poster").put("drum", 35);
        graph.get("vinyl").put("guitar", 15);
        graph.get("vinyl").put("drum", 20);
        graph.get("guitar").put("piano", 20);
        graph.get("drum").put("piano", 10);

        GreedyA greedyA = new GreedyA();
        //System.out.println(greedyA.toString());


    }
}
