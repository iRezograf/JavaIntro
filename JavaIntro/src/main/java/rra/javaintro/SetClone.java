package rra.javaintro;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetClone {
    private static Object OBJECT;
    private Map<Integer, Object> setClone;

    public SetClone() {
        this.setClone = new HashMap<>();
    }

    public static void main(String[] args) {
//  Разработать программу, имитирующую поведение коллекции HashSet.
//  В программе содать метод add добавляющий элемент,
//  и метод позволяющий выводить эллементы коллекции в консоль.
//  Формат данных Integer.
//    Set<Integer> set = new HashSet<>();
//    set.add(22);
//    set.add(82);
//    set.add(224);
//    set.add(224);
//    set.add(212);
//    set.forEach(integer -> System.out.println(integer));

        SetClone pseudoSet = new SetClone();
        pseudoSet.add(22);
        pseudoSet.add(82);
        pseudoSet.add(224);
        pseudoSet.add(224);
        pseudoSet.add(212);

        System.out.println(pseudoSet);
    }

    public void add(Integer val) {
        this.setClone.put(val, OBJECT);
    }

    @Override
    public String toString() {
        return this.setClone.entrySet().stream()
                .map(e -> e.getKey() + " ")
                .collect(Collectors.joining());
    }
}



//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        this.setClone.forEach((key, value) -> sb.append(key).append(" "));
//        return sb.toString();
//    }



