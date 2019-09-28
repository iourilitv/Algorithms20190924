package lesson2.classfiles;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
//        String[] arr2 = new String[10];
//        arr2[0]="qwerq";

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] % 2 != 0) {
                arr1[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(arr1));
//        for (int i = 0; i < arr1.length; i++) {
//            System.out.print(arr1[i]+" ");
//        }
//        for (int a:arr1 ) {
//            System.out.print(a+" ");
//        }


    }

}
