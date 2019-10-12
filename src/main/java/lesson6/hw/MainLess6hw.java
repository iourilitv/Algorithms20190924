package lesson6.hw;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 6. Деревья
 * Рассмотрим работу с двоичными деревьями.
 * Homework.
 * @author Yiriy Litvinenko
 * 1. Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */
public class MainLess6hw {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> mtm = new MyTreeMap<>();

        mtm.put(5,"five");
        mtm.put(1,"one");
        mtm.put(3,"tree");
        mtm.put(4,"four");
        mtm.put(2,"two");

        System.out.println(mtm.get(2));
        mtm.put(2,"two2222");

        System.out.println(mtm.get(2));
        System.out.println(mtm);

        mtm.delete(3);
        System.out.println(mtm);

    }
}
