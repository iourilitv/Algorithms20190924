package lesson1.hw;

/**
 * Алгоритмы_и_структуры_данных_на_Java.БазовыйКурс. 24.09.2019 Webinar.
 * Teacher: Фанзиль Кусяпкулов
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * Домашняя работа.
 * @author Litvinenko Yuriy
 * Задачи на http://acmp.ru
 * Тема. Целочисленная арифметика.
 * DONE ЗАДАЧА №42. Драконы (Время: 1 сек. Память: 16 Мб Сложность: 40%)
 * Известно, что у дракона может быть несколько голов и его сила определяется числом голов.
 * Но как определить силу драконьей стаи, в которой несколько драконов и у каждого из них
 * определенное число голов? Вероятно, вы считаете, что это значение вычисляется как сумма всех голов?
 * Это далеко не так, иначе было бы слишком просто вычислить силу драконьей стаи.
 * Оказывается, что искомое значение равно произведению значений числа голов каждого из драконов.
 * Например, если в стае 3 дракона, у которых 3, 4 и 5 голов соответственно, то сила равна 3*4*5 = 60.
 * Предположим, что нам известно суммарное количество голов драконьей стаи, как нам вычислить
 * максимально возможное значение силы этого логова драконов? Именно эту задачу Вам и предстоит решить.
 * Входные данные:
 * В единственной строке входного файла INPUT.TXT записано натуральное число N (0 < N < 100) –
 * количество голов драконьей стаи.
 * Выходные данные:
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести максимально возможное значение силы,
 * которая может быть у стаи драконов из N голов.
 * Примеры:
 * 6    >>  9
 * 8    >>  18
 * 13   >> 108
 * Формализованная задача.
 *  Принять количество (сумму) голов драконьей стаи.
 *  Эмпирически получено, что максимальное произведение получается при величине (n - 1) множителей не больше 3.
 *  А n-множитель может быть или 2 или 4.
 *  Делением найти количетво элементов произведения и в зависимости от размера остатка деления на 3
 *  сделать последним элементом 2 или 4.
 *  !!! Решение не принято!!! UPDATED: replaced int with long. It was accepted now.
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Acmp0042 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        //принимаем количество (сумму) голов драконьей стаи
        int num = in.nextInt();
        //инициируем количество
        long force;

        if(num % 3 == 0){
            //если сумма голов делится на 3 без остатка, то перемножаем все тройки
            force = (long)Math.pow(3, num / 3);
        } else{
            if(num % 3 == 1){
                //если сумма голов делится на 3 с остатком 1, то перемножаем все - 1 тройки и умножаем на 4
                //если число голов меньше 3(здесь 1), то произведение = 1
                force = num < 3 ? 1 : (long) Math.pow(3, num / 3 - 1) * 4;
            } else{
                //если сумма голов делится на 3 с остатком 2, то перемножаем все - 1 тройки и умножаем на 2
                //если число голов меньше 3(здесь 2), то произведение = 2
                force = num < 3 ? 2 : (long) Math.pow(3, (num + 1) / 3 - 1) * 2;
            }
        }
        out.println(force);
        out.flush();
    }
}
//96 >> 1 853 020 188 851 841
//99 >> 5 559 060 566 555 523