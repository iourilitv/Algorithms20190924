package lesson7.hw.acmp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Алгоритмы_и_структуры_данных_на_Java.БазовыйКурс. 24.09.2019 Webinar.
 * Teacher: Фанзиль Кусяпкулов
 * Урок 7. Графы
 * Домашняя работа.
 * @author Litvinenko Yuriy
 * Задачи на http://acmp.ru
 * Тема. Теория графов.
 * ЗАДАЧА №932. Столицы (Время: 5 сек. Память: 256 Мб Сложность: 92%)
 * В стране Триландии близятся выборы новых столиц. Столицы в Триландии необычные, поскольку ими
 * являются одновременно сразу три различных города. Такая идея размещения столиц основана на
 * исследованиях эффективности управления страной, выполненных ведущими экономистами Триландии.
 * Всего в Триландии n городов, из которых некоторые пары городов соединены дорогами и по каждой
 * из них можно проехать в обе стороны. Время проезда по каждой дороге в одну сторону равно одному
 * часу. При этом все города соединены дорогами таким образом, что из каждого города можно добраться
 * в любой другой, причем это можно сделать единственным способом, если по каждой дороге проезжать
 * не более одного раза и только в одну сторону.
 * Как показали результаты проведенных триландскими экономистами исследований, управление страной
 * будет наиболее эффективным, если три столицы будут выбраны так, что время проезда по кратчайшему
 * пути между каждой парой столиц составит ровно d часов. Перед проведением выборов необходимо знать,
 * сколько существует различных троек городов, удовлетворяющих описанным выше свойствам.
 * Две тройки городов считаются различными, если в первой тройке есть хотя бы один город, которого
 * нет во второй тройке, и наоборот.
 * Требуется написать программу, которая по количеству городов в Триландии и описанию дорог находит
 * количество троек городов, которые могут быть столицами.
 * Входные данные:
 * Первая строка входного файла INPUT.TXT содержит два разделенных пробелом целых числа:
 * количество городов в Триландии n и требуемое время в пути между столицами d
 * (3 ≤ n ≤ 105, 1 ≤ d < n). Каждая из последующих (n – 1) строк содержит описание одной дороги:
 * пару разделенных пробелом различных целых чисел ai и bi — номера городов, которые соединены
 * двусторонней дорогой (1 ≤ ai ≤ n, 1 ≤ bi ≤ n, ai ≠ bi). Каждая пара городов соединена
 * не более чем одной дорогой.
 * Выходные данные:
 * Выходной файл OUTPUT.TXT должен содержать одно целое число — количество подходящих троек городов,
 * которые могут быть выбраны столицами. В случае, если подходящих троек городов не окажется,
 * выходной файл должен содержать ноль..
 * Примеры:
 * 4 2
 * 1 2
 * 1 3
 * 1 4      >> 1
 *
 * 7 2
 * 1 2
 * 1 3
 * 1 4
 * 5 1
 * 5 6
 * 5 7        >> 5
 * Формализованная задача.
 * Найти тройки вершин, чтобы расстояние между каждой в тройке равнялось d.
 * Алгоритм решения на базе реализованного обхода графа в ширину(см.MainLess7hw).
 * Добавить в массив массивов(toChack) вершины на расстоянии d от проверяемой вершины.
 * Отметить проверяемую вершину "taked" и не добавлять в toChack.
 * Наполнить массив triples комбинациями троек, перебрав варианты в массиве toChack.
 * Если количество элементов в подмассиве вершины в toChack меньше, чем 2(т.к.ищем тройки)
 * - не проверяем.
 *
 */
public class Acmp0932 {
    public static void main(String[] args){
        new Task0932().run();
    }
}

