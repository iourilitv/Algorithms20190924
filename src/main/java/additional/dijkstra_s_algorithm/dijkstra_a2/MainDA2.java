package additional.dijkstra_s_algorithm.dijkstra_a2;

import java.util.HashMap;

/**
 * Книга Адитья Бхаргава.Грокаем алгоритмы. Aditya Bhargava.Grokking Algorithms.2017
 * Глава 7. Алгоритм Дейкстры(Dijkstra's algorithm).
 * Translated by Yuriy Litvinenko from Python to Java.
 * Алгоритм Дейкстры работает только с направленными ациклическими графами,
 * которые нередко обозначаются сокращением DAG (Directed Acyclic Graph) и только с
 * положительными весами рёбер. При наличии отрицательных весов используйте алгоритм Беллмана-Форда.
 * Задача "История одного обмена".
 * Как выменять свою книгу по музыке на пианино с минимальной доплатой. Варианты обмена:
 * Book = poster;
 * Book + $5 = vinyl;
 * Vinyl + $15 = guitar;
 * Vinyl + $20 = drum;
 * Poster + $30 = guitar;
 * Poster + $35 = drum;
 * Guitar + $20 = piano;
 * Drum + $10 = piano.
 */
public class MainDA2 {
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

        DijkstraA2 dijkstraA2 = new DijkstraA2(graph, "book", "piano");
        //System.out.println(dijkstraA2.toString());

        //The lowest cost way has been found!
        //Cost: 35
        //The way: book --> vinyl --> drum --> piano

    }
}
