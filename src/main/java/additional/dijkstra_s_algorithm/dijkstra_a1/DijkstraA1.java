package additional.dijkstra_s_algorithm.dijkstra_a1;

import java.util.HashMap;

class DijkstraA1 {
    private final Integer INFINITY = Integer.MAX_VALUE;//константа бесконечности веса

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
                parents.put(g.getKey().toString(), "NONE");
            }
        }

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