class Task0932 {
    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void run() {
        //Количество вершин в графе
        int vertexCount = in.nextInt();
        //Количество заданное расстояние между столицами(вершинами)
        int distance = in.nextInt();
        //инициируем граф
        Graph graph = new Graph(vertexCount);
        //Принимаем связи и наполняем граф
        for (int i = 0; i < vertexCount - 1; i++) {
            int v1 = in.nextInt() - 1;
            int v2 = in.nextInt() - 1;
            graph.addEdge(v1, v2);//добавляем связь
        }

        BreadthFirstPath bfp = new BreadthFirstPath(graph);

        //TODO Временно
        bfp.showAdjacencyList(graph, out);

        //запускаем поиск троек для столиц
        TriplesFinder triplesFinder = new TriplesFinder(distance, bfp.getGraph().getAdjList());
        //запускаем поиск троек для столиц
        int triplesCount = triplesFinder.find();

        out.println(triplesCount);
        out.flush();
    }

    /*public Integer runTest() {
        //Принимаем ширину диплома
        //Количество глав
        //int chaptersNumber = in.nextInt();//TODO Parameterized Test.Deleted
        //инициируем целочисленный массив с количествами страниц в каждой главе
        //chaptersArray = new int[chaptersNumber];//TODO Parameterized Test.Deleted
        //инициируем максимальное количество страниц в одной главе
        int maxPagesNumber = -1;
        //инициируем общее количество страниц в романе
        int totalPagesSum = 0;
        //Принимаем количества страниц в главах и наполняем массив
        for (int i = 0; i < chaptersArray.length; i++) {
            //chaptersArray[i] = in.nextInt();//TODO Parameterized Test.Deleted
            //ищем максимальное число страниц в главе
            if(chaptersArray[i] > maxPagesNumber){
                //если элемент в массиве больше, то сохраняем его в переменной
                maxPagesNumber = chaptersArray[i];
            }
            //приплюсовываем значение текущего элемента к переменной суммы
            totalPagesSum += chaptersArray[i];
        }

        //TODO временно
        //out.println("\n" + maxPagesNumber + ". " + totalPagesSum);
        //out.flush();

        //Принимаем количество томов
        //tomesNumber = in.nextInt();//TODO Parameterized Test.Deleted

        //TODO временно
        //out.println("The calculating has started... please wait.");
        //out.flush();

        //Находим минимально возможный объем(в страницах) самого «толстого» тома
        int tomeSize = findMinAcceptableOfMaxTomeSize(maxPagesNumber, totalPagesSum);

        out.println(tomeSize);
        out.flush();
        return tomeSize;
    }*/


}

class TriplesFinder {
    private boolean[] tacked;//отметка, что вершина уже проверена
    private ArrayList<Integer>[] drafts;//массив массивов кандидатов троек на проверку
    private ArrayList<Integer> triples;//массив троек прошедших проверку
    private int distance;//Количество заданное расстояние между столицами(вершинами)
    private LinkedList<Integer>[] adjLists;//Ссылочный массив всех связей(ссылочных массивов) в графе
    private int vertexCount;//количество вершин в графе

    TriplesFinder(int distance, LinkedList<Integer>[] adjLists) {
        this.distance = distance;
        this.adjLists = adjLists;
        vertexCount = adjLists.length;
        tacked = new boolean[vertexCount];
        drafts = new ArrayList[vertexCount];//инициируем коллекцию коллекций кандидатов
        for (int i = 0; i < drafts.length; i++) {//наполняем ее пустыми коллкциями
            drafts[i] = new ArrayList<>();
        }
        triples = new ArrayList<>();
    }

    /**
     * Метод поиска подходящих троек - вершин, находящихся на расстоянии distance друг от друга
     * @return - количество подходящих троек
     */
    int find() {
        //запускаем заполнение массива массивов draft
        for (int i = 0; i < vertexCount; i++) {
            //помечаем, что вершина уже проверена
            tacked[i] = true;
            //запускаем поиск кандидатов для этой вершины
            peekUpCandidates(i);
        }
        //анализируем массив кандидатов draft и наполняем коллекцию троек
        //FIXME

        //возвращаем коллекцию массивов троек
        return triples.size();
    }

