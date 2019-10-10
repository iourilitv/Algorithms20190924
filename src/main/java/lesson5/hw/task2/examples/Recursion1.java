package lesson5.hw.task2.examples;

/**
 * «Задача о рюкзаке» с помощью рекурсии.
 * Пример решения.
 * http://qaru.site/questions/358910/how-do-i-solve-the-classic-knapsack-algorithm-recursively
 */
public class Recursion1 {
    static int W = 30;//Вместимость рюкзака по весу, она же текущий остаток вместимости
    static int[] weights = new int[] {8, 6, 4, 0, 21};//Массив весов предметов
    static int[] values = new int[] {894, 260, 392, 281, 27};//Массив ценностей предметов

    private static int count;//TODO временно

    private static int knapsack(int i, int W) {
        //TODO временно
        System.out.println("knapsack #" + count++ + ".");
//        if(i < 0){
//            System.out.print("weights[" + i + "]: " + "ERR" + ". W: " + W + "\n");
//        } else{
//            System.out.print("weights[" + i + "]: " + weights[i] + ". W: " + W + "\n");
//        }

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
//The original.
//public class Recursion1 {
//    static int[] values = new int[] {894, 260, 392, 281, 27};
//    static int[] weights = new int[] {8, 6, 4, 0, 21};
//    static int W = 30;
//
//    private static int knapsack(int i, int W) {
//        if (i < 0) {
//            return 0;
//        }
//        if (weights[i] > W) {
//            return knapsack(i-1, W);
//        } else {
//            return Math.max(knapsack(i-1, W), knapsack(i-1, W - weights[i]) + values[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(knapsack(values.length - 1, W));}
//}