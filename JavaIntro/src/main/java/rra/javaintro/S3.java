package rra.javaintro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class S3 {
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        Random rnd = new Random();

        int size = rnd.nextInt(20);
        for (int i = 0; i < size; i++) {
            int value = rnd.nextInt(100);
            al.add(value);
        }

        al.sort((t0,t1)->t1-t0);
//        Collections.sort(al);       // отсортировать
//        Collections.reverse(al); // сделать по убыванию
        al.forEach(e -> System.out.print(e + ", "));



    }
}
