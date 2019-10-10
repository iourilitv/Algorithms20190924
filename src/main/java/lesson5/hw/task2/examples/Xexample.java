package lesson5.hw.task2.examples;

/**
 * «Задача о рюкзаке» с помощью рекурсии.
 * http://qaru.site/questions/358910/how-do-i-solve-the-classic-knapsack-algorithm-recursively
 * Решение без рекурсии.
 */
public class Xexample {
    public static void main(String[] args) {
        //массив весов предметов
        int[] values = new int[] {894, 260, 392, 281, 27};
        //массив ценностей предметов
        int[] weights = new int[] {8, 6, 4, 0, 21};
        //вместимость рюкзака по весу
        int W = 30;
        //итоговый массив рюкзака, упакованного предметами
        int[] tab = new int[W + 1];
        //выводим
        System.out.println(knapsack(values, weights, W, tab, 0));
    }

    /**
     * Метод
     * @param values - массив ценностей предметов
     * @param weights - массив весов предметов
     * @param W - вместимость рюкзака по весу
     * @param tab -
     * @param i - текущее значение счетчика
     * @return -
     */
    static int knapsack(int[] values, int[] weights, int W, int[] tab, int i) {
        //если счетчик дошел до конца массива ценностей, возвращаем 0
        if(i>=values.length) return 0;
        //если что-то нашли, возвращаем последний элемент итогового массива
        if(tab[W] != 0)
            return tab[W];
        //вычисляем первое значение
        int value1 = knapsack(values, weights, W, tab, i+1);
        int value2 = 0;
        if(W >= weights[i])
            value2 = knapsack(values, weights, W-weights[i], tab, i+1) + values[i];

        return tab[W] = (value1>value2) ? value1 : value2;
    }
}


