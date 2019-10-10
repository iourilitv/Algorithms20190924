package lesson5.hw.task2.examples;

import java.util.Arrays;

/**
 * «Задача о рюкзаке» БЕЗ СТОИМОСТИ с помощью рекурсии.
 * Работает только при точном совпадении суммарного веса выбранных предметов с capacity.
 * http://qaru.site/questions/358910/how-do-i-solve-the-classic-knapsack-algorithm-recursively
 * Решение через рекурсию.
 */
public class XexampleRecurEasy {
    private static int count;

    public static void main(String[] args) {
        //массив весов вещей
        int[] arr = new int[]{11, 8, 7, 6, 5};
        System.out.println(Arrays.toString(arr));
        //ищем максимально возможный вес рюкзака(20 - максимально возможный вес вещей в рюкзаке),
        // наполненного этими вещами
        find(arr,36);//20(совпадет)
    }

    /**
     * Метод начала поиска
     * @param arr - массив весов вещей
     * @param total - максимально возможный вес вещей в рюкзаке
     * @return наибольшее значение веса всех вещей, уложенных в рюкзак
     */
    public static boolean find( int[] arr,int total){
        return find(arr,0, total);
    }

    /**
     * Рекурсивный метод поиска
     * @param arr - массив весов вещей
     * @param start - начальный индекс в массиве весов
     * @param total - текущее максимальное значение доступного веса(какой вес можно еще положить)
     * @return true - все вещи влезли ровно до полной вместимости, false - дошли до конца массива
     */
    private static boolean find(int[] arr, int start, int total){
        //TODO временно
        System.out.println("find #" + count++ + ".");
        if(start < arr.length){
            System.out.print("arr[" + start + "]: " + arr[start] + ". total: " + total + "\n");
        } else{
            System.out.print("arr[" + start + "]: " + "ERR" + ". total: " + total + "\n");
        }

        //дошли до конца массива, возвращаем false
        if (start == arr.length){
            return false;
        }
        //текущее значение веса(проверяемый вес)
        int curr = arr[start];
        //все вещи влезли ровно до полной вместимости, выводим на печать текущее значение(вес)
        // и возвращаем true
        if (curr == total){
            System.out.println("curr == total. curr: " + curr);
            return true;
        //если текущий вес не уже не влезет в рюкзак(остаток вместимости меньше веса)
        } else if (
                curr > total ||
                        /*или в новой рекурсии дошли до конца и не нашли совпадения*/
                        !find(arr,start + 1,total - curr))
        {

            //TODO временно
            System.out.println("go to just find...");

            //возвращаем результат новой рекурсии
            return find(arr,start + 1, total);
        }
        System.out.println("curr: " + curr);
        return true;
    }
}
