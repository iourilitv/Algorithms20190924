package lesson2.hw.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Алгоритмы_и_структуры_данных_на_Java.БазовыйКурс. 24.09.2019 Webinar.
 * Teacher: Фанзиль Кусяпкулов
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * Домашняя работа.
 * @author Litvinenko Yuriy
 * Задачи на http://acmp.ru
 * Тема. Бинарный поиск.
 * ЗАДАЧА №523. Роман в томах (Время: 1 сек. Память: 16 Мб Сложность: 41%)
 * В романе N глав. В i-той главе ai страниц. Требуется издать роман в K томах так, чтобы объем
 * самого «толстого» тома был минимален. В каждом томе главы располагаются по порядку своих номеров.
 * Требуется написать программу, которая найдет количество страниц в самом «толстом» томе.
 * Входные данные:
 * Входной текстовый файл INPUT.TXT содержит в первой строке число N - количество глав (1 ≤ N ≤ 100).
 * Во второй строке через пробел записаны N чисел – количество страниц в каждой главе.
 * Количество страниц в романе не превышает 32767. В третьей строке записано число K (1 ≤ K ≤ N) -
 * количество томов(Из комментария: может оказаться и меньше K?).
 * Выходные данные:
 * Выходной файл OUTPUT.TXT должен содержать количество страниц в самом «толстом» томе.
 * Примеры:
 * 3        >> 3
 * 1 2 1
 * 2
 * 4        >> 2
 * 1 2 1 1
 * 3
 * Формализованная задача.
 * Найти минимально возможный объем(в страницах) самого «толстого» тома.
 * Принять количество глав(длину массива). Инициировать массив для количества страниц в каждой главе.
 * Принять значения и наполнить массив глав и одновременно найти максимальное количество страниц
 * в одной главе.
 * Принять количество томов.
 * Определить диапазон поиска:
 *  мин.значение - максимальное количество страниц в одной главе - 1,
 *  максимальное - максимальное количество страниц в одной главе * количество томов + 1.
 * Определить условие:
 * 1. Искомое значение - максимальное количество страниц в одной главе, если количество страниц
 * самой большой главы не меньше суммы страниц остальных глав.
 * 2. проверяемое количество томов, в которых возможно разместить все страницы должно быть
 *   больше заданного количества томов.
 * В бинарном поиске найти значение удовлетворяющее условию.
 */
public class Acmp0523 {
    public static void main(String[] args){
        new Task0523().run();//TODO Parameterized Test.Deleted
    }
}

class Task0523 {
    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    private int tomesNumber;//Количество томов
    //объявляем целочисленный массив с количествами страниц в каждой главе
    //private int[] chaptersArray;//TODO Parameterized Test.Deleted
    private Integer[] chaptersArray;//TODO Parameterized Test.Added
    //инициируем флаг
    boolean flag;

    //TODO Parameterized Test.Added
    public Task0523() {
    }

    //TODO Parameterized Test.Added
    public Task0523(Integer[] chaptersArray, int tomesNumber) {
        this.chaptersArray = chaptersArray;
        this.tomesNumber = tomesNumber;
    }

    //TODO Parameterized Test.Deleted
    public void run() {
        //Принимаем ширину диплома
        //Количество глав
        int chaptersNumber = in.nextInt();
        //инициируем целочисленный массив с количествами страниц в каждой главе
        chaptersArray = new Integer[chaptersNumber];//int[chaptersNumber]
        //инициируем максимальное количество страниц в одной главе
        int maxPagesNumber = -1;
        //инициируем общее количество страниц в романе
        int totalPagesSum = 0;
        //Принимаем количества страниц в главах и наполняем массив
        for (int i = 0; i < chaptersArray.length; i++) {
            chaptersArray[i] = in.nextInt();
            //ищем максимальное число страниц в главе
            if(chaptersArray[i] > maxPagesNumber){
                //если элемент в массиве больше, то сохраняем его в переменной
                maxPagesNumber = chaptersArray[i];
            }
            //приплюсовываем значение текущего элемента к переменной суммы
            totalPagesSum += chaptersArray[i];
        }

        //TODO временно
        //out.println("\n" + maxPagesNumber + ". " + totalPagesSum);
        //out.flush();

        //Принимаем количество томов
        tomesNumber = in.nextInt();

        //TODO временно
        //out.println("The calculating has started... please wait.");
        //out.flush();

        //Находим минимально возможный объем(в страницах) самого «толстого» тома
        int tomeSize = findMinAcceptableOfMaxTomeSize(maxPagesNumber, totalPagesSum);

        out.println(tomeSize);
        out.flush();
    }

