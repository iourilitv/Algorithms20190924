package lesson1.hw;

/**
 * Алгоритмы_и_структуры_данных_на_Java.БазовыйКурс. 24.09.2019 Webinar.
 * Teacher: Фанзиль Кусяпкулов
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * Домашняя работа.
 * @author Litvinenko Yuriy
 * Задачи на http://acmp.ru
 * Тема. Сортировка и последовательности.
 * DONE ЗАДАЧА №5. Статистика (Время: 1 сек. Память: 16 Мб Сложность: 15%)
 * Вася не любит английский язык, но каждый раз старается получить хотя бы четверку за четверть,
 * чтобы оставаться ударником. В текущей четверти Вася заметил следующую закономерность:
 * по нечетным дням месяца он получал тройки, а по четным – четверки. Так же он помнит, в какие дни
 * он получал эти оценки. Поэтому он выписал на бумажке все эти дни для того, чтобы оценить,
 * сколько у него троек и сколько четверок. Помогите Васе это сделать, расположив четные и нечетные числа
 * в разных строчках. Вася может рассчитывать на оценку 4, если четверок не меньше, чем троек.
 * Входные данные:
 * В первой строке входного файла INPUT.TXT записано единственное число N – количество элементов
 * целочисленного массива (1 ≤ N ≤ 100). Вторая строка содержит N чисел, представляющих заданный массив.
 * Каждый элемент массива – натуральное число от 1 до 31. Все элементы массива разделены пробелом.
 * Выходные данные:
 * В первую строку выходного файла OUTPUT.TXT нужно вывести числа, которые соответствуют дням месяцев,
 * в которые Вася получил тройки, а во второй строке соответственно расположить числа месяца,
 * в которые Вася получил четверки. В третьей строке нужно вывести «YES», если Вася может рассчитывать
 * на четверку и «NO» в противном случае. В каждой строчке числа следует выводить в том же порядке,
 * в котором они идут во входных данных. При выводе, числа отделяются пробелом.
 * Примеры:
 * 5                >>  19 31
 * 4 16 19 31 2     >>  4 16 2
 *                  >> YES
 * 8                        >>  29 7 15 17 1
 * 29 4 7 12 15 17 24 1     >>  4 12 24
 *                          >> NO
 * Формализованная задача.
 *  Принять количество дней и перечесление дней.
 *  Найти в массиве нечетное число(тройки) и вывести в первую строку
 *  Найти в массиве четное число(четверки) и вывести во вторую строку
 *  Если количество во второй строке не меньше, чем в первой, в третью строку вывести YES, нет - NO.
 */

import java.io.*;
import java.util.*;

public class Acmp0005 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder resultString1 = new StringBuilder();
        StringBuilder resultString2 = new StringBuilder();

        String msg;
        //принимаем количество дней
        int num = Integer.parseInt(in.nextLine());
        //инициируем целочисленный массив дней
        int[] initArray = new int[num];
        //инициируем количество
        int num4 = 0;

        for (int day: initArray) {
            //принимаем значение
            day = in.nextInt();
            //проверяем на четность
            if(day % 2 == 0){
                //если четное число, значит четверка, конкатенируем ко второй строке
                resultString2.append(day).append(" ");
                num4++;
            } else{
                //если нечетное число, значит тройка, конкатенируем к первой строке
                resultString1.append(day).append(" ");
            }
        }
        if(num4 < num - num4){
            msg = "NO";
        } else {
            msg = "YES";
        }
        out.println(resultString1);
        out.println(resultString2);
        out.println(msg);

        out.flush();
    }
}

    /*public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder resultString1 = new StringBuilder();
        StringBuilder resultString2 = new StringBuilder();

        String msg = "";
        //принимаем количество дней
        int num = Integer.parseInt(in.nextLine());
        //int[] initArray = new int[num];
        int num4 = 0;

        //принимаем список дней с оценками
        String string2 = in.nextLine();
        //разделяем строку на массив строк(чисел)
        String[] stringArray = string2.trim().split(" ");
        for (String s: stringArray) {
            //FIXME Добавить проверку на число
            //проверяем на четность
            if(Integer.parseInt(s) % 2 == 0){
                //если четное число, значит четверка, конкатенируем ко второй строке
                resultString2 = resultString2.append(s + " ");
                num4++;
            } else{
                //если нечетное число, значит тройка, конкатенируем к первой строке
                resultString1 = resultString1.append(s + " ");
            }
        }
        if(num4 < num - num4){
            msg = "NO";
        } else {
            msg = "YES";
        }

        out.println(num);
        out.println(string2);
        out.println(resultString1);
        out.println(resultString2);
        out.println(msg);

        out.flush();
    }*/