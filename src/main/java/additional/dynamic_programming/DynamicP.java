package additional.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class DynamicP {
    private int precision;//точность(минимальная разница между весами вещей)
    private Thing[] rows;//массив значений строк рассчетного массива
    private int[] columns;//массив значений колонок рассчетного массива
    //рассчетный двуразмерный массив с подрюкзаками вещей
    private Knapsack[][] knapsacks;
    //получаем список вещей в виде хэш таблицы с ключами - максимальной найденой стоимостью набора и
    // объектов вещей с их параметрами
    private HashMap<String, Thing> things;
    private Knapsack finalKnapsack;

    DynamicP(int precision, HashMap<String, Thing> things) {
        this.precision = precision;
        this.things = things;
        init();
        fillKnapsacks();
    }

    //Метод инициализации массива и его составляющих для поиска
    private void init(){
        //инициализируем массив колонок с весами подрюкзаков с шагом равным точности
        createColumns();
        //инициализируем массив строк(вещей)
        createRows();
        //инициируем массив выбранных наборов вещей
        knapsacks = new Knapsack[rows.length][columns.length];
    }

    //инициализируем массив строк(вещей)
    private void createRows() {
        rows = new Thing[things.size()];
        int i = 0;
        //копируем список вещей
        for (HashMap.Entry<String, Thing> th: things.entrySet()) {
            rows[i++] = th.getValue();
        }
    }

    //Метод иницилизирует массив колонок с весами подрюкзаков с шагом равным точности
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

    //Метод находит минимальное и максимальное значение веса заданных вещей
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

    //Метод поиска лучшего набора вещей, чтобы положить в рюкзак
    private void fillKnapsacks() {
        //TODO временно
        System.out.println("columns: " + Arrays.toString(columns));

        //перебираем последовательно все вещи
        for (int i = 0; i < rows.length; i++) {
            //перебираем последовательно все подрюкзаки с дискретной вместимостью
            for (int j = 0; j < columns.length; j++) {
                //**в начале расчет немного другой**
                if(i == 0){
                    //записываем в ячейку хэш множество с пустым набором вещей
                    knapsacks[i][j] = new Knapsack(columns[j], new HashSet<>());
                    //если текущая колонка меньше веса текущей вещи
                    if(columns[j] >= rows[i].getWeight()){
                        //добавляем текущую вещь в набор выбранных вещей
                        knapsacks[i][j].put(rows[i]);
                    }
                //**для остальных не начальных случаев**
                //если вес текущей вещи больше вместимости подрюкзака
                } else if(columns[j] < rows[i].getWeight()){
                    //сохраняем в ячейку ссылку на предыдущий набор для этого веса рюкзака
                    knapsacks[i][j] = knapsacks[i - 1][j];
                //если вес текущей вещи не больше вместимости подрюкзака
                } else if(columns[j] >= rows[i].getWeight()){
                    //вычисляем вес остатка вместимости текущего подрюкзака после
                    // вычитания веса текущей вещи
                    int remainWeight = columns[j] - rows[i].getWeight();
                    //находим набор вещей в подрюкзаке подходящего веса
                    Knapsack maxCostCurrentKnapsack = getMaxCostSubknapsack(knapsacks[i - 1], remainWeight);
                    //находим текущую стоимость, как сумму стоимости текущей вещи и найденной
                    // максимальной стоимостью набора вещей, влезающего в подрюкзак
                    int currentCost = rows[i].getCost() + maxCostCurrentKnapsack.getCostOfThingsInside();
                    //вычисляем суммарную стоимость вещей в текущем подрюкзаке после проверки предыдущей
                    int preSubknapsackCost = (knapsacks[i - 1][j].getCostOfThingsInside());
                    //если суммарная стоимость текущей вещи и найденной максимальной стоимости набора вещей с
                    // весом равным остатку веса в подрюкзаке больше суммарной стоимости вещей
                    // в текущем подрюкзаке после проверки предыдущей вещи
                    if(currentCost > preSubknapsackCost){
                        //записываем новый набор вещей в текущую ячейку
                        knapsacks[i][j] = new Knapsack(columns[j], maxCostCurrentKnapsack.getThingsInside());
                        //добавляем текущую вещь
                        knapsacks[i][j].put(rows[i]);
                    } else{ // если меньше
                        //сохраняем в ячейку ссылку на предыдущий набор для этого веса рюкзака
                        knapsacks[i][j] = knapsacks[i - 1][j];
                    }
                }
            }

            //TODO временно
            System.out.println("rows[" + i + "]=" + rows[i] + ": " + Arrays.toString(knapsacks[i]));
        }
        //итоговый наполненный вещами рюкзак
        finalKnapsack = new Knapsack(columns[columns.length - 1],
                knapsacks[rows.length - 1][columns.length - 1].getThingsInside());
    }

    //Метод возвращаем максимальную стоимость набора вещей, которые можно впихнуть в подрюкзак
    // с заданной вместимостью
    private Knapsack getMaxCostSubknapsack(Knapsack[] sets, int weight) {
        Knapsack set = new Knapsack(0, new HashSet<>());
        //перебираем подмассив подрюкзаков
        for (int i = 0; i < sets.length; i++) {
            //если колонка веса подрюкзака совпадает с проверяемым весом
            if(columns[i] == weight){
                //присваиваем временной переменной набор вещей в соответствующей ячейке
                set = sets[i];
            }
        }
        return set;
    }

    Knapsack getResultKnapsack() {
        return finalKnapsack;
    }

}