    //TODO Parameterized Test.Added
    public Integer runTest() {
        //Принимаем ширину диплома
        //Количество глав
        //int chaptersNumber = in.nextInt();//TODO Parameterized Test.Deleted
        //инициируем целочисленный массив с количествами страниц в каждой главе
        //chaptersArray = new int[chaptersNumber];//TODO Parameterized Test.Deleted
        //инициируем максимальное количество страниц в одной главе
        int maxPagesNumber = -1;
        //инициируем общее количество страниц в романе
        int totalPagesSum = 0;
        //Принимаем количества страниц в главах и наполняем массив
        for (int i = 0; i < chaptersArray.length; i++) {
            //chaptersArray[i] = in.nextInt();//TODO Parameterized Test.Deleted
            //ищем максимальное число страниц в главе
            if(chaptersArray[i] > maxPagesNumber){
                //если элемент в массиве больше, то сохраняем его в переменной
                maxPagesNumber = chaptersArray[i];
            }
            //приплюсовываем значение текущего элемента к переменной суммы
            totalPagesSum += chaptersArray[i];
        }

        //TODO временно
        //out.println("\n" + maxPagesNumber + ". " + totalPagesSum);
        //out.flush();

        //Принимаем количество томов
        //tomesNumber = in.nextInt();//TODO Parameterized Test.Deleted

        //TODO временно
        //out.println("The calculating has started... please wait.");
        //out.flush();

        //Находим минимально возможный объем(в страницах) самого «толстого» тома
        int tomeSize = findMinAcceptableOfMaxTomeSize(maxPagesNumber, totalPagesSum);

        out.println(tomeSize);
        out.flush();
        return tomeSize;
    }

    /**
     * Метод нахождения минимально возможный объем(в страницах) самого «толстого» тома.
     * @param maxPagesNumber - максимальное количество страниц в одной главе
     * @param totalPagesSum - общее количество страниц в романе
     * @return минимально возможный объем(в страницах) самого «толстого» тома.
     */
    /*private int findMinAcceptableOfMaxTomeSize(int maxPagesNumber, int totalPagesSum){
        //если том 1
        if(tomesNumber == 1){
            //то возвращаем общее количество страниц в романе
            return totalPagesSum;
        }
        //если количество томов равны количеству глав или крайние элементы больше или равны суммы оставшихся
        if(tomesNumber == chaptersArray.length ||
                chaptersArray[0] >= totalPagesSum - chaptersArray[0] ||
                chaptersArray[chaptersArray.length - 1] >= totalPagesSum - chaptersArray[chaptersArray.length - 1]
        ){
            //то возвращаем максимальное количество страниц в одной главе
            return maxPagesNumber;
        }

        //Запоминаем минимально возможное количество страниц в томе
        int minSize = 0;
        //Запоминаем максимально возможное количество страниц в томе
        int maxSize = totalPagesSum + 1;
        //Объявляем переменную для средней значения
        int middleSize;
        //Объявляем переменную для искомого значения
        int minimumSize = maxSize;

        //***Бинарный поиск***
        //крутим цикл пока не сблизим края поиска до одного элемента
        while(maxSize - minSize != 1){
            //устанавливаем на середине диапазона
            middleSize = minSize + (maxSize - minSize) / 2;
            //проверяем не больше ли проверяемое значение максимального количества в одной главе и
            // выполняется ли условие с размером middleSize
            boolean result = isCondition(middleSize, totalPagesSum);
            //проверяем было ли совпадение
            if(flag){
                //если да есть хотя бы одно совпадение
                if(middleSize <= maxPagesNumber || result){
                    //minSize всегда должна указывать на ситуацию, когда условие выполняется
                    minSize = middleSize;
                    //запоминаем последнее совпавшее значение
                    if(minimumSize > middleSize){
                        minimumSize = middleSize;
                    }
                } else {
                    //maxSize всегда должна указывать на ситуацию, когда условие не выполняется
                    maxSize = middleSize;
                }
            } else{
                //если нет совпадений
                minSize++;
            }
        }
        //если была найдена хотя бы одна комбинация
        if(maxSize >= 0){
            //возвращаем значение нижней границы диапазона поиска
            return minimumSize;
        }
        //если нет - -1
        return -1;
    }*/
    private int findMinAcceptableOfMaxTomeSize(int maxPagesNumber, int totalPagesSum){
        //если том 1
        if(tomesNumber == 1){
            //то возвращаем общее количество страниц в романе
            return totalPagesSum;
        }
        //если количество томов равны количеству глав или крайние элементы больше или равны суммы оставшихся
        if(tomesNumber == chaptersArray.length ||
                chaptersArray[0] >= totalPagesSum - chaptersArray[0] ||
                chaptersArray[chaptersArray.length - 1] >= totalPagesSum - chaptersArray[chaptersArray.length - 1]
            ){
            //то возвращаем максимальное количество страниц в одной главе
            return maxPagesNumber;
        }

        //Запоминаем минимально возможное количество страниц в томе
        //TODO Deleted
        //int minSize = 0;
        //TODO Added
        //Нижняя граница не может быть меньше максимального числа страниц в главе
        int minSize = maxPagesNumber - 1;

        //Запоминаем максимально возможное количество страниц в томе
        int maxSize = totalPagesSum + 1;
        //Объявляем переменную для средней значения
        int middleSize;

        //TODO Deleted
        //Объявляем переменную для искомого значения
        //int minimumSize = maxSize;

        //***Бинарный поиск***
        //крутим цикл пока не сблизим края поиска до одного элемента
        while(maxSize - minSize != 1){
            //устанавливаем на середине диапазона
            middleSize = minSize + (maxSize - minSize) / 2;
            //проверяем не больше ли проверяемое значение максимального количества в одной главе и
            // выполняется ли условие с размером middleSize
            boolean result = isCondition(middleSize, totalPagesSum);
            //проверяем было ли совпадение
            if(flag){
                //если да есть хотя бы одно совпадение
                //TODO Deleted
                //if(middleSize <= maxPagesNumber || result){
                //TODO Added
                if(result){

                    //minSize всегда должна указывать на ситуацию, когда условие выполняется
                    minSize = middleSize;

                    //TODO Deleted
                    /*//запоминаем последнее совпавшее значение
                    if(minimumSize > middleSize){
                        minimumSize = middleSize;
                    }*/

                } else {
                    //maxSize всегда должна указывать на ситуацию, когда условие не выполняется
                    maxSize = middleSize;
                }
            } else{
                //если нет совпадений
                minSize++;
            }
        }

        //TODO Deleted
        /*//если была найдена хотя бы одна комбинация
        if(maxSize >= 0){
            //возвращаем значение нижней границы диапазона поиска
            return minimumSize;
        }*/
        //TODO Added
        //если была найдена хотя бы одна комбинация
        if(minSize > 0){
            //возвращаем максимальное расстояние, на котором можно расставить коров в стойла
            return minSize;
        }
        //если нет - -1
        return -1;
    }

