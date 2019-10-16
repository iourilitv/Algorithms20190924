package lesson7;

import java.util.LinkedList;

//Класс обхода графа в ширину
public class BreadthFirstPath {
    private boolean[] marked;//маркер посещен(visited)
    private int[] edgeTo;//массив откуда пришли к этой вершине
    private int[] distTo;//массив количества связей(длины пути) до требуемой вершины
    private int source;//начальная вершина обхода графа
    private final int INFINITY = Integer.MAX_VALUE;//Константа бесконечности

    public BreadthFirstPath(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        for (int i = 0; i < distTo.length; i++) {//наполняем массив длин пути бесконечно большими значениями
            distTo[i] = INFINITY;
        }
        bfs(g, source);
    }

    /**
     * Рекурсивный метод обхода графа в ширину
     * @param g - граф
     * @param source - текущая вершина
     */
    private void bfs(Graph g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();//инициируем очередь
        queue.addLast(source);//добавляем начальную вершину в конец очереди
        marked[source] = true;//сразу помечаем "посещен" текущую вершину
        distTo[source] = 0;//устанавливаем расстояние до самой-себя 0
        //крутим цикл пока очередь не пуста
        while (!queue.isEmpty()) {
            //сохраняем удаленную из начала очереди вершину
            int vertex = queue.removeFirst();
            //проверяем последовательно все элементы в ссылочном списке связей вершин-соседей w
            for (int w : g.getAdjList(vertex)) {
                //если вершина-сосед еще не посещена
                if (!marked[w]) {
                    //помечаем вершину-соседа, как посещенную
                    marked[w] = true;
                    //добавляем в ее ячейку массива вершину, откуда к ней пришли
                    edgeTo[w] = vertex;
                    //пересчитываем расстояние до вершины
                    distTo[w] = distTo[vertex] + 1;
                    //и теперь соседа добавляем в конец очереди, как текущую вершину
                    queue.addLast(w);
                }
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
