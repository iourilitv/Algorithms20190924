package additional.dijkstra_s_algorithm.dijkstra_a1;

import java.util.HashMap;
import java.util.Stack;

class DijkstraA1 {
    private final Integer INFINITY = Integer.MAX_VALUE;//константа бесконечности веса
    private final String NO_NODE = "NO_NODE";//константа для пустого родителя

    //Для реализации этого примера понадобятся три хеш-таблицы.
    //получаем взвешенный граф в виде хэш таблицы хэш таблиц весов ребер
    private HashMap<String, HashMap<String, Integer>> graph;
    //инициируем хэш таблицу весов(стоимостей) узлов - сколько времени потребуется
    //для перехода к этому узлу от начального узла
    private HashMap<String, Integer> costs = new HashMap<>();
    //инициируем хэш таблицу родителей узлов
    private HashMap<String, String> parents = new HashMap<>();

    //инициируем хэш таблицу отметок был ли узел уже посещен
    private HashMap<String, Boolean> visited = new HashMap<>();

    DijkstraA1(HashMap<String, HashMap<String, Integer>> graph) {
        this.graph = graph;
        //наполняем таблицы начальными значениями
        init();
        //запускаем поиск самого быстрого пути
        run();
        //выводим результаты
        showResult();
    }

    //Метод наполния таблиц начальными значениями
    private void init() {
        for (HashMap.Entry g: graph.entrySet()) {
            //наполняем хэш таблицу отметок посещений
            visited.put(g.getKey().toString(), false);

            //наполняем хэш таблицы весов узлов и родителей
            //наполняем значениями только для узлов, связанных с началом
            if (g.getKey().toString().equals("beg")){
                for (HashMap.Entry beg: graph.get("beg").entrySet()) {
                    // вес узлов устанавливаем равным весу ребер
                    costs.put(beg.getKey().toString(), (Integer)beg.getValue());
                    //родителем узлов устанавливаем начало
                    parents.put(beg.getKey().toString(), "beg");
                }
            } else{//для не связанных с началом
                //вес устанавливаем бесконечность
                costs.put(g.getKey().toString(), INFINITY);
                //устанавливаем пустого родителя
                parents.put(g.getKey().toString(), NO_NODE);
            }
        }

    }

    //Метод поиска самого быстрого пути
    private void run() {
        //сохраняем узел с наименьшей стоимостью среди необработанных
        String nodeKey = findLowestCostNode(costs);
        //крутим цикл пока не обработаны все узлы
        while(!nodeKey.equals(NO_NODE)){
            //запоминаем вес текущего узла
            Integer cost = costs.get(nodeKey);
            //Перебираем всех соседей текущего уэла
            HashMap<String, Integer> neighbors = graph.get(nodeKey);
            for (HashMap.Entry n: neighbors.entrySet()) {
                //вычисляем новую стоимость узла
                int new_cost = cost + (Integer) n.getValue();
                //Если к соседу можно быстрее добраться через текущий узел
                if(costs.get(n.getKey().toString()) > new_cost){
                    //обновим стоимость для этого уэпа
                    costs.replace(n.getKey().toString(), new_cost);
                    //Этот уэел становится новым родителем для соседа
                    parents.replace(n.getKey().toString(), nodeKey);
                }
            }
            //Узел помечается как обработанный
            visited.replace(nodeKey, true);
            //Находим следующий узел для обработки и повторяем цикл
            nodeKey = findLowestCostNode(costs);
        }
    }

    //Метод ищет узел с наименьшей стоимостью среди необработанных
    private String findLowestCostNode(HashMap<String, Integer> costs){
        //устанавливаем начальные значения для того, что ищем
        int lowestCost = INFINITY;
        String lowestCostNodeKey = NO_NODE;
        //перебираем стоимости всех узлов
        for (HashMap.Entry node: costs.entrySet()) {
            //сохраняем текущее значение веса узла
            int cost = (Integer) node.getValue();
            //если узел еще не посещен и он с наименьшей стоимостью из уже проверенных
            String key = node.getKey().toString();
            if(!visited.get(key) && cost < lowestCost){
                //устанавливаем новое значение самой низкой стоимости узла
                lowestCost = (Integer) node.getValue();
                //назначаем его новым узлом с наименьшей стоимостью
                lowestCostNodeKey = node.getKey().toString();
            }
        }
        //возвращаем узел с наименьшей от начала стоимостью
        return lowestCostNodeKey;
    }

    //Метод вывода результата в консоль
    private void showResult() {
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        String string = "The lowest cost way has been found!\n" + "Cost: " + costs.get("end") +
                "\nThe way: ";
        sb.append(string);
        stack = getParent("end", stack);
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    //Рекурсивный метод возвращает родителя узла
    /*private String getParent(String nodeKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(nodeKey);

        //базовый случай рекурсии - дошли до начала
        if(parents.get(nodeKey).equals("beg")){
            return "beg --> ";
        }
        sb.append(getParent(parents.get(nodeKey))).append(" --> ");
        return sb.toString();
    }*/
    private Stack getParent(String nodeKey, Stack stack) {
        stack.push(" --> " + nodeKey);

        //базовый случай рекурсии - дошли до начала
        if(parents.get(nodeKey).equals("beg")){
            stack.push("beg");
            return stack;
        }
        stack = getParent(parents.get(nodeKey), stack);
        return stack;
    }

    @Override
    public String toString() {
        return "DijkstraA1{" +
                "\ngraph=" + graph +
                "\ncosts=" + costs +
                "\nparents=" + parents +
                "\nvisited=" + visited +
                "\n}";
    }
}
