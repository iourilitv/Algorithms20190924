package lesson5.hw;

/**
 * GBJava3
 * Algorithms and data structures in Java. 24.09.2019 Webinar. Teacher: Fanzil' Kusyapkulov
 * Урок 5. Рекурсия
 * Зачем функция вызывает саму себя?
 * Домашнее задание.
 * DONE 3*. Добавить в рекурсивный метод recMultiply возможность перемножения отрицательных чисел.
 */
public class Less5_hw_3 {
    public static void main(String[] args) {
        System.out.println("4 * 7 = " + multiply(4, 7));
        System.out.println("-4 * 7 = " + multiply(-4, 7));
        System.out.println("4 * -7 = " + multiply(4, -7));
        System.out.println("-4 * -7 = " + multiply(-4, -7));
    }

    //метод перемножения целочисленных чисел с любым знаком
    private static int multiply(int a, int b) {
        //если одно из чисел равно 0, возвращаем 0
        if (a == 0 || b == 0) {
            return 0;
        }
        //если первое число равно 1, возвращаем второе число
        if (a == 1) {
            return b;
        }
        int neg = 1;
        //если только одно из чисел отрицательное
        if((a < 0 && b > 0) || (b < 0 && a > 0)){
            //берем модули чисел
            //a = Math.abs(a);
            //b = Math.abs(b);
            neg = -1;
        }
        return neg * recMultiply(Math.abs(a), Math.abs(b));
    }

    //Рекуперативный метод, где второе число - множитель
    private static int recMultiply(int a, int b) {
        //если второе число равно 1, возвращаем первое число
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }
}
