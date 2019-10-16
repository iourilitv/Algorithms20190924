package lesson7;

import java.util.LinkedList;

public class Graph {
    private int vertexCount;//количество вершин в графе
    private int edgeCount = 0;//количество ребер(связей между вершинами)
    private LinkedList<Integer>[] adjList;//ссылочный массив связей вершин(ссылочных массивов)

    public Graph(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Неверное количество вершин " + vertexCount);
        }
        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];//инициируем ссылочный массив связей вершин
        for (int i = 0; i < adjList.length; i++) {//наполняем его пустыми ссылочными массивами для каждой вершины
            adjList[i] = new LinkedList<>();
        }
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    //Метод возвращает клон ссылочного массива связей вершины, чтобы не испортили его извне.
    //(LinkedList<Integer>) - приведение к нашему типу. т.к. clone() возвращает Object
    public LinkedList<Integer> getAdjList(int vertex) {
        return (LinkedList<Integer>) adjList[vertex].clone();
    }

    //Метод добавляем связь между вершинами
    public void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}
