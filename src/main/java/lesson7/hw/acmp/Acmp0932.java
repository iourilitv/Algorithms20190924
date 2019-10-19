package lesson7.hw.acmp;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
        //запускаем поиск троек для столиц
        TriplesFinder triplesFinder = new TriplesFinder(distance, graph);
        //запускаем поиск троек для столиц
        int triplesCount = triplesFinder.find();

        out.println(triplesCount);
        out.flush();
    }
}

class TriplesFinder {
    private ArrayList<Integer>[] drafts;//массив коллекций кандидатов троек на проверку
    private ArrayList<Integer[]> triples;//коллекция массивов троек прошедших проверку
    private int distance;//Количество заданное расстояние между столицами(вершинами)
    private LinkedList<Integer>[] adjLists;//Ссылочный массив всех связей(ссылочных массивов) в графе
    private int vertexCount;//количество вершин в графе
    private Graph g;//граф

    //TODO Added
    private boolean[] used;

    TriplesFinder(int distance, Graph g) {
        this.distance = distance;
        this.g = g;
        adjLists = g.getAdjList();
        vertexCount = adjLists.length;

        //TODO Added
        used = new boolean[vertexCount];

        drafts = new ArrayList[vertexCount];//инициируем массив коллекций кандидатов
        triples = new ArrayList<>();
        for (int i = 0; i < drafts.length; i++) {//наполняем ее пустыми коллекциями
            drafts[i] = new ArrayList<>();
        }
    }

    /**
     * Метод поиска подходящих троек - вершин, находящихся на расстоянии distance друг от друга
     * @return - количество подходящих троек
     */
    int find() {
        //запускаем заполнение массива массивов draft
        for (int i = 0; i < vertexCount; i++) {
            //TODO Deleted
            //запускаем поиск кандидатов для этой вершины
            //peekUpCandidates(i);
            //анализируем массив кандидатов draft и наполняем коллекцию троек
            //checkTriples(i);
            //TODO Added
            //если вершина еще не использовалась
            if(!used[i]){
                //запускаем поиск кандидатов для этой вершины
                peekUpCandidates(i);
                //анализируем массив кандидатов draft и наполняем коллекцию троек
                checkTriples(i);
            }
            //отмечаем вершину, как использованную
            used[i] = true;
        }
        //возвращаем коллекцию массивов троек
        return triples.size();
    }

    //Метод наполнения массива draft массивами кандидатами элементов троек
    private void peekUpCandidates(int source) {
        //TODO Added
        //если проверяеая вершина уже использована, то выходим
        if(used[source]){
            return;
        }

        boolean[] marked = new boolean[vertexCount];//маркер посещен(visited)
        LinkedList<Integer> queue = new LinkedList<>();//инициируем очередь
        queue.addLast(source);//добавляем начальную вершину в конец очереди
        marked[source] = true;//сразу помечаем "посещен" текущую вершину
        //гоняем цикл пока не достигнем заданной дистанции
        for (int i = 0; i < distance; i++) {
            //инициируем временную очередь
            LinkedList<Integer> curQueue = new LinkedList<>();
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
                        //и теперь соседа добавляем в конец очереди, как текущую вершину
                        curQueue.addLast(w);
                    }
                }
            }
            //присваиваем очереди ссылку на текущую очередь
            queue = curQueue;
        }
        //сохраняем связанную вершину(соседа) в коллекцию кандидатов
        drafts[source].addAll(queue);
    }

    //Метод проверки массива кандидатов и наполнения массива троек
    private void checkTriples(int vertex) {
        //TODO Added
        //если размер листа кандидата = 2, помечаем их оба как использованные
        if(drafts[vertex].size() == 2){
            used[drafts[vertex].get(0)] = true;
            used[drafts[vertex].get(1)] = true;
        }

        //листаем ссылочный массив кандидатов вершины
        for (int i = 0; i < drafts[vertex].size() - 1; i++) {
            //проверяем в подцикле для выбранной вершины
            for (int j = i + 1; j < drafts[vertex].size(); j++) {
                //если проверяемые вершины находятся на заданном расстоянии
                if(checkDistance(drafts[vertex].get(i), drafts[vertex].get(j))){
                    //формируем тройку
                    Integer[] array = {vertex, drafts[vertex].get(i), drafts[vertex].get(j)};
                    //сортируем массив(тройку)
                    Arrays.sort(array);
                    //если такой тройки еще нет в ссылочном массиве
                    if(!isDuplicate(array)){
                        //сохраняем тройку
                        triples.add(array);
                    }
                }
            }
        }
    }

    //Метод проверки расстояния между проверяемыми вершинами
    private boolean checkDistance(int from, int to){
        //инициируем очередь
        LinkedList<Integer> queue = new LinkedList<>();
        //добавляем начальную вершину в конец очереди
        queue.addLast(from);
        //инициируем временный массив маркеров посещена ли вершина
        boolean[] visited = new boolean[vertexCount];
        //сразу помечаем "посещен" стартовую вершину
        visited[from] = true;
        //гоняем цикл пока не достигнем заданной дистанции
        for (int i = 0; i < distance; i++) {
            //инициируем временную очередь
            LinkedList<Integer> curQueue = new LinkedList<>();
            //крутим цикл пока очередь не пуста
            while (!queue.isEmpty()) {
                //сохраняем удаленную из начала очереди вершину
                int vertex = queue.removeFirst();
                //проверяем последовательно все элементы в ссылочном списке связей вершин-соседей w
                for (int w : g.getAdjList(vertex)) {
                    if (!visited[w]) {
                        //помечаем вершину-соседа, как посещенную
                        visited[w] = true;
                        //и теперь соседа добавляем в конец очереди, как текущую вершину
                        curQueue.addLast(w);
                    }
                }
            }
            //присваиваем очереди ссылку на текущую очередь
            queue = curQueue;
        }
        //возвращаем результат проверки есть ли конечный пункт в связанном списке вершин,
        // находящихся на заданном расстоянии от стартовой вершины
        return queue.contains(to);
    }

    //Метод проверки на наличие дубликата тройки
    private boolean isDuplicate(Integer[] array) {
        if(triples.size() == 0){
            return false;
        }
        boolean flag = true;
        //во внешнем цикле ищем элементы
        for (int i = 0; i < triples.size(); i++) {
            flag = true;
            //запускаем горизонтальный поиск
            for (int j = 0; j < array.length; j++) {
                //если элементы не равны, выходим из внутреннего цикла
                if(!triples.get(i)[j].equals(array[j])){
                    flag = false;
                    break;
                }
            }
            //если тройки равны выходим из внешнего цикла - нашли дубликат
            if(flag){
                break;
            }
        }
        return flag;
    }
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