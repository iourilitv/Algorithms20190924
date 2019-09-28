package lesson1.searching;

import java.io.PrintWriter;
import java.util.*;

/**
 * Тема. Бинарный поиск.
 * https://algocode.ru/page/c-2-binary-search/
 * @author of the update Litvinenko Yuriy
 * Задачи.
 * Принять в консоль целочисленные значения(через пробел):
 * n - размер массива и value - искомый элемент.
 * DONE 1.1. Создать целочисленном массив со случайными значениями в диапазоне 0 <= arr[i] <= n;
 * DONE 1.2. Отсортировать целочисленный массив.
 * DONE 1.3. Добавить в процесс сортировки решение задач 2.х.
 * DONE 2.1. Найти индекс первого числа, равного value в отсортированном целочисленном массиве.
 * Вывести индекс найденного числа в массиве или -1, если его нет.
 * DONE 2.2. Найти индекс последнего числа, равного value в отсортированном целочисленном массиве.
 * Вывести индекс найденного числа в массиве или -1, если его нет.
 * DONE 2.3. Найти количество совпадений с value в отсортированном целочисленном массиве.
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

            //1.1. Создаем и наполняем массив
            int[] intArray = createRandomIntArray(n, out);

            //1.2. Просто сортируем массив методом пузырков//FIXME
            int[] intArray2 = sortRandomIntArray(intArray, out);

            //1.3. Исследуем массив непосредственно в процессе сортировки
            intArray = sortAndSearchRandomIntArray(intArray, value, out);

            //2.1 - ищем индекс первого совпадения
            int lowIndex = binarySearchingInIntArray1(intArray2, value, out);
            //out.println("Task 2.1. value: " + value + " >> lowIndex: " + lowIndex);

            //2.2 - ищем индекс последнего совпадения
            int highIndex = binarySearchingInIntArray2(intArray, value, out);
            //out.println("Task 2.2. value: " + value + " = result индекс: " + highIndex);

            //2.3. Вычисляем количество совпадений
            int number = calculateMatchingNumber(lowIndex, highIndex, value, out);
            //out.println("\nTask 2.3. value: " + value + " >> number of coincidences: " + number);

            out.println();
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
        out.println("Task 1.1. Random array.\n" + Arrays.toString(intArray));
        out.flush();

        return intArray;
    }

    /**
     * Метод пузырьковой сортировки целочисленного массива, заполненного случайными значениями.//FIXME
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return - отсортированный (по возрастанию) массив, заполненный случайными целочисленными
     * значениями от 0 до n
     */
    private static int[] sortRandomIntArray(int[] array, PrintWriter out) {
        int temp;

        //TODO временно
        out.println("Task 1.2. Sorted array.");
        out.flush();

        //перебираем массив массив элементами по-порядку
        //просто в сотрировке не нужно проверять последний элемент, поэтому array.length - 1 вместо array.length
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[i]){
                    //FIXME если сделать не статик, то можно убрать в отдельный метод swap() - поменять местами элементы
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
        out.println("\nTask 1.3. Sorted array.");
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
     * Метод поиска первого совпадающего элемента в отсортированном int массиве
     * @param array int массив
     * @param value int элемент поиска
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return Индекс первого совпадающего элемента, если нет - -1
     */
    private static int binarySearchingInIntArray1(int[] array, int value, PrintWriter out){
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

        //TODO временно
        out.println("\nTask 2.1. Binary searching the index of the first matching.");
        out.println("value: " + value);
        out.flush();

        //инициируем переменную было ли совпадение
        boolean isValue = false;
        //индекс проверяемого элемента
        int halfIndex;
        //крутим цикл пока не найдем совпадение или разница между мин. и макс.индексами не станет меньше или равна 1
        while(highIndex - lowIndex > 1) {

            //TODO временно
            out.print(i++ + ": ");
            out.flush();

            //вычисляем индекс середины
            halfIndex = lowIndex + (highIndex - lowIndex) / 2;

            //TODO временно
            out.println("array[" + halfIndex + "]: " + array[halfIndex]);
            out.flush();

            //сравниваем больше ли элемент массива, чем входной элемент
            if(array[halfIndex] > value){
                //если больше, сдвигаем верхнюю границу проверяемой области
                highIndex = halfIndex;
            } else if(array[halfIndex] < value){
                //если меньше, сдвигаем нижнюю границу проверяемой области
                lowIndex = halfIndex;
            } else {
                //если равно, то первое совпадение - или здесь, или слева, тогда
                //сдвигаем верхнюю границу проверяемой области
                highIndex = halfIndex;
                //устанавливаем значение "было совпадение"
                isValue = true;
            }
        }

        // если было совпадение с проверяемым элементом,
        if(isValue){

            //TODO временно
            out.println("Index of the first matching: " + highIndex);

            //возвращаем его индекс
            return highIndex;
        }

        //TODO временно
        out.println("No matching! " + "array[lowIndex:" + lowIndex + "]: " + array[lowIndex] +
                ". array[highIndex:" + highIndex + "]: " + array[highIndex]);
        out.flush();

        return -1;
    }

    /**
     * Метод поиска последнего совпадающего элемента в отсортированном int массиве
     * @param array - int массив
     * @param value - int элемент поиска
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return Индекс последнего совпадающего элемента, если нет - -1
     */
    private static int binarySearchingInIntArray2(int[] array, int value, PrintWriter out){
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

        //TODO временно
        out.println("\nTask 2.2. Binary searching the index of the last matching.");
        out.println("value: " + value);
        out.flush();

        //инициируем переменную было ли совпадение
        boolean isValue = false;
        //индекс проверяемого элемента
        int halfIndex;
        //крутим цикл пока не найдем совпадение или разница между мин. и макс.индексами не станет меньше или равна 1
        while(highIndex - lowIndex > 1) {

            //TODO временно
            out.print(i++ + ": ");
            out.flush();

            //вычисляем индекс середины
            halfIndex = lowIndex + (highIndex - lowIndex) / 2;

            //TODO временно
            out.println("array[" + halfIndex + "]: " + array[halfIndex]);
            out.flush();

            //сравниваем больше ли элемент массива, чем входной элемент
            if(array[halfIndex] > value){
                //если больше, сдвигаем верхнюю границу проверяемой области
                highIndex = halfIndex;
            } else if(array[halfIndex] < value){
                //если меньше, сдвигаем нижнюю границу проверяемой области
                lowIndex = halfIndex;
            } else {
                //если равно, то последнее совпадение - или здесь, или справа, тогда
                //сдвигаем нижнюю границу проверяемой области
                lowIndex = halfIndex;
                //устанавливаем значение "было совпадение"
                isValue = true;
            }
        }

        // если было совпадение с проверяемым элементом,
        if(isValue){

            //TODO временно
            out.println("Index of the last matching: " +lowIndex);

            //возвращаем его индекс
            return lowIndex;
        }

        //TODO временно
        out.println("No matching! " + "array[lowIndex:" + lowIndex + "]: " + array[lowIndex] +
                ". array[highIndex:" + highIndex + "]: " + array[highIndex]);
        out.flush();

        return -1;
    }

    /**
     * Метод вычисления количества совпадений
     * @param lowIndex - индекс первого совпадающего элемента, если нет - -1
     * @param highIndex - индекс последнего совпадающего элемента, если нет - -1
     * @param value - int элемент поиска
     * @param out - объект принтера(не печатает без out.flush();!)
     * @return количество совпадений или -1, если нет совпадений
     */
    private static int calculateMatchingNumber(int lowIndex, int highIndex, int value, PrintWriter out) {
        int number;

        //TODO Временно
        out.println("\nTask 2.3. value: " + value);

        //если совпадений нет, то возвращаем -1
        if(lowIndex == -1 || highIndex == -1){

            //TODO Временно
            out.println("***No matching!***");

            number = -1;
        } else{
            //вычисляем количество совпадений
            number = highIndex - lowIndex + 1;

            //TODO Временно
            out.println("Number of coincidences: " + number);
        }
        out.flush();

        return number;
    }
}
