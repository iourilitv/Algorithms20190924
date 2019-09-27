package lesson1.searching;

import java.io.PrintWriter;
import java.util.*;

/**
 * Тема. Бинарный поиск.
 * https://algocode.ru/page/c-2-binary-search/
 * @author of the update Litvinenko Yuriy
 * Задача 1.
 * Принять в консоль целочисленные значения(через пробел):
 * n - размер массива и value - искомый элемент.
 * Создать целочисленном массив со случайными значениями в диапазоне 0 <= arr[i] <= n;
 * Отсортировать целочисленный массив.
 * Найти индекс первого числа, равного value в отсортированном целочисленном массиве.
 * Вывести индекс найденного числа в массиве или -1, если его нет.
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        //TODO Important! Сканер после принятия строки все остальное будет принимать тоже как строку!
        // Поэтому требуются отдельные сканеры на int и String
        Scanner inQ = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        PrintWriter out = new PrintWriter(System.out);

        //Крутим цикл пока не поступит команда выйти (ввести q);
        while(!isExit(inQ, out)) {
            int n;
            int value;
            //В бесконечном цикле принимаем с проверкой значения
            do {
                out.println("Input the size of array. It must be integer and more than 0!");
                out.flush();
                //Принимаем значение размера массива
                n = in.nextInt();
                //Принимаем значение входного элемента
                value = in.nextInt();
            } while(n < 1);
            //Создаем и наполняем массив
            int[] intArray = createRandomIntArray(n, out);
            //Сортируем массив
            //intArray = sortRandomIntArray(intArray, out);
            //Исследуем массив непосредственно в процессе сортировки
            intArray = sortAndSearchRandomIntArray(intArray, value, out);

            //Вычисляем результат проверки
//            int result = binarySearchingInIntArray(intArray, value, out);
//            out.println("value: " + value + " = result индекс: " + result);
//            out.flush();
        }
        //Закрываем входные и выходной ресурсы
        in.close();
        inQ.close();
        out.close();
    }

    /**
     * Метод проверки "не пора ли на выход"?
     * @param inQ - объект сканера
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return true - да пора на выход
     */
    private static boolean isExit(Scanner inQ, PrintWriter out) {
        out.println("To continue press <Enter>, to exit - q.");
        out.flush();
        //Принимаем код выхода и возвращаем true, если первая буква - q
        return inQ.nextLine().startsWith("q");
    }

    /**
     * Метод создания целочисленного массива, заполненного случайными значениями.
     * @param n - размер массива
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return - массив, заполненный случайными целочисленными значениями от 0 до n
     */
    private static int[] createRandomIntArray(int n, PrintWriter out) {
        Random random = new Random();
        //Инициируем массив заданного размера
        int[] intArray = new int[n];
        //наполняем массив элементами по-порядку
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(n);
        }

        //TODO временно
        out.println(Arrays.toString(intArray));
        out.flush();

        return intArray;
    }

    /**
     * Метод сортировки целочисленного массива, заполненного случайными значениями.
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return - отсортированный (по возрастанию) массив, заполненный случайными целочисленными
     * значениями от 0 до n
     */
    private static int[] sortRandomIntArray(int[] array, PrintWriter out) {
        int temp;

        //TODO временно
        out.println("array.length: " + array.length);
        out.flush();

        //перебираем массив массив элементами по-порядку
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        //TODO временно
        out.println(Arrays.toString(array));
        out.flush();

        return array;
    }

    /**
     * Метод одновременной сортировки случайного целочисленного массива и поиска всех элементов,
     * совпадающих с элементом поиска.
     * @param array целочисленный массив, заполненный случайными целочисленными значениями от 0 до n
     * @param value int элемент поиска
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return - отсортированный (по возрастанию) массив, заполненный случайными целочисленными
     * значениями от 0 до n
     */
    private static int[] sortAndSearchRandomIntArray(int[] array, int value, PrintWriter out) {
        int temp;
        //устанавливаем начальное значение минимального индекса для найденных элементов(самого левого)
        int lowIndex = -1;
        //устанавливаем начальное значение максимального индекса для найденных элементов(самого правого)
        int highIndex = array.length;

        //TODO временно
        out.println("array.length: " + array.length);
        out.flush();

        //перебираем массив массив элементами по-порядку
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            // елемент совпадает с элементом поиска
            if(array[i] == value) {
                // и если это первый найденный элемент
                if (lowIndex == -1) {
                    // то запоминаем его индекс, как начало диапазона сопадающих элементов
                    // (т.к. в ячейке самый маленький элемент)
                    lowIndex = i;
                    highIndex = lowIndex;
                } else {
                    //но если это не первый найденный элемент, то инкрементируем правый индекс,
                    // как конец диапазона сопадающих элементов
                    highIndex++;
                }
            }
        }

        //TODO временно
        out.println(Arrays.toString(array));
        out.println("value: " + value);
        if(lowIndex == -1){
            out.println("***There is no matching!***");
        } else {
            out.println("The count of matching: " + (highIndex - lowIndex + 1));
            out.println("Index of the first matching: " + lowIndex + ". Index of the last matching: " + highIndex);
        }
        out.flush();

        return array;
    }

    /**
     * Метод поиска элемента в отсортированном int массиве
     * @param array int массив
     * @param value int элемент поиска
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return Индекс совпадающего элемента, если нет - -1
     */
    private static int binarySearchingInIntArray(int[] array, int value, PrintWriter out){
        //устанавливаем начальную нижнюю границу проверяемой области(специально за областью)
        int lowIndex = -1;
        //устанавливаем начальную верхнюю границу проверяемой области(специально за областью)
        int highIndex = array.length;
        //проверяем входит ли элемент в диапазон массива
        if(value < array[lowIndex + 1] || array[highIndex - 1] < value){
            //выходим с негативным результатом, если не входит
            return -1;
        }

        //TODO временно
        int i = 1;

        //индекс проверяемого элемента
        int halfIndex;
        //крутим цикл пока не найдем совпадение или разница между мин. и макс.индексами не станет меньше или равна 1
        while(highIndex - lowIndex > 1) {

            //TODO временно
            out.print(i++ + ": ");
            out.flush();

            //вычисляем индекс середины
            halfIndex = (highIndex + lowIndex) / 2;

            //TODO временно
            out.println("array[" + halfIndex + "]: " + array[halfIndex]);
            out.flush();

            //сравниваем больше ли элемент массива, чем входной элемент
            if(array[halfIndex] >= value){
                //если больше, сдвигаем верхнюю границу проверяемой области
                highIndex = halfIndex;
            } else{
                //если меньше, сдвигаем нижнюю границу проверяемой области
                lowIndex = halfIndex;
            }
            //если индекс макс.индекс диапазона не равен начальному значении и
            // входной элемент совпадает с проверяемым элементом,
            if(highIndex != array.length && array[highIndex] == value){
                //возвращаем его индекс
                return highIndex;
            }
        }

        //TODO временно
        out.println("No matching! " + "array[lowIndex:" + lowIndex + "]: " + array[lowIndex] + ". array[highIndex:" + highIndex + "]: " + array[highIndex]);
        out.flush();

        return -1;
    }
}
