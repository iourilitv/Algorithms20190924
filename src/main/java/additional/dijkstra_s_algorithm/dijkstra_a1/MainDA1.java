package additional.dijkstra_s_algorithm.dijkstra_a1;

import java.util.HashMap;

/**
 * Книга Адитья Бхаргава.Грокаем алгоритмы. Aditya Bhargava.Grokking Algorithms.2017
 * Глава 7. Алгоритм Дейкстры(Dijkstra's algorithm).
 * Translated by Yuriy Litvinenko from Python to Java.
 * Алгоритм Дейкстры работает только с направленными ациклическими графами,
 * которые нередко обозначаются сокращением DAG (Directed Acyclic Graph) и только с
 * положительными весами рёбер.
 * Задача.
 * Найти самый быстрый путь от начала до конца. Веса ребер указаны в минутах.
 */
public class MainDA1 {
    public static void main(String[] args) {
        //инициируем взвешенный граф в виде хэш таблицы хэш таблиц весов ребер
        final HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        //наполняем граф узлами
        graph.put("beg", new HashMap<>());
        graph.put("A", new HashMap<>());
        graph.put("B", new HashMap<>());
        graph.put("end", new HashMap<>());
        //наполняем узлы весами ребер
        graph.get("beg").put("A", 6);//вес ребра от начала до А = 6
        graph.get("beg").put("B", 2);
        graph.get("A").put("end", 1);
        graph.get("B").put("A", 3);
        graph.get("B").put("end", 5);

        DijkstraA1 dijkstraA1 = new DijkstraA1(graph);
        System.out.println(dijkstraA1.toString());
    }
}
