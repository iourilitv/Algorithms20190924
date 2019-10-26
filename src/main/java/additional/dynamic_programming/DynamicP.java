package additional.dynamic_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DynamicP {
    private int precision;//точность(минимальная разница между весами вещей)
    private Thing[] rows;//массив значений строк рассчетного массива
    private int[] columns;//массив значений колонок рассчетного массива
    //рассчетный двуразмерный массив с подрюкзаками вещей
    private Knapsack[][] knapsacks;
    //получаем список вещей в виде хэш таблицы с ключами - названия вещи и
    // значениями - хэш множествами объектов вещей
    private HashMap<String, Thing> things;
    private Knapsack finalKnapsack;

    /**
     * Конструктор с заданной точности
     * @param precision - заданная точность(шаг весов подрюкзаков)
     * @param things - список вещей в виде хэш таблицы с ключами - названия вещи и
     *                  значениями - хэш множествами объектов вещей
     */
    DynamicP(int precision, HashMap<String, Thing> things) {
        this.precision = precision;
        this.things = things;
        init();
        fillKnapsacks();
    }

    /** //FIXME
     * Конструктор без заданной точности
     * @param things - список вещей в виде хэш таблицы с ключами - названия вещи и
     *                  значениями - хэш множествами объектов вещей
     */
    DynamicP(HashMap<String, Thing> things) {
        this.precision = calculatePrecision(); //FIXME //double required
        this.things = things;
        init();
        fillKnapsacks();
    }

    /** //FIXME //double required
     * Метод расчета точности(шага весов подрюкзаков)
     * @return - расчитанное значение точности
     */
    private int calculatePrecision() {
        int pre = 1;
        return pre;
    }

    /**
     * Метод инициализации массива и его составляющих для поиска
     */
    private void init(){
        //инициализируем массив колонок с весами подрюкзаков с шагом равным точности
        createColumns();
        //инициализируем массив строк(вещей)
        createRows();
        //инициируем массив выбранных наборов вещей
        knapsacks = new Knapsack[rows.length][columns.length];
    }

    /**
     * Метод инициализирует массив строк, наполненный объектами вещей.
     * Это требуется для организации массива подрюкзаков.
     */
    private void createRows() {
        rows = new Thing[things.size()];
        int i = 0;
        //копируем список вещей
        for (HashMap.Entry<String, Thing> th: things.entrySet()) {
            rows[i++] = th.getValue();
        }
    }

    /**
     * Метод иницилизирует массив колонок с весами подрюкзаков с шагом равным точности.
     * Это требуется для организации массива подрюкзаков.
     */
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

    /**
     * Метод находит минимальное и максимальное значение веса заданных вещей
     * @return массив с минимальным и максимальным значением веса заданных вещей
     */
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

    /**
     * Метод поиска лучшего набора вещей, чтобы положить в рюкзак
     */
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
                    knapsacks[i][j] = new Knapsack(columns[j]);
                    //если текущая колонка меньше веса текущей вещи
                    if(columns[j] >= rows[i].getWeight()){
                        //добавляем текущую вещь в набор выбранных вещей
                        knapsacks[i][j].put(rows[i]);
                    }
                //**для остальных не начальных случаев**
                //если вес текущей вещи больше вместимости подрюкзака
                } else if(columns[j] < rows[i].getWeight()){
                    //создаем новый рюкзак с копией предыдущего набора для этого веса рюкзака
                    knapsacks[i][j] = new Knapsack(columns[j], knapsacks[i - 1][j].getThingsInside());

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
                        //создаем новый рюкзак с копией предыдущего набора для этого веса рюкзака
                        knapsacks[i][j] = new Knapsack(columns[j], knapsacks[i - 1][j].getThingsInside());
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

    /**
     * Метод возвращаем подрюкзак с максимальной стоимостью набора вещей, которые можно впихнуть в подрюкзак
     * с заданной вместимостью
     * @param knapsacks - все подрюкзаки в строке массива подрюкзаков
     * @param weight - вес искомого подрюкзака
     * @return рюкзак в виде хэш множества
     */
    private Knapsack getMaxCostSubknapsack(Knapsack[] knapsacks, int weight) {
        //перебираем подмассив подрюкзаков
        for (int i = 0; i < knapsacks.length; i++) {
            //если колонка веса подрюкзака совпадает с проверяемым весом
            if(columns[i] == weight){
                //присваиваем временной переменной набор вещей в соответствующей ячейке
                return knapsacks[i];
            }
        }
        //создаем пустой рюкзак, чтобы не выскакивало исключение на этапе сравнения рюкзаков, если null
        return new Knapsack(weight);
    }

    /**
     * Метод возвращает итоговый рюкзак
     * @return рюкзак с набором подобранного набора вещей
     */
    Knapsack getResultKnapsack() {
        return finalKnapsack;
    }

}
