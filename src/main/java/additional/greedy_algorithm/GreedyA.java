package additional.greedy_algorithm;

import java.util.HashMap;
import java.util.HashSet;

class GreedyA {
    private final String NO_STATION = "NO_STATION";//константа - нет радиостанции
    private final HashMap<String, HashSet<String>> stations;
    private HashSet<String> finalStations = new HashSet<>();
    private HashSet<String> statesNeeded;//оставшиеся штаты, требующие покрытия

    GreedyA(HashMap<String, HashSet<String>> stations, HashSet<String> states) {
        this.stations = stations;
        statesNeeded = new HashSet<>(states);
        findBestStations();
    }

    private void findBestStations(){
        //Цикл продолжается, пока множество неохваченных штатов не станет пустым
        while(!statesNeeded.isEmpty()) {
            //станция, которая обслуживает больше всего штатов
            String bestStation = NO_STATION;
            //Покрытие лучшей станции. Содержит все штаты, обслуживаемые этой станцией,
            //которые еще не входят в текущее покрытие
            HashSet<String> bestStationCovered = new HashSet<>();
            //перебираем все станции, чтобы найти среди них наилучшую
            // (с наибольшим покрытием из оставшихся неохваченных штатов?)
            for (HashMap.Entry s : stations.entrySet()) {
                //инициируем копию списка покрытия радиостанцией
                HashSet<String> covered = new HashSet<>((HashSet<String>) s.getValue());
                //ищем пересечение множеств - останется только множество штатов, не получивших еще
                // покрытия другими станциями и которые покрываются текущей станцией
                covered.retainAll(statesNeeded);
                //если покрытие текущей станции больше, чем лучшая из проверенных станций,
                if (covered.size() > bestStationCovered.size()) {
                    //то сохраняем ее как лучшую на этот момент
                    bestStation = s.getKey().toString();
                    //и сохраняем ее покрытие как покрытие лучшей станцией
                    bestStationCovered = covered;
                }
            }
            //вычитаем покрытие найденной лучшей станции из оставшихся штатов, требующих покрытия
            statesNeeded.removeAll(bestStationCovered);
            //сохраняем найденную лучшую станцию в конечный список станций
            finalStations.add(bestStation);
        }
    }

    //TODO временно
    //геттер для получения результата
    HashSet getResult() {
        return finalStations;
    }

    //TODO временно
    /*private void init() {
        for (HashMap.Entry s: stations.entrySet()) {
            finalStations.add(s.getKey().toString());
        }

    }*/

    //TODO временно
    /*HashSet<String> getResult() {
        HashSet<String> res = new HashSet<>(statesNeeded);
        //res: [or, mt, nv, az, wa, id, ca, ut]

        //ищем пересечение множеств (res & Set(kfive))
        res.retainAll(stations.get("kfive"));
        //res: [az, ca]

        //вычитаем второе множество из первого (res - Set(kfive))
        //res.removeAll(stations.get("kfive"));
        //res: [or, mt, nv, wa, id, ut]
        return res;
    }*/
}
