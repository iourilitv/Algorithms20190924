package lesson7.classfiles;

import java.util.LinkedList;

//Класс обхода графа в глубину
public class DepthFirstPaths {
    private boolean[] marked;//маркер посещен(visited)
    private int[] edgeTo;//массив откуда пришли к этой вершине
    private int source;//начальная вершина обхода графа

    public DepthFirstPaths(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];//инициируем пустой массив "откуда" по количеству вершин
        marked = new boolean[g.getVertexCount()];//инициируем пустой массив "посещен" по количеству вершин
        dfs(g, source);
    }

    /**
     * Рекурсивный метод обхода графа в глубину
     * @param g - граф
     * @param v - текущая вершина
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;//сразу помечаем "посещен" текущую вершину
        //проверяем последовательно все элементы в ссылочном списке связей вершин-соседей w
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                //если вершина еще не посещена, добавляем в ее ячейку массива вершину,
                // откуда к ней пришли
                edgeTo[w] = v;
                dfs(g, w);//и запускаем рекурсию
            }
        }
    }

    /**
     * Метод из массива самой вершины возвращает значение в ячейке проверяемой вершины,
     * полученное в результате обхода графа
     * @param v - проверяемая вершина
     * @return true - да, путь к этой вершине есть, false - не дошли, значит пути нет.
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    /**
     * Метод возвращает путь от самой вершины до требуемой
     * @param v - проверяемая вершина
     * @return стек
     */
    public LinkedList<Integer> pathTo(int v){
        if (!hasPathTo(v)){//проверяем дошли ли
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();//создаем стек, куда будем складывать вершины
        int vertex = v;
        //наполняем стэк пока не вернемся к начальной вершине, то есть путем,
        // который прошли во время обхода
        while(vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

}
