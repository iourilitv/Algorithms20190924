package lesson1.searching;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Тема. Бинарный поиск.
 * https://algocode.ru/page/c-2-binary-search/
 * @author of the update Litvinenko Yuriy
 * DONE Задача. Злые коровы или загнать коров в стойла.
 * Общий принцип решения: бинарный поиск по ответу.
 * Условие: На прямой расположены N стойл (даны их координаты на прямой), в которые необходимо
 * расставить K коров так, чтобы минимальное расcтояние между коровами было как можно больше.
 * Гарантируется, что  1<K<N .
 * Входные данные:
 * Принять в консоль целочисленные значения.
 * В первой строке - единственное число K(количество коров).
 * Во второй строке - единственное число N(количество стойл). Одно стойло для одной коровы.
 * В третьей строке перечисление координат стоил(через пробел).
 * Выходные данные:
 * Максимальное расстояние, на котором можно расставить коров в стойла.
 * Примеры:
 * 3                   >> 9
 * 6
 * 2 5 7 11 15 20
 * Решение.
 * По сути мы просто взяли задачу "найдите максимальное X, такое что какое-то свойство
 * от X выполняется" и решили её бинпоиском.
 * Подробнее.
 * Если решать задачу в лоб, то вообще неясно что делать. Нужно решать обратную задачу: давайте
 * предположим, что мы знаем это расстояние X, ближе которого коров ставить нельзя.
 * Тогда сможем ли мы расставить самих коров?
 * Ответ - да, можно ставить их довольно просто: самую первую ставим в самое левое стойло,
 * это всегда выгодно. Следующие несколько стойл надо оставить пустыми, если они на расстоянии
 * меньше X. В самое левое стойло из оставшихся надо поставить вторую корову и так далее.
 * Даже ясно как это писать: надо идти слева направо по отсортированному массиву стойл, хранить
 * координату последней коровы, и либо пропускать стойло, либо ставить в него новую корову.
 * То есть если мы знаем расстояние X, то мы можем за O(n) проверить, можно ли расставить K коров
 * на таком расстоянии. Ну так давайте запустим бинпоиск по X, ведь при слишком маленьком X коров
 * точно можно расставить, а при слишком большом - нельзя, и как раз эту границу и просят найти
 * в задаче ("как можно больше").
 * Осталось точно определить границы, то есть изначальные значения left и right.
 * Нам точно хватит расстояния 0, так как гарантируется, что коров меньше, чем стойл.
 * И точно не хватит расстояния max_coord - min_coord + 1, так как по условию есть хотя бы 2 коровы.
 */

public class AngryCowsModelMain{
    public static void main(String[] args) {
        new AngryCowsModel().run();
    }
}

class AngryCowsModel {
    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    private int cowsNumber;
    private int[] cowStallsCoordinates;

    void run() {
        //Принимаем количество коров
        cowsNumber = in.nextInt();
        //Принимаем количество стойл для коров
        int cowStallsNumber = in.nextInt();

        /*//Принимаем количество коров
        int cowsNumber = 3;
        //Принимаем количество стойл для коров
        int cowStallsNumber = 6;
        int[] cowStallsCoordinates = new int[]{2, 5, 7, 11, 15, 20};*/

        //Принимаем координаты стойл для коров и наполняем массив
        cowStallsCoordinates = takeCoordinatesIntoIntArray(cowStallsNumber);
        //находим
        int maxDistance = findMaxDistance(cowsNumber, cowStallsCoordinates);
        out.println(maxDistance);
        out.flush();
    }

    /**
     * Метод принимающий входящие значения и заполняющий массив координат.
     * Выводит на печать готовый массив.
     * @param cowStallsNumber - количество стойл
     * @return целочисленный массив, заполненный координатами стойл для коров
     */
    private int[] takeCoordinatesIntoIntArray(int cowStallsNumber){
        cowStallsCoordinates = new int[cowStallsNumber];

        for (int i = 0; i < cowStallsCoordinates.length; i++) {
            cowStallsCoordinates[i] = in.nextInt();
        }
        out.println(Arrays.toString(cowStallsCoordinates));
        out.flush();
        return cowStallsCoordinates;
    }

    /**
     * Метод нахождения в массиве максимального расстояния между стойлами,
     * при котором можно вместить всех коров
     * @param cowsNumber - заданное количество коров
     * @param array - целочисленный массив, заполненный координатами стойл для коров
     * @return значение максимально возможной дистанции между коровами
     */
    private int findMaxDistance(int cowsNumber, int[] array){
        //Запоминаем минимально возможное значение дистанции между коровами
        //расставить коров на расстоянии хотя бы 0 можно всегда
        int minDistance = 0;
        //Запоминаем максимально возможное значение дистанции между коровами(разница крайних значений + 1)
        //при таком расстоянии даже 2 коровы поставить нельзя
        int maxDistance = array[array.length - 1] - array[0] + 1;
        //Объявляем переменную для средней дистанции
        int middleDistance;

        //***Бинарный поиск***
        //крутим цикл пока не сблизим края поиска до одного элемента
        while(maxDistance - minDistance != 1){
            //устанавливаем на середине диапазона расстояний
            middleDistance = minDistance + (maxDistance - minDistance) / 2;
            //если можно поставить cowsNumber коров в стойла,
            // если между коровами расстояние хотя бы middleDistance
            if(isCorrect(cowsNumber, array, middleDistance)){
                //minDistance всегда должна указывать на ситуацию, когда можно поставить коров
                minDistance = middleDistance;
            } else {
                //maxDistance всегда должна указывать на ситуацию, когда нельзя поставить коров
                maxDistance = middleDistance;
            }
        }
        //если была найдена хотя бы одна комбинация
        if(minDistance > 0){
            //возвращаем максимальное расстояние, на котором можно расставить коров в стойла
            return minDistance;
        }
        //если нет - -1
        return -1;
    }

    /**
     * Метод проверки возможно ли поставить cowsNumber коров в стойла, если между коровами
     * расстояние хотя бы verifiedDistance
     * @param cowsNumber - заданное количество коров
     * @param array - целочисленный массив, заполненный координатами стойл для коров
     * @param verifiedDistance - проверяемое значение возможной дистанции между коровами
     * @return true - номер текущей коровы не меньше общего количества коров(значит все вместились)
     */
    private boolean isCorrect(int cowsNumber, int[] array, int verifiedDistance){
        //запоминаем номер текущей коровы
        int currentCowsNumber = 1;
        //и ее координаты(заняла первое стойло)
        int currentCowsCoordinate = array[0];
        //проверяем в цикле все стойла
        for (int value : array) {
            //если разница значениях координат не меньше, чем проверяемая дистанция
            if (value - currentCowsCoordinate >= verifiedDistance) {
                //берем следующую корову
                currentCowsNumber++;
                //и запоминаем координаты текущей коровы(ставим корову в стойло)
                currentCowsCoordinate = value;
            }
        }
        //если номер текущей коровы не меньше общего количества коров, возвращаем true
        return currentCowsNumber >= cowsNumber;
    }

}