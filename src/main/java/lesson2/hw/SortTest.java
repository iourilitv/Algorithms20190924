package lesson2.hw;

import java.util.Arrays;

public class SortTest<Item extends Comparable> {
    private Sort sort;
    private MyArraylist mal;
    private Item[] list;
    //private MyArraylist copyList;

    public SortTest(Sort sort, MyArraylist mal) {
        this.sort = sort;
    }

    /**
     * Метод запускает тесты в зависимости от способа сортировка.
     * Подсчитывает общее время выполнения теста.
     * @param sort - способ сортировки
     * @return общее потраченное на выполнение теста время
     */
    long startSortTypesTest(Sort sort){
        System.out.println("The test \"" + sort.getClass().getSimpleName() + "\" has started...");
        System.out.println(Arrays.toString(sort.getList()));

        //запоминаем системное время в начале теста
        long startTime = System.currentTimeMillis();
        //запускаем методы тестов в зависимости от вида
        sort.sort();

        //запоминаем системное время в начале теста
        long finishTime = System.currentTimeMillis();
        //вычисляем общее время теста
        long totalTime = finishTime - startTime;

        System.out.println(Arrays.toString(sort.getList()));
        System.out.println("The test \"" + sort.getClass().getSimpleName() + "\" has finished...");
        System.out.println("Total time of test(millis): " + totalTime);

        return totalTime;
    }

    public Sort getSort() {
        return sort;
    }
}
