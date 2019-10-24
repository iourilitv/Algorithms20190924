package additional.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class DynamicP {
    private int precision;//точность(минимальная разница между весами вещей)
    private Thing[] rows;//массив значений строк рассчетного массива
    private int[] columns;//массив значений колонок рассчетного массива
    private HashMap<Integer, HashSet<Thing>> calculator;//рассчетный хэш набор
    //получаем список вещей в виде хэш таблицы с ключами - их названиями и
    // объектов вещей с их параметрами
    private HashMap<String, Thing> things;

    DynamicP(int precision, HashMap<String, Thing> things) {
        this.precision = precision;
        this.things = things;
        init();
    }

    private void init(){
        createColumns();

        System.out.println("columns: " + Arrays.toString(columns));
        //rows = new Thing[things.size()];
    }

    private void createColumns() {
        int[] cols = findMinAndMaxWeight();
        int min = cols[0];
        int max = cols[1];
        columns = new int[max / precision];
        int colNum = min;
        for (int i = 0; i < columns.length; i++) {
            columns[i] = colNum;
            colNum += precision;
        }
    }

    /*private int findMaximumWeight() {
        int max = -1;
        for (Map.Entry<String, Thing> th: things.entrySet()) {
            int currentWeight = th.getValue().getWeight();
            if(max < currentWeight){
                max = currentWeight;
            }
        }
        return max;
    }*/
    private int[] findMinAndMaxWeight() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] columns = new int[2];
        for (Map.Entry<String, Thing> th: things.entrySet()) {
            int currentWeight = th.getValue().getWeight();
            if(min > currentWeight){
                min = currentWeight;
            }
            if(max < currentWeight){
                max = currentWeight;
            }
        }
        columns[0] = min;
        columns[1] = max;
        return columns;
    }
}
