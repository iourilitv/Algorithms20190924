package lesson1.searching;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Тема. Бинарный поиск.
 * https://algocode.ru/page/c-2-binary-search/
 */
public class BinarySearch {
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
                value = in.nextInt();// ok: 0, 3, 18, 50, 98, 100, 102, 173, 198, 199
            } while(n < 1);
            //Создаем и наполняем массив
            int[] intArray = initGame(n, out);

            //Вычисляем результат проверки
            int result = binarySearchingInIntArray(intArray, value, out);
            out.println("value: " + value + " = result индекс: " + result);
            out.flush();
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
     * Метод инициализации теста.
     * @param n - размер массива
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return - заполненный массив
     */
    private static int[] initGame(int n, PrintWriter out) {
        //Инициируем массив заданного размера
        int[] intArray = new int[n];
        //наполняем массив элементами по-порядку
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 2;
        }

        //TODO временно
        out.println(Arrays.toString(intArray));
        out.flush();

        return intArray;
    }

    /**
     * Метод поиска элемента в отсортированном int массиве
     * @param array int массив
     * @param value int элемент поиска
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return Индекс совпадающего элемента, если нет - -1
     */
    public static int binarySearchingInIntArray(int[] array, int value, PrintWriter out){
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
                lowIndex = halfIndex;;
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
