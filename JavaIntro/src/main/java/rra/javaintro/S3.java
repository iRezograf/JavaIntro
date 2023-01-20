package rra.javaintro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class S3 {
    public static void main(String[] args) {
//        1 Объявить два списка список ArrayList,
//        в каждый добавить по 20 случайных чисел.
//        Удалить из первого списка элементы отсутствующие во втором списке.
//        Отсортировать первый список методом sort класса Collections.
//        2 * Отсортировать второй список методом sort списка и
//        компаратором по уменьшению.
//        3 **Отсортировать первый список пузырьковой сортировкой самостоятельно,
//        без использования доп методов и классов.

        int size = 20;
        int bound = 40;
        ArrayList<Integer> al1 = new ArrayList<>(size);
        ArrayList<Integer> al2 = new ArrayList<>(size);

        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            al1.add(rnd.nextInt(bound));
            al2.add(rnd.nextInt(bound));
        }
        System.out.println("\nпервый массив:");
        al1.forEach(e -> System.out.print(e + ", "));
        System.out.println("\nвторой массив:");
        al2.forEach(e -> System.out.print(e + ", "));

        al1.retainAll(al2); // оставить общие элементы в al1
//        al1.removeAll(al2); // удалить общие элементы из al1

        System.out.println("\nпервый массив с совпадающими значениями:");
        al1.forEach(e -> System.out.print(e + ", "));

        Collections.sort(al1);
        al2.sort((t0,t1)->t1-t0);

        System.out.println("\nвозрастающий первый массив с совпадающими значениями:");

        al1.forEach(e -> System.out.print(e + ", "));
        System.out.println("\nубывающий второй массив:");
        al2.forEach(e -> System.out.print(e + ", "));
    }
}
