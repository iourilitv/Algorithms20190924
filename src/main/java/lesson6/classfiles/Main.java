package lesson6.classfiles;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 6. Деревья
 * Рассмотрим работу с двоичными деревьями.
 *
 */
public class Main {
    public static void main(String[] args) {
        MyTreeMap<Integer, String> mtm = new MyTreeMap<>();

        mtm.put(5,"five");
        mtm.put(1,"one");
        mtm.put(3,"tree");
        mtm.put(4,"four");
        mtm.put(2,"two");

        System.out.println(mtm.get(2));
        mtm.put(2,"two2222");

        System.out.println(mtm.get(2));
        System.out.println(mtm);

        mtm.delete(3);
        System.out.println(mtm);

    }
}
