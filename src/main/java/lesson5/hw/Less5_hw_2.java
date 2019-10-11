package lesson5.hw;

import java.util.Arrays;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 * Описание задачи:
 * https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%80%D1%8E%D0%BA%D0%B7%D0%B0%D0%BA%D0%B5
 * Задача о рюкзаке (англ. Knapsack problem) — дано N предметов, ni предмет имеет массу wi>0 и стоимость pi>0.
 * Необходимо выбрать из этих предметов такой набор, чтобы суммарная масса не превосходила
 * заданной величины W (вместимость рюкзака), а суммарная стоимость была максимальна.
 * Ограниченный рюкзак (англ. Bounded Knapsack Problem): не более заданного числа экземпляров каждого предмета.
 * https://neerc.ifmo.ru/wiki/index.php?title=Meet-in-the-middle
 * Классической задачей является задача о наиболее эффективной упаковке рюкзака. Каждый предмет характеризуется
 * весом (wi⩽109) и ценностью (costi⩽109). В рюкзак, ограниченный по весу, необходимо набрать вещей с
 * максимальной суммарной стоимостью.
 * Для ее решения изначальное множество вещей N разбивается на два равных(или примерно равных) подмножества,
 * для которых за приемлемое время можно перебрать все варианты и подсчитать суммарный вес и стоимость,
 * а затем для каждого из них найти группу вещей из первого подмножества с максимальной стоимостью,
 * укладывающуюся в ограничение по весу рюкзака. Сложность алгоритма O(2N2×N). Память O(2N2).
 * Алгоритм.
 * Разделим наше множество на две части. Подсчитаем все подмножества из первой части и будем хранить их
 * в массиве first. Отсортируем массив first по весу. Далее пройдемся по этому массиву и оставим только
 * те подмножества, для которых не существует другого подмножества с меньшим весом и большей стоимостью.
 * Очевидно, что подмножества, для которых существует другое, более легкое и одновременно более ценное
 * подмножество, можно удалять. Таким образом в массиве first мы имеем подмножества, отсортированные
 * не только по весу, но и по стоимости. Тогда начнем перебирать все возможные комбинации вещей
 * из второй половины и находить бинарным поиском удовлетворяющие нам подмножества из первой половины,
 * хранящиеся в массиве first.
 */
public class Less5_hw_2 {
    private static int W = 30;//Вместимость рюкзака по весу, она же текущий остаток вместимости
    private static int[] weights = new int[] {8, 6, 4, 0, 21};//Массив весов предметов
    private static int[] values = new int[] {894, 260, 392, 281, 27};//Массив ценностей предметов

    private static int count;//TODO временно

    private static int knapsack(int i, int W) {
        //TODO временно
        System.out.println("iteration #" + count++ + ".");

        if (i < 0) {
            return 0;
        }
        if (weights[i] > W) {

            //TODO временно
            System.out.print("*weights[" + i + "]: " + weights[i] + " > W: " + W + " >> first_if\n");

            int first_if = knapsack(i - 1, W);
            System.out.print("knapsack(i - 1: " + (i -1) + ", W: " + W + "). first_if: " + first_if + "\n");
            return first_if;
        } else {

            //TODO временно
            System.out.print("**weights[" + i + "]: " + weights[i] + " <= W: " + W + " >> first_else\n");

            int first_else = knapsack(i - 1, W);
            System.out.print("knapsack(i - 1: " + (i - 1) + ", W: " + W + "). first_else: " + first_else + "\n");

            System.out.print("**weights[" + i + "]: " + weights[i] + " <= W: " + W + " >> second\n");

            int second = knapsack(i - 1, W - weights[i]);
            System.out.print("knapsack(i - 1: " + (i -1) + ", W - weights[" + i + "]: " + (W - weights[i]) + ". second: " + second + "\n");
            second += values[i];
            System.out.print("second + values[" + i + "]("+ values[i] + "): " + second + "\n");
            int math_max = Math.max(first_else, second);
            System.out.println("Math.max(first_else: "+ first_else + ", second: "+ second + "): " + math_max);
            return math_max;
        }
    }

    public static void main(String[] args) {
        System.out.println(knapsack(values.length - 1, W));}
}
