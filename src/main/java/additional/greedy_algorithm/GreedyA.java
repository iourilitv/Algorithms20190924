package additional.greedy_algorithm;

import java.util.HashMap;
import java.util.HashSet;

class GreedyA {
    private final HashMap<String, HashSet<String>> stations;
    private final HashSet<String> statesNeeded;
    private HashSet<String> finalStations = new HashSet<>();

    GreedyA(HashMap<String, HashSet<String>> stations, HashSet<String> statesNeeded) {
        this.stations = stations;
        this.statesNeeded = statesNeeded;
        init();

    }

    //TODO временно
    private void init() {
        for (HashMap.Entry s: stations.entrySet()) {
            finalStations.add(s.getKey().toString());
        }

    }

    //TODO временно
    HashSet getResult() {
        return finalStations;
    }
}
