package lesson5.hw;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * DONE 1. Написать программу по возведению числа в степень с помощью рекурсии.
 * Реализован Метод возведения положительного или отрицательного целочисленного числа
 * в положительную или отрицательную целочисленную степень
 */
public class Less5_hw_1 {
    public static void main(String[] args) {
        System.out.println("0 ^ x = " + pow(0, 10) + " : " + Math.pow(0, 10));
        System.out.println("1 ^ x = " + pow(1, 10) + " : " + Math.pow(1, 10));
        System.out.println("x ^ 0 = " + pow(5, 0) + " : " + Math.pow(5, 0));
        System.out.println("-x ^ 0 = " + pow(-5, 0) + " : " + Math.pow(-5, 0));
        System.out.println("2 ^ 10 = " + pow(2, 10) + " : " + Math.pow(2, 10));
        System.out.println("-3 ^ 3 = " + pow(-3, 3) + " : " + Math.pow(-3, 3));
        System.out.println("-3 ^ 4 = " + pow(-3, 4) + " : " + Math.pow(-3, 4));
        System.out.println("100000 ^ -1 = " + pow(100000, -1) + " : " + Math.pow(100000, -1));
        System.out.println("-100000 ^ -1 = " + pow(-100000, -1) + " : " + Math.pow(-100000, -1));
        System.out.println("10 ^ -3 = " + pow(10, -3) + " : " + Math.pow(10, -3));
        System.out.println("-10 ^ -5 = " + pow(-10, -5) + " : " + Math.pow(-10,-5));

        //TODO Updated.Adding rounding.Deleted
        //System.out.println("-10 ^ -6 = " + pow(-10, -6) + " : " + Math.pow(-10,-6));
        //TODO Updated.Adding rounding.Added
        System.out.printf("-10 ^ -6 = %f", pow(-10, -6));
        System.out.println(" : " + Math.pow(-10,-6));
        //-10 ^ -6 = 0,000001 : 1.0E-6
    }

    //Метод возведения положительного или отрицательного целочисленного числа
    // в положительную или отрицательную целочисленную степень
    private static double pow(int number, int degree){

        //TODO Updated.Correction adding.Added
        //если оба аргумента ноли - это математическая неопределенность
        if(number == 0 && degree == 0){
            throw new ArithmeticException("\"0 ^ \" math uncertainly!");
        }

        //если число 0, возвращаем 0
        if(number == 0){// && number == -0 не нужно
            return 0;
        }
        return degree < 0 ? powNegative(number, degree) : powPositive(number, degree);
    }

    //Метод возведения положительного числа в положительную целочисленную степень
    private static long powPositive(int number, int degree){
        if(degree == 0){
            return 1;
        }
        if(degree == 1){
            return number;
        }
        //TODO Updated.Optimizing.Deleted
        //return powPositive(number, degree - 1) * number;
        //TODO Updated.Optimizing.Added
        //можно ускорить расчет представив степень ее как сумму:
        // degree/2 + degree/2 - для четных и degree/2 + degree/2 + 1 - для нечетных степеней
        long pow2 = powPositive(number, degree / 2);
        return degree %2 == 0 ? pow2 * pow2 : pow2 * pow2 * number;
    }

    //Метод возведения положительного числа в отрицальную целочисленную степень 1/a^n
    private static double powNegative(int number, int degree){
        if(degree == -1){
            return (double) 1 / number;
        }

        //TODO Updated.Optimizing.Deleted
        //return powNegative(number, degree + 1) * (double) 1 / number;
        //TODO Updated.Optimizing.Added
        //можно ускорить расчет представив степень ее как сумму:
        // degree/2 + degree/2 - для четных и degree/2 + degree/2 + 1 - для нечетных степеней
        double pow2 = powNegative(number, degree / 2);
        return degree %2 == 0 ? pow2 * pow2 : pow2 * pow2 * 1 / number;
    }
}
//Result.
//0 ^ x = 0.0 : 0.0
//1 ^ x = 1.0 : 1.0
//x ^ 0 = 1.0 : 1.0
//-x ^ 0 = 1.0 : 1.0
//2 ^ 10 = 1024.0 : 1024.0
//-3 ^ 3 = -27.0 : -27.0
//-3 ^ 4 = 81.0 : 81.0
//100000 ^ -1 = 1.0E-5 : 1.0E-5
//-100000 ^ -1 = -1.0E-5 : -1.0E-5
//10 ^ -3 = 0.001 : 0.001
//-10 ^ -5 = -1.0E-5 : -1.0E-5
//-10 ^ -6 = 1.0000000000000002E-6 : 1.0E-6
