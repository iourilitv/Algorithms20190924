package additional.dynamic_programming;

import java.util.HashSet;

class Knapsack {
    private int capacity;//вместимость(по весу) рюкзака
    private HashSet<Thing> thingsInside;//получаем множество вещей в рюкзаке
    private int weightOfThingsInside;//суммарный вес вещей в рюкзаке
    private int costOfThingsInside;//суммарный вес вещей в рюкзаке

    /**
     * Конструктор для создания пустых рюкзаков с заданной вместимостью
     * @param capacity - вместимость(по весу) рюкзака
     */
    Knapsack(int capacity) {
        this.capacity = capacity;
        this.thingsInside = new HashSet<>();
        weightOfThingsInside = 0;
        costOfThingsInside = 0;
    }

    /**
     * Конструктор для создания копий рюкзаков с заданной вместимостью
     * @param capacity - вместимость(по весу) рюкзака
     * @param thingsInside - набор вещей в рюкзаке в виде хэш множества
     */
    Knapsack(int capacity, HashSet<Thing> thingsInside) {
        this.capacity = capacity;
        this.thingsInside = new HashSet<>(thingsInside);
        weightOfThingsInside = calculateWeightOfThingsInside(thingsInside);
        costOfThingsInside = calculateCostOfThingsInside(thingsInside);
    }

    //Метод возвращает суммарную стоимость набора вещей в соответствующей ячейке
    private int calculateCostOfThingsInside(HashSet<Thing> things) {
        int sum = 0;
        //перебираем набор вещей
        for (Thing th: things) {
            //и суммируем их стоимость
            sum += th.getCost();
        }
        return sum;
    }

    //Метод возвращает суммарную стоимость набора вещей в соответствующей ячейке
    private int calculateWeightOfThingsInside(HashSet<Thing> things) {
        int sum = 0;
        //перебираем набор вещей
        for (Thing th: things) {
            //и суммируем их стоимость
            sum += th.getWeight();
        }
        return sum;
    }

    //Метод добавления вещи в набор и песчета веса и стоимости набора
    void put(Thing thing){
        thingsInside.add(thing);
        costOfThingsInside += thing.getCost();
        weightOfThingsInside += thing.getWeight();
    }

    HashSet<Thing> getThingsInside() {
        return thingsInside;
    }

    int getWeightOfThingsInside() {
        return weightOfThingsInside;
    }

    int getCostOfThingsInside() {
        return costOfThingsInside;
    }

    @Override
    public String toString() {
        return "Knapsack{" +
                "capacity=" + capacity +
                ", thingsInside=" + thingsInside +
                ", weightOfThingsInside=" + weightOfThingsInside +
                ", costOfThingsInside=" + costOfThingsInside +
                '}';
    }
}
