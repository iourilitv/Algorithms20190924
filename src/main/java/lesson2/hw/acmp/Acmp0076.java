package lesson2.hw.acmp;

/**
 * Алгоритмы_и_структуры_данных_на_Java.БазовыйКурс. 24.09.2019 Webinar.
 * Teacher: Фанзиль Кусяпкулов
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * Домашняя работа.
 * @author Litvinenko Yuriy
 * Задачи на http://acmp.ru
 * Тема. Сортировка и последовательности.
 * ЗАДАЧА №76. Музей (Время: 1 сек. Память: 16 Мб Сложность: 50%)
 * В музее регистрируется в течение суток время прихода и ухода каждого посетителя.
 * Таким образом, за день получены N пар значений, где первое значение в паре показывает время прихода
 * посетителя и второе значение - время его ухода. Требуется найти максимальное число посетителей,
 * которые находились в музее одновременно.
 * Входные данные:
 * В первой строке входного файла INPUT.TXT записано натуральное число N (N < 105) – количество
 * зафиксированных посетителей в музее в течении суток. Далее, идут N строк с информацией о времени
 * визитов посетителей: в каждой строке располагается отрезок времени посещения в формате
 * «ЧЧ:ММ ЧЧ:ММ» (00:00 ≤ ЧЧ:ММ ≤ 23:59).
 * Выходные данные:
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — максимальное
 * количество посетителей, одновременно находящихся в музее.
 * Примеры:
 * 6            >> 4
 * 09:00 10:07
 * 10:20 11:35
 * 12:00 17:00
 * 11:00 11:30
 * 11:20 12:30
 * 11:30 18:15
 * Формализованная задача.
 *
 */

import java.io.PrintWriter;
import java.util.Scanner;

public class Acmp0076 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        //принимаем количество (сумму) голов драконьей стаи
        int num = in.nextInt();
        //инициируем количество
        int force;

        if(num % 3 == 0){
            //если сумма голов делится на 3 без остатка, то перемножаем все тройки
            force = (int)Math.pow(3, num / 3);
        } else{
            if(num % 3 == 1){
                //если сумма голов делится на 3 с остатком 1, то перемножаем все - 1 тройки и умножаем на 4
                force = (int)Math.pow(3, num / 3 - 1) * 4;
            } else{
                //если сумма голов делится на 3 с остатком 2, то перемножаем все - 1 тройки и умножаем на 2
                force = (int)Math.pow(3, (num + 1) / 3 - 1) * 2;
            }
        }
        out.println(force);

        out.flush();
    }
}