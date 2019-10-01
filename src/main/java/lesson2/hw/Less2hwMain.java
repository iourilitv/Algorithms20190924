package lesson2.hw;

import java.util.Random;

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
        int volume = 100;//требуемый размер массива
        int bound = 1000;//диапазон генерации случайных чисел
        new Less2hw(volume, bound).run();
    }
}

class Less2hw {
    private Random random = new Random();
    private int volume;
    private int bound;
    private MyArraylist<Integer> mal;

    Less2hw(int volume, int bound) {
        this.volume = volume;
        this.bound = bound;
    }

    void run(){
        mal = new MyArraylist<>(volume);
        fillArrayList();

        System.out.println(mal);
//        mal.selectionSort();
//        mal.insertionSort();
        //mal.bubbleSort();
//        mal.bubbleSort(Comparator.naturalOrder());
//        mal.bubbleSort(Comparator.reverseOrder());
        //System.out.println(mal);

    }

    /**
     * Метод напонения массива случайными целочисленными значениями
     */
    private void fillArrayList(){
        for (int i = 0; i < volume; i++) {
            mal.add(random.nextInt(bound));
        }
    }
}
