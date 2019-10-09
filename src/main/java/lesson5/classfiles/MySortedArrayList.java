package lesson5.classfiles;

import java.util.EmptyStackException;

public class MySortedArrayList<Item extends Comparable> extends MyArraylist<Item> {
    @Override
    public void add(Item item) {
        int i = 0;
        while (i < size() && item.compareTo(get(i)) >= 0) {
            i++;
        }
        super.add(i, item);
    }

    @Override
    public void add(int index, Item item) {
        add(item);
    }

    //indexOf
    public int binaryFind(Item item) {
        return recBinaryFind(item, 0, size() - 1);
//        int lo = 0;
//        int hi = size() - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2; //(hi+lo)/2
//            if (item.compareTo(get(mid)) < 0) {
//                hi = mid - 1;
//            } else if (item.compareTo(get(mid)) > 0) {
//                lo = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;
    }

    //рекурсивный бинарный поиск
    private int recBinaryFind(Item item, int lo, int hi) {
        //находим среднее значение для старта
        int mid = lo + (hi - lo) / 2;
        //если текущее значение это искомый элемент, возвращаем его индекс
        //это базовое значение рекурсивной функции(на чем остановится рекурсия)
        if (item.compareTo(get(mid)) == 0) {
            return mid;
        //если нижняя и верхняя граница равны, значит - не нашли
        } else if (lo == hi) {
            return -1;
        //если текущее значение меньше искомого элемента, снижаем верхнюю границу до текущего
        //mid - 1 нельзя, т.к. в int дробная часть просто отбрасывается и можно выйти за границу
        } else if (item.compareTo(get(mid)) < 0) {
            //делаем рекурсию с новой верхней границей
            return recBinaryFind(item, lo, mid);
        //если текущее значение меньше искомого элемента, снижаем верхнюю границу до текущего
        } else if (item.compareTo(get(mid)) > 0) {
            //делаем рекурсию с новой нижней границей
            return recBinaryFind(item, mid + 1, hi);
        }
        //если все прошли и не нашли совпадения, возвращаем -1
        return -1;
    }
}
