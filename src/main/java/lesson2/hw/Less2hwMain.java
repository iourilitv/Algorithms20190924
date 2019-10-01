package lesson2.hw;

import java.util.*;

/**
 * Алгоритмы_и_структуры_данных_на_Java.БазовыйКурс. 24.09.2019 Webinar.
 * Teacher: Фанзиль Кусяпкулов
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * Домашняя работа.
 * @author Litvinenko Yuriy
 * DONE 1. Создать массив большого размера (миллион элементов).
 * DONE 2. Написать методы удаления, добавления, поиска элемента массива.
 * DONE 3. Заполнить массив случайными числами.
 * 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить
 * скорость выполнения каждой.
 *
 */
public class Less2hwMain {
    public static void main(String[] args) {
        int volume = 100000;//требуемый размер массива
        int bound = 100;//диапазон генерации случайных чисел
        new Less2hw(volume, bound).run();
    }
}

class Less2hw {
    private Random random = new Random();
    private int volume;
    private int bound;
    private MyArraylist<Integer> mal;
    private Sort sort;
    private List<SortTest> sortTests;
    private List<MyArraylist> malCopies;
    private MyArraylist<Integer> malCopy;

    Less2hw(int volume, int bound) {
        this.volume = volume;
        this.bound = bound;
    }

    void run(){
        mal = new MyArraylist<>(volume);
        fillArrayList();

        sortTests = new ArrayList<>();

        //sortTests.add(new SortTest(new SelectSort(mal), mal));//20641
        //sortTests.add(new SortTest(new InsertSort(mal), mal));//5836
        sortTests.add(new SortTest(new BubbleSort(mal), mal));//69846

        for (SortTest sortTest: sortTests) {
            sortTest.startSortTypesTest(sortTest.getSort());
        }

        //prepareTests();
        /*Long[] testTimes = new Long[]{
            startSortTypesTest("select"),
            startSortTypesTest("insert"),
            startSortTypesTest("bubble")
        };*/

    }

    /*private void prepareTests() {

        sortTests = new ArrayList<>();

        sortTests.add(new SortTest(new SelectSort(mal), mal));
        //sortTests.add(new SortTest(new InsertSort(malCopy), malCopy));
        //sortTests.add(new SortTest(new BubbleSort(malCopy), malCopy));

        for (SortTest sortTest: sortTests) {
            sortTest.startSortTypesTest(sortTest.getSort());
        }

        //malCopies = new ArrayList<>();*/

        /*for (MyArraylist m: malCopies) {
            malCopy = new MyArraylist<>(volume);
            m.add((Comparable) malCopy);
            cloneArray();
            System.out.println(m.toString());
        }*/

        //malCopy = new MyArraylist<>(volume);
        //cloneArray();

        //sortTests.add(new SortTest(new SelectSort(malCopy), malCopy));
        //sortTests.add(new SortTest(new InsertSort(malCopy), malCopy));
        //sortTests.add(new SortTest(new BubbleSort(malCopy), malCopy));



    //}

    /*private void cloneArray(MyArraylist<Integer> mal, MyArraylist<Integer> malCopy) {
        //в цикле копируем содержимое текущего массива в новый массив
        for (int i = 0; i < mal.size(); i++) {
            malCopy.add(mal.get(i));
        }
    }*/
    private void cloneArray() {
        //malCopy = new MyArraylist<>(volume);
        //в цикле копируем содержимое текущего массива в новый массив
        for (int i = 0; i < mal.size(); i++) {
            malCopy.add(mal.get(i));
        }
    }

    /**
     * Метод напонения массива случайными целочисленными значениями
     */
    private void fillArrayList(){
        for (int i = 0; i < volume; i++) {
            mal.add(random.nextInt(bound));
        }
    }

    /*void cloneArray(){
        //в цикле копируем содержимое текущего массива в новый массив
        for (int i = 0; i < mal.size(); i++) {
            malCopy.add(mal.get(i));
        }
    }*/

    /**
     * Метод запускает тесты в зависимости от способа сортировка.
     * Подсчитывает общее время выполнения теста.
     * //@param sortType - способ сортировки
     * //@return общее потраченное на выполнение теста время
     */
    /*long startSortTypesTest(String sortType){
        System.out.println("The test \"" + sortType + "\" has started...");
        System.out.println(mal);

        //запоминаем системное время в начале теста
        long startTime = System.currentTimeMillis();
        //запускаем методы тестов в зависимости от вида
        switch (sortType){
            case("select"): new SelectSort<>(mal).sort();
            case("insert"): new InsertSort<>(mal).sort();
            case("bubble"): new BubbleSort<>(mal).sort();
        }
        //запоминаем системное время в начале теста
        long finishTime = System.currentTimeMillis();
        //вычисляем общее время теста
        long totalTime = finishTime - startTime;

        System.out.println(mal);
        System.out.println("The test \"" + sortType + "\" has finished...");
        System.out.println("Total time of test(millis): " + totalTime);

        return totalTime;
    }*/

    public MyArraylist<Integer> getMal() {
        return mal;
    }

    public Sort getSort() {
        return sort;
    }


    public MyArraylist<Integer> getMalCopy() {
        return malCopy;
    }
}
