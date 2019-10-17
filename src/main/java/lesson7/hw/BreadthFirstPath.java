package lesson7.hw;

import java.util.LinkedList;

//Класс обхода графа в ширину
public class BreadthFirstPath {
    private boolean[] marked;//маркер посещен(visited)
    private int[] edgeTo;//массив откуда пришли к этой вершине
    private int source;//начальная вершина обхода графа

    //TODO lesson7hw.Deleted
//    private int[] distTo;//массив количества связей(длины пути) до требуемой вершины
//    private final int INFINITY = Integer.MAX_VALUE;//Константа бесконечности

    //TODO lesson7hw.Deleted
    /*public BreadthFirstPath(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        //наполняем массив длин пути бесконечно большими значениями
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        bfs(g, source);
    }*/
    //TODO lesson7hw.Added
    BreadthFirstPath(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
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

        //TODO lesson7hw.Deleted
        //distTo[source] = 0;//устанавливаем расстояние до самой-себя 0

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

                    //TODO lesson7hw.Deleted
                    //пересчитываем расстояние до вершины
                    //distTo[w] = distTo[vertex] + 1;

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
    private boolean hasPathTo(int v){
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
        //создаем стек, куда будем складывать вершины
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;
        //наполняем стэк пока не вернемся к начальной вершине, то есть путем,
        // который прошли во время обхода
        while(vertex != source){
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    //TODO lesson7hw.Added
    /**
     * Метод возвращает путь от самой вершины до требуемой
     * @param from - стартовая вершина
     * @param to - конечная вершина
     * @param cameFrom - массив откуда пришли к этой вершине в процессе поиска
     * @param visited - массив отметок посещены ли вершины
     * @return - стэк пути между вершинами
     */
    private LinkedList<Integer> pathTo(int from, int to, int[] cameFrom, boolean[] visited){
        if (!visited[to]){//проверяем дошли ли
            return null;
        }
        //создаем стек, куда будем складывать вершины
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = to;
        //наполняем стэк пока не вернемся к начальной вершине, то есть путем,
        // который прошли во время обхода
        while(vertex != from){
            stack.push(vertex);
            vertex = cameFrom[vertex];
        }
        return stack;
    }

    //TODO lesson7hw.Added
    LinkedList<Integer> findShortestPathFromTo(Graph g, int from, int to){
        //инициируем очередь
        LinkedList<Integer> queue = new LinkedList<>();
        //добавляем начальную вершину в конец очереди
        queue.addLast(from);
        //инициируем временный массив откуда пришли к этой вершине
        int[] cameFrom = new int[g.getVertexCount()];
        //инициируем временный массив маркеров посещена ли вершина
        boolean[] visited = new boolean[g.getVertexCount()];
        //сразу помечаем "посещен" стартовую вершину
        visited[from] = true;
        //крутим цикл пока очередь не пуста
        while (!queue.isEmpty()) {
            //сохраняем удаленную из начала очереди вершину
            int vertex = queue.removeFirst();
            //проверяем последовательно все элементы в ссылочном списке связей вершин-соседей w
            for (int w : g.getAdjList(vertex)) {
                if (!visited[w]) {
                    //помечаем вершину-соседа, как посещенную
                    visited[w] = true;
                    //добавляем в ее ячейку массива вершину, откуда к ней пришли
                    cameFrom[w] = vertex;
                    //если вершина-сосед это искомая вершина
                    if(w == to){
                        //выходим из цикла и возвращаем полный путь
                        return pathTo(from, to, cameFrom, visited);
                    }
                    //и теперь соседа добавляем в конец очереди, как текущую вершину
                    queue.addLast(w);
                }
            }
        }
        return new LinkedList<>();//если не найден путь, возвращаем пустой ссылочный массив
    }

    public int[] getEdgeTo() {
        return edgeTo.clone();
    }

    //TODO lesson7hw.Deleted
//    public int[] getDistTo() {
//        return distTo.clone();
//    }

    //TODO lesson7hw.Added
    /**
     * Метод вывода ссылочный массив связей вершин(ссылочных массивов) графа, полученного после обхода
     */
    void showAdjacencyList(Graph g){
        showAllAdjLists(g, g.getAdjList());
    }

    //TODO lesson7hw.Added
    /**
     * Приватный метод последовательно выводит ссылочные массивы связей по каждой вершине графа
     * @param linkedLists - ссылочный массив связей вершин(ссылочных массивов) графа
     */
    private void showAllAdjLists(Graph g, LinkedList<Integer>[] linkedLists){
        for (int i = 0; i < linkedLists.length; i++) {
            System.out.println(i + ": " + g.getAdjList(i));
        }
    }
}
