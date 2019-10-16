package lesson7.hw;

import lesson7.classfiles.BreadthFirstPath;
import lesson7.classfiles.Graph;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 7. Графы
 *  * Рассмотрим работу с одной из самых гибких и универсальных структур.
 * Homework.
 * @author Yiriy Litvinenko
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 *     Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 * 2*. Улучшение. В методе addEdge() исключить задвоение петли при v1 == v2.
 * 3*. Улучшение. В BFS удалить метод distTo - путь можно вывести из связанного списка вершины.
 */
public class MainLess7hw {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(1, 2);
        graph.addEdge(0, 4);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(7, 8);
        graph.addEdge(2, 3);

//        System.out.println(graph.getAdjList(1));

//        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2);
//        System.out.println(dfp.hasPathTo(3));
//        System.out.println(dfp.pathTo(3));

        BreadthFirstPath bfp = new BreadthFirstPath(graph,0);
        System.out.println(bfp.hasPathTo(8));
        System.out.println(bfp.hasPathTo(3));
        System.out.println(bfp.pathTo(3));

    }
}