    /**
     * Метод наполнения массива draft массивами кандидатами элементов троек
     */
    void peekUpCandidates(int from){
        //инициируем очередь
        LinkedList<Integer> queue = new LinkedList<>();
        //добавляем начальную вершину в конец очереди
        queue.addLast(from);
        //инициируем текущую дистанцию
        int currentDistance = 1;
        //инициируем предыдущую вершину(из которой пришли)
        int prevVertex = from;
        int currentVertex = from;

//        //крутим цикл пока текущая дистанция не равна заданной
//        while (currentDistance != distance) {
//            //инициируем очередь
//            LinkedList<Integer> queue = new LinkedList<>();
//            //наполняем очередь вершинами связанными с текущей вершиной
//            queue.addAll(adjLists[currentVertex]);
//            //наполняем очередь связанными вершинами
//            queue = fillQueue(queue, currentVertex);
//            //инкрементируем текущую дистанцию
//            currentDistance++;
//        }

        //крутим цикл пока текущая дистанция не равна заданной
        while (currentDistance <= distance) {
            //инициируем временную очередь
            LinkedList<Integer> curQueue = new LinkedList<>();;
            //крутим цикл пока очередь не пуста
            while (!queue.isEmpty()) {
                //сохраняем удаленную из начала очереди вершину
                currentVertex = queue.removeFirst();
                //наполняем текущую очередь связями текущей вершины, исключая откуда пришли
                for (int w : adjLists[currentVertex]) {
                    if (w != prevVertex) {
                        curQueue.addLast(w);
                    }
                }
//                //проверяем последовательно все элементы в ссылочном списке связей вершин-соседей w
//                for (int w : adjLists[currentVertex]) {
//
////                    if (currentDistance == distance && w != prevVertex) {
////                        //сохраняем связанную вершину(соседа) в коллекцию кандидатов
////                        drafts[from].add(w);
////                    } else {
//                        //и теперь соседа добавляем в конец очереди, как текущую вершину
//                        queue.addLast(w);
////                    }
            }
            //присваиваем очереди ссылку на текущую очередь
            queue = curQueue;
            //сохраняем ее как предыдущую для следующих
            prevVertex = currentVertex;
            //инкрементируем текущую дистанцию
            currentDistance++;
        }
    }

    /*LinkedList<Integer> fillQueue(LinkedList<Integer> queue, int currentVertex){

        //наполняем очередь ссылочным массивов связей вершины
        queue.addAll(adjLists[currentVertex]);
        return queue;
    }*/

}

class Graph {
    private int vertexCount;//количество вершин в графе
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
    }

    int getVertexCount() {
        return vertexCount;
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

//Класс обхода графа в ширину
class BreadthFirstPath {
    private boolean[] marked;//маркер посещен(visited)
    private int[] edgeTo;//массив откуда пришли к этой вершине
    private Graph graph;//граф

    BreadthFirstPath(Graph g) {
        //начальная вершина обхода графа
        int source = 0;
        this.graph = g;
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
    /*private boolean hasPathTo(int v){
        return marked[v];
    }*/

    /**
     * Метод возвращает путь от самой вершины до требуемой
     * @param v - проверяемая вершина
     * @return стек
     */
    /*public LinkedList<Integer> pathTo(int v){
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
    }*/

    /**
     * Метод возвращает путь от самой вершины до требуемой
     * @param from - стартовая вершина
     * @param to - конечная вершина
     * @param cameFrom - массив откуда пришли к этой вершине в процессе поиска
     * @param visited - массив отметок посещены ли вершины
     * @return - стэк пути между вершинами
     */
    /*private LinkedList<Integer> pathTo(int from, int to, int[] cameFrom, boolean[] visited){
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
    }*/

    /*LinkedList<Integer> findShortestPathFromTo(Graph g, int from, int to){
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
    }*/

    /**
     * Метод вывода ссылочный массив связей вершин(ссылочных массивов) графа, полученного после обхода
     */
    void showAdjacencyList(Graph g, PrintWriter out){
        showAllAdjLists(g, g.getAdjList(), out);
    }

    /**
     * Приватный метод последовательно выводит ссылочные массивы связей по каждой вершине графа
     * @param linkedLists - ссылочный массив связей вершин(ссылочных массивов) графа
     */
    private void showAllAdjLists(Graph g, LinkedList<Integer>[] linkedLists, PrintWriter out){
        for (int i = 0; i < linkedLists.length; i++) {
            out.println(i + ": " + g.getAdjList(i));
            out.flush();
        }
    }

    public Graph getGraph() {
        return graph;
    }
}
