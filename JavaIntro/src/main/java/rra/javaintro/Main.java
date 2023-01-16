package rra.javaintro;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

    //    Первый семинар.
    // 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
    // 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
    // 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
    // 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
    //    Пункты реализовать в методе main
    //    *Пункты реализовать в разных методах
    //    int i = new Random().nextInt(k); //это кидалка случайных чисел!

        ArrayList<Integer> m1 = new ArrayList<>();
        ArrayList<Integer> m2 = new ArrayList<>();
        int i = new Random().nextInt(2001);
        int n = Integer.toBinaryString(i).length();

//        System.out.printf("%4d\t%-12s\t%-12d\n", i,Integer.toBinaryString(i),n);
//        System.out.println(Short.MAX_VALUE);
//        System.out.println(Short.MIN_VALUE);

        for (int j = n; j <= Short.MAX_VALUE; j += n) {
            m1.add(j);
        }

        for (int j = Short.MIN_VALUE; j <= i; j++) {
            if (j%n != 0) {
                m2.add(j);
            }
        }
    }

}