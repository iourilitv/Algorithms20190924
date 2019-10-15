package lesson6.hw;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 6. Деревья
 * Рассмотрим работу с двоичными деревьями.
 * Homework.
 * @author Yiriy Litvinenko
 * DONE 1. Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев, представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
 * DONE 2. Проанализировать, какой процент созданных деревьев являются несбалансированными.
 */
public class MainLess6hw {
    public static void main(String[] args) {
        //Создаем одно дерево с высотой 1
//        TreesMaker treesMaker = new TreesMaker();

        //Создаем одинаковые деревья с высотой 6
        int numberOfTrees = 20;//количество деревьев
        int maxTreeHeight = 6;//заданная высота деревьев
        TreesMaker treesMaker = new TreesMaker(numberOfTrees, maxTreeHeight);

        //создаем деревья с разной высотой
//        int[] treesHeights = {5, 1, 3, 6, 10};//количество деревьев
//        TreesMaker treesMaker = new TreesMaker(treesHeights);

    }
}
