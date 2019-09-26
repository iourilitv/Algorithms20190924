package lesson1.searching;

import java.util.Arrays;

public class BinSearch {

    public static void main(String[] args) {
        int n = 100;
        int value = 199;// ok: 0, 3, 18, 50, 98, 100, 102, 173, 198

        int[] intArray = new int[n];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = i * 2;
        }
        System.out.println(Arrays.toString(intArray));//TODO временно

        int result = binarySearchingInIntArray(intArray, value);
        System.out.println("value: " + value + " = result индекс: " + result);
    }

    /**
     * Метод поиска элемента в отсортированном int массиве
     * @param array int массив
     * @param value int элемент поиска
     * @return Индекс совпадающего элемента, если нет - -1
     */
    public static int binarySearchingInIntArray(int[] array, int value){
        //устанавливаем нижнюю границу проверяемой области
        int lowIndex = 0;
        //устанавливаем верхнюю границу проверяемой области
        int highIndex = array.length - 1;
        //проверяем входит ли элемент в диапазон массива
        if(value < array[lowIndex] || array[highIndex] < value){
            //выходим с негативным результатом, если не входит
            return -1;
        }

        int i = 1;//TODO временно

        //индекс проверяемого элемента
        int halfIndex;
        //крутим цикл пока не найдем совпадение или разница между мин. и макс.индексами не станет меньше или равна 1
        while(true) {
            //если есть, присваиваем половинный индекс для четной суммы мин. и макс.индексов,
            //а для нечетной - половина + 1
            halfIndex = (highIndex + lowIndex) % 2 == 0 ?
                    (highIndex + lowIndex) / 2 :
                    (highIndex + lowIndex + 1) / 2;
            //проверяем не совпадает ли входной элемент с проверяемым элементом массива
            if(array[halfIndex] != value){
                //если нет, проверяем больше ли он
                if(array[halfIndex] > value){
                    //если больше, сдвигаем верхнюю границу проверяемой области
                    highIndex = halfIndex;
                    //проверяем есть ли еще промежуточные узлы между мин. и макс.индексами
                    if(highIndex - lowIndex <= 1){

                        //TODO временно
                        System.out.println(i + ": " + "array[" + highIndex + "]: " + array[highIndex] + " highIndex");

                        //проверяем не совпадает ли наш элемент с элементом с мин.индексом
                        if(array[lowIndex] == value){
                            //если да, возвращаем мин.индекс
                            return lowIndex;
                        } else{
                            //если не совпадает, возвращаем негативный результат
                            return -1;
                        }
                    }
                } else{
                    //если меньше, сдвигаем нижнюю границу проверяемой области
                    lowIndex = halfIndex;
                    //проверяем есть ли еще промежуточные узлы между мин. и макс.индексами
                    if(highIndex - lowIndex <= 1){

                        //TODO временно
                        System.out.println(i + ": " + "array[" + lowIndex + "]: " + array[lowIndex] + " lowIndex");

                        //проверяем не совпадает ли наш элемент с элементом с макс.индексом
                        if(array[highIndex] == value){
                            //если да, возвращаем мин.индекс
                            return highIndex;
                        } else{
                            //если не совпадает, возвращаем негативный результат
                            return -1;
                        }
                    }
                }

            } else{
                //если входной элемент совпадает с проверяемым элементом, возвращаем его индекс
                return halfIndex;
            }

            //TODO временно
            System.out.println(i++ + ": " + "array[" + halfIndex + "]: " + array[halfIndex]);
        }
    }

    /*public static int binarySearchingInIntArray(int[] array, int value){
        int i = 1;//TODO временно
        int index = -1;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int halfIndex = lowIndex;
        while(array[halfIndex] != value || highIndex - lowIndex <= 1) {
            halfIndex = (highIndex + lowIndex) % 2 == 0 ?
                    (highIndex + lowIndex) / 2 :
                    //(highIndex + lowIndex) / 2 + 1;
                    (highIndex + lowIndex + 1) / 2;

            System.out.println(i++ + ": " + "array[" + halfIndex + "]: " + array[halfIndex]);

            if(array[halfIndex] > value){
                highIndex = halfIndex;
            } else{
                lowIndex = halfIndex;
            }
            //условие, чтобы выйти при значении проверяемиого элемента между двумя проверенными элементами массива
            if(highIndex - lowIndex <= 1){
                return index;
            }
        }
        //index = halfIndex;
        //return index;
        return halfIndex;
    }*/

    /*public static int binarySearchingInIntArray(int[] array, int value){
        int i = 1;
        int index = -1;
        int lowIndex = 0;
        int highIndex = array.length - 1;
        int halfIndex;
        do {
            halfIndex = (highIndex + lowIndex) % 2 == 0 ?
                    (highIndex + lowIndex) / 2 :
                    (highIndex + lowIndex) / 2 + 1;

            System.out.println(i++ + ": " + "array[" + halfIndex + "]: " + array[halfIndex]);

            if(array[halfIndex] > value){
                highIndex = halfIndex;
            } else{
                lowIndex = halfIndex;
            }
        }
        while(array[halfIndex] != value);
        index = halfIndex;
        return index;
    }*/

}
