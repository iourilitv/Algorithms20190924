package lesson5.hw.task2.draft;

import java.util.Arrays;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 * Описание задачи:
 * https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%80%D1%8E%D0%BA%D0%B7%D0%B0%D0%BA%D0%B5
 * Задача о рюкзаке (англ. Knapsack problem) — дано N предметов, ni предмет имеет массу wi>0 и стоимость pi>0.
 * Необходимо выбрать из этих предметов такой набор, чтобы суммарная масса не превосходила
 * заданной величины W (вместимость рюкзака), а суммарная стоимость была максимальна.
 * Ограниченный рюкзак (англ. Bounded Knapsack Problem): не более заданного числа экземпляров каждого предмета.
 * https://neerc.ifmo.ru/wiki/index.php?title=Meet-in-the-middle
 * Классической задачей является задача о наиболее эффективной упаковке рюкзака. Каждый предмет характеризуется
 * весом (wi⩽109) и ценностью (costi⩽109). В рюкзак, ограниченный по весу, необходимо набрать вещей с
 * максимальной суммарной стоимостью.
 * Для ее решения изначальное множество вещей N разбивается на два равных(или примерно равных) подмножества,
 * для которых за приемлемое время можно перебрать все варианты и подсчитать суммарный вес и стоимость,
 * а затем для каждого из них найти группу вещей из первого подмножества с максимальной стоимостью,
 * укладывающуюся в ограничение по весу рюкзака. Сложность алгоритма O(2N2×N). Память O(2N2).
 * Алгоритм.
 * Разделим наше множество на две части. Подсчитаем все подмножества из первой части и будем хранить их
 * в массиве first. Отсортируем массив first по весу. Далее пройдемся по этому массиву и оставим только
 * те подмножества, для которых не существует другого подмножества с меньшим весом и большей стоимостью.
 * Очевидно, что подмножества, для которых существует другое, более легкое и одновременно более ценное
 * подмножество, можно удалять. Таким образом в массиве first мы имеем подмножества, отсортированные
 * не только по весу, но и по стоимости. Тогда начнем перебирать все возможные комбинации вещей
 * из второй половины и находить бинарным поиском удовлетворяющие нам подмножества из первой половины,
 * хранящиеся в массиве first.
 */
public class Less5_hw_2 {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(1, 1),
                new Box(1, 2),
                new Box(2, 2),
                new Box(4, 10),
                new Box(12, 4),
        };

        Packer packer = new Packer(boxes, new Knapsack(15));
        System.out.println(Arrays.toString(packer.fillKnapsack()));
    }


}