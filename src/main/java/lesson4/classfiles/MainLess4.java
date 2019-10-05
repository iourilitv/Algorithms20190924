package lesson4.classfiles;

import java.util.Iterator;

/**
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 4. Связанные списки.
 * Учимся создавать и использовать списки
 *
 */
public class MainLess4 {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();

        mll.insertFirst("Katia");
        mll.insertFirst("Maria");
        mll.insertFirst("Lyba");

        System.out.println(mll);

        mll.insertLast("Petia");
        System.out.println(mll);

//        System.out.println(mll.removeFirst());
//        System.out.println(mll);
//        System.out.println(mll.removeLast());
//        System.out.println(mll);


        mll.insert("Vasia", 1);
        System.out.println(mll);

        for (String s : mll) {
            System.out.print(s + " : ");
        }

        System.out.println();
        Iterator<String> iterator = mll.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

//        MyLinkedList<Integer> stack = new MyLinkedList<>();
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();


//        System.out.println(mll.remove("Petia"));
//        System.out.println(mll);
//        System.out.println(mll.remove("Katia"));
//        System.out.println(mll);
//
//        System.out.println(mll.contains("Katia"));


    }
}
