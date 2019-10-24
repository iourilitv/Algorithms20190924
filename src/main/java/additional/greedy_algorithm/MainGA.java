package additional.greedy_algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Книга Адитья Бхаргава.Грокаем алгоритмы. Aditya Bhargava.Grokking Algorithms.2017
 * Глава 8. Жадные алгоритмы(Greedy algorithms) - это приближенные алгоритмы.
 * Translated by Yuriy Litvinenko from Python to Java.
 * Задача. "О радиостанциях".
 * Бы открываете собственную авторскую программу на радио и хотите, чтобы вас слушали во всех
 * 50 штатах. Нужно решить, на каких радиостанциях должна транслироваться ваша передача. Каждая
 * u станция стоит денег, поэтому количество станции необходимо свести к минимуму.
 * Имеется список станций со списком штатов покрытия для каждой.
 * Формализованная задача.
 * Выбрать минимальное количество радиостанций, чтобы покрыть всю территории вещания.
 * Решение.
 * 1 . Выбрать станцию, покрывающую наибольшее количество штатов, еще не входящих в покрытие.
 *     Если станция будет покрывать некоторые штаты, уже входящие в покрытие, это нормально.
 * 2. Повторять, пока остаются штаты, не входящие в покрытие.
 */
public class MainGA {
    public static void main(String[] args) {
        //инициируем список радиостанций в виде хэш таблицы с ключами - их названиями и
        // хэш таблиц с их покрытиями вещания
        final HashMap<String, HashSet<String>> stations = new HashMap<>();
        //инициируем список требуемых штатов покрытия вещанием в виде хэш набора
        // с ключами - их названиями
        final HashSet<String> statesNeeded = new HashSet<>();

        //наполняем список станций
        stations.put("kone", new HashSet<>());
        stations.put("ktwo", new HashSet<>());
        stations.put("kthree", new HashSet<>());
        stations.put("kfour", new HashSet<>());
        stations.put("kfive", new HashSet<>());
        //наполняем покрытиями список станций
        stations.get("kone").add("id");
        stations.get("kone").add("nv");
        stations.get("kone").add("ut");
        stations.get("ktwo").add("wa");
        stations.get("ktwo").add("id");
        stations.get("ktwo").add("mt");
        stations.get("kthree").add("or");
        stations.get("kthree").add("nv");
        stations.get("kthree").add("ca");
        stations.get("kfour").add("nv");
        stations.get("kfour").add("ut");
        stations.get("kfive").add("ca");
        stations.get("kfive").add("az");
        //наполняем хэш множество штатов требующих радио покрытия
        for (Map.Entry<String, HashSet<String>> s: stations.entrySet()) {
            statesNeeded.addAll(s.getValue());
        }

        System.out.println("statesNeeded: " + statesNeeded);
        //"mt" , "wa" , "or", "id", "nv", "ut", "са", "az"

        GreedyA greedyA = new GreedyA(stations, statesNeeded);
        System.out.println("Best stations list: " + greedyA.getResult());
        //Best stations list: [kfour, ktwo, kthree, kfive]

    }
}

//        stations [ " kone " ] = set ( [ " id " , " nv " , " ut " ] )
//        stations [ " ktwo " ] = set ( [ " wa " , " id " , " mt " ] )
//        stations [ " kthree " ] = set ( [ " or " , " nv " , " са " ] )
//        stations [ " kfour " ] = set ( [ " nv " , " ut " ] )
//        stations [ " kfive " ] = set ( [ " ca " , " az " ] )


//        System.out.println(stations);
//        {kfour=[nv, ut], ktwo=[mt, wa, id], kone=[nv, id, ut], kthree=[or, nv, ca], kfive=[az, ca]}
//        stations.put("kone", new HashSet<>());
//        stations.get("kfour").add("ut");
//        System.out.println(stations);
//        {kfour=[nv, ut], ktwo=[mt, wa, id], kone=[], kthree=[or, nv, ca], kfive=[az, ca]}
