package lesson7.hw;

import java.util.LinkedList;

public class Graph {
    private int vertexCount;//количество вершин в графе
    private int edgeCount = 0;//количество ребер(связей между вершинами)
    private LinkedList<Integer>[] adjList;//ссылочный массив связей вершин(ссылочных массивов)

    Graph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Неверное количество вершин " + vertexCount);
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];//инициируем ссылочный массив связей вершин
        //наполняем его пустыми ссылочными массивами для каждой вершины
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
        //TODO Attention! Не использовать .fill() - он всем элементам присваивает одну и туже ссылку!
        //Arrays.fill(adjList, new LinkedList<>());
    }

    int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    //Метод возвращает клон ссылочного массива связей заданной вершины, чтобы не испортили его извне.
    //(LinkedList<Integer>) - приведение к нашему типу. т.к. clone() возвращает Object
    LinkedList<Integer> getAdjList(int vertex) {
        return (LinkedList<Integer>) adjList[vertex].clone();
    }

    //Метод добавляем связь между вершинами
    void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);

        //TODO lesson7hw.Deleted
        //adjList[v2].add(v1);
        //TODO lesson7hw.Added
        //исключаем задвоение, для петлей
        if (v1 != v2){
            adjList[v2].add(v1);
        }
    }

    //Метод возвращает клон ссылочного массива связей(ссылочных массивов) в графе для каждой вершины
    LinkedList<Integer>[] getAdjList() {
        return adjList.clone();
    }
}