    /**
     * Метод проверки выполняется ли условие при текущем verifiedSize:
     * текущее значение томов больше их заданного количества, возвращаем true
     * @param verifiedSize - проверяемое значение минимально возможного объема(в страницах)
     *  самого «толстого» тома
     * @param totalPagesSum - общее количество страниц в романе
     * @return true - количество томов проверяемого размера
     */
    private boolean isCondition(long verifiedSize, int totalPagesSum){
        //устанавливаем значение счетчика томов
        int currentNumber = 1;
        //инициируем текущую сумму страниц - не более заданного размера тома
        int currentPagesSum = 0;
        //сбрасываем флаг
        flag = false;

        //листаем массив - ищем количество томов, к которых можно разместить все главы
        // при проверяемом размере самого "толстого" тома
        for (int i = 0; i < chaptersArray.length; i++) {

            //TODO Deleted
            /*//если элемент больше проверяемого значения сбрасываем флаг и выходим
            if(chaptersArray[i] > verifiedSize){
                flag = false;
                return false;
            }*/

            //прибавляем к текущей сумме значение текущего элемента
            currentPagesSum += chaptersArray[i];

            //TODO Deleted
            /*//если есть хотя бы одно совпадение, взводим флаг
            if(currentPagesSum == verifiedSize){
                flag = true;
            }
            if(currentPagesSum > verifiedSize){
                //если текущая сумма больше проверяемого значения тома,
                //и берем следующий том
                currentNumber++;
                //обнуляем текущую сумму
                currentPagesSum = chaptersArray[i];
            }*/
            //TODO Added
            if(currentPagesSum >= verifiedSize){
                //если текущая сумма совпадает с проверяемым, взводим флаг
                if(currentPagesSum == verifiedSize){
                    //если текущая сумма равна проверяемому значению, взводим флаг и сбрасываем сумму
                    flag = true;
                    currentPagesSum = 0;
                } else {
                    //если текущая сумма больше проверяемого, то проверяем текущий элемент
                    if(chaptersArray[i] == verifiedSize){
                        //если текущий элемент равен проверяемому значению, взводим флаг и сбрасываем сумму
                        flag = true;
                        currentPagesSum = 0;
                    }else{
                        //если сопадения нет(текущая сумма просто больше проверяемого значения)
                        //в текущую сумму записываем значение текущего элемента
                        currentPagesSum = chaptersArray[i];
                    }
                }
                //если текущая элемент не последний инкрементируем счетчик томов
                if(i != chaptersArray.length - 1){
                    currentNumber++;
                }
            }
        }
        //если текущее значение томов больше их заданного количества, возвращаем true
        return currentNumber >= tomesNumber;
    }

}