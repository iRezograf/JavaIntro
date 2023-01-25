package rra.javaintro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class S4 {
//        1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль,
//        используя классы FileWriter и FileReader
//        2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы.
//        Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
//        3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки.
//        Фамилии, имена, отчества, возрас и пол в отдельных списках.
//        4.Отсортировать по возрасту используя дополнительный список индексов.
    public static void main(String[] args) {
        // Создать текстовый файл потом его считать.

        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        String text = "";
        try {
//            FileWriter fileWriter = new FileWriter("bd.sql",true);
//
//            fileWriter.append("Молодцова Наталья Семеновна 25 Ж");
//            fileWriter.append("Молодцов Семен Семенович 65 М");
//            fileWriter.append("Баранова Людмила Борисовна 32 Ж");
//            fileWriter.append("Емельяненко Евгений Анатольевич 28 М");
//            fileWriter.append("Семенов Сергей Иванович 45 М");
//            fileWriter.append("Лебедева Елизавета Николаевна 37 Ж");

//            fileWriter.flush();
//            fileWriter.close();

            FileReader fileReader = new FileReader("bd.sql");

            while (fileReader.ready()) {
                text += (char) fileReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] str = text.split("\n");

            System.out.println("Исходный список в формате Фамилия И.О. возраст пол:");
        for (int i = 0; i < str.length; i++) {
            String[] sb = str[i].split(" ");
            family.add(sb[0]);
            name.add(sb[1]);
            soname.add(sb[2]);
//            name.add(sb[1].charAt(0) + ".");
//            soname.add(sb[2].charAt(0) + ".");
            age.add(Integer.valueOf(sb[3]));
//            booleanGender = (sb[4] == "M" ? true : false);
            gender.add(sb[4]);
            index.add(i);
            System.out.printf("%-15s %s.%s. %s %s", sb[0], sb[1].charAt(0), sb[2].charAt(0), sb[3], sb[4]);
            System.out.println("");
        }

        System.out.println("\nОтсортированный по возрасту исходный список:");
//        LinkedList<Integer> ind = bulbSortString(family, index);
        LinkedList<Integer> ind = bulbSortInteger(age, index, (a,b)-> {return a<b;} );
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[ind.get(i)]);
        }
    }

    public  static LinkedList<Integer> bulbSortString( ArrayList<String> comparedArray, LinkedList<Integer> indexComparedArray){
        ArrayList<String> ca = new ArrayList<>(comparedArray);
        LinkedList<Integer> ind = new LinkedList<>(indexComparedArray);
        Integer bufferForExchange;
        for (int i = 0; i < ca.size()-1; i++) {
            for (int j = 0; j < ca.size()-i-1; j++) {
                if (ca.get(ind.get(j)).compareTo(ca.get(ind.get(j+1))) > 0 ) {
                    bufferForExchange = ind.get(j);
                    ind.set(j,ind.get(j+1));
                    ind.set(j+1, bufferForExchange);
                }
            }
        }
        return  ind;
    }

    public  static LinkedList<Integer> bulbSortInteger(ArrayList<Integer> comparedArray,
                                                       LinkedList<Integer> indexComparedArray,
                                                       BiFunction<Integer, Integer, Boolean> compare){
        ArrayList<Integer> ca = new ArrayList<>(comparedArray);
        LinkedList<Integer> ind = new LinkedList<>(indexComparedArray);
        Integer bufferForExchange;
        for (int i = 0; i < ca.size()-1; i++) {
            for (int j = 0; j < ca.size()-i-1; j++) {
//                if (ca.get(ind.get(j)).compareTo(ca.get(ind.get(j+1))) > 0 ) {
                if ( compare.apply(ca.get(ind.get(j)),ca.get(ind.get(j+1))) ) {
                    bufferForExchange = ind.get(j);
                    ind.set(j,ind.get(j+1));
                    ind.set(j+1, bufferForExchange);
                }
            }
        }
        return  ind;
    }

    public static void printWithIndex(ArrayList<String> comparedArray, LinkedList<Integer> indexComparedArray) {
        for (Integer i: indexComparedArray
        ) {
            System.out.println(comparedArray.get(i));
        };
    }

    public static void printWithIndexInteger(ArrayList<Integer> comparedArray, LinkedList<Integer> indexComparedArray) {
        for (Integer i: indexComparedArray
        ) {
            System.out.println(comparedArray.get(i));
        };
    }
}
