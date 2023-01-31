package rra.javaintro;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class S5 {

    public static void main(String[] args) {
//        1.Создать словарь HashMap. Обобщение <Integer, String>.
//        2.Заполнить пятью ключами (индекс, ФИО+Возраст+Пол
//        "Иванов Иван Иванович 28 м"),
//        добавить ключь, если не было!)
//        3.Изменить значения сделав пол большой буквой.
//        4.Пройти по коллекции и вывести значения в формате
//        Фамилия инициалы "Иванов И.И."
//        5.*Сортировать значения по возрасту и
//        вывести отсортированную коллекция
//        как в четвёртом пункте.

        People people;
        HashMap<Integer, People> map = new HashMap<>();
        Random rnd = new Random();


        try {
            File file = new File("bd.sql");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] oneMan = scanner.nextLine().split(" ");
                //long start = System.currentTimeMillis();
                people = new People();
                for (int i = 0; i < oneMan.length; i++) {
//                    System.out.println(oneMan[i]);
                    people.setFamily(oneMan[0]);
                    people.setName(oneMan[1]);
                    people.setSoname((oneMan[2]));
                    people.setAge(Integer.valueOf(oneMan[3]));
                    people.setGender(oneMan[4].toUpperCase()); // Сделать пол с большой буквы
//                    people.setGender(oneMan[4].split("")[0].toUpperCase()); // Сделать пол с большой буквы
                }
                map.put(rnd.nextInt(), people);
                //System.out.println(start - System.currentTimeMillis());
            }
        } catch (IOException e) {
            System.out.println("problems!!");
            throw new RuntimeException(e);
        }

        //map.forEach((integer, p) -> System.out.println(p));

        map.forEach((integer, p) -> System.out.println(p.printInS5Format()));
    }
}


