package rra.javaintro;


import java.util.Random;

public class S2 {


    private static void word(String s1, String s2) {
        System.out.println(s1.contains(s2));
    }

    private static boolean isRotationStrings(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(s2);
        return (s1.equals(sb2.reverse().toString()));
    }


    public static String createUsingStrings(String sign, int times) {
        String result = "";
        int i1,i2;
        i1 = new Random().nextInt(100);
        i2 = new Random().nextInt(100);
        for (int i = 0; i < times; i++) {
            result += createUsingString(i1, sign, i2);
        }
        return result;
    }

    public static String createUsingString(int i1, String sign, int i2) {
        String result = "";
            result = result + Integer.toString(i1)
                    + sign
                    + Integer.toString(i2)
                    + "=";
            if (sign.trim().equals("+")) {
                result += Integer.toString(i1 + i2);
            } else if (sign.trim().equals("-")) {
                result += Integer.toString(i1 - i2);
            } else if (sign.trim().equals("*")) {
                result += Integer.toString(i1 * i2);
            }
            result += " ";

        return result;
    }

    public static String createUsingStringsBuilder(String sign, int times) {
        StringBuilder result = new StringBuilder();
        int i1,i2;
        i1 = new Random().nextInt(100);
        i2 = new Random().nextInt(100);
        for (int i = 0; i < times; i++) {
            result.append(createUsingStringBuilder(i1, sign, i2));
        }
        return result.toString();
    }

    public static StringBuilder createUsingStringBuilder(int i1, String sign, int i2) {
        StringBuilder result = new StringBuilder();
        result.append(i1);
        result.append(sign);
        result.append(i2);
        result.append(" = ");
        if (sign.trim().equals("+")) {
            result.append(i1 + i2);
        } else if (sign.trim().equals("-")) {
            result.append(i1 - i2);
        } else if (sign.trim().equals("*")) {
            result.append(i1 * i2);
        }
        result.append(" ");
        return result;
    }

    public static void main(String[] args) {

        /**
         Урок 2.
         Напишите программу, чтобы найти вхождение в строке
         (содержащей все символы другой строки).
         Напишите программу, чтобы проверить, являются ли две данные строки
         вращением друг друга (вхождение в обратном порядке).
         *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
         Дано два числа, например 3 и 56, необходимо составить следующие строки:
         3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
         Замените символ “=” на слово “равно”.
         Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
         * Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
         ** Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "="
         средствами String и StringBuilder.
         */
        double begin = System.currentTimeMillis();
        String s1 = "Напишите программу, чтобы найти вхождение в строке";
        String s2 = "грамм";

        System.out.println(s1);
        System.out.println(s1.contains(s2)); //true
        System.out.println(s1.indexOf(s2)); //12

        String s3 = "Напишите программу, чтобы проверить,";
        String s4 = "являются ли две данные строки  вращением друг друга";
        System.out.println(s4);
        Boolean r = isRotationStrings("Hello", "olleH");
        System.out.println(r ? "true" : "false"); //true

        int i1 = 3;
        int i2 = 56;


//      необходимо составить следующие строки:
//      3 + 56 = 59 3 – 56 = -53 3 * 56 = 168
        System.out.println(createUsingString(3, " + ", 56));
        System.out.println(createUsingString(3, " - ", 56));
        System.out.println(createUsingString(3, " * ", 56));

        System.out.println(createUsingStringBuilder(3, "+", 56));
        System.out.println(createUsingStringBuilder(3, "-", 56));
        System.out.println(createUsingStringBuilder(3, "*", 56));

        int times;
        times = 10000; //количество циклов
        long start;

        System.out.println("Необходимо составить строки " + Integer.valueOf(times) + " раз, используя String:");
        start = System.currentTimeMillis();
        createUsingStrings("+", times);
        System.out.println("Затрачено " + (System.currentTimeMillis() - start) + " мс."); //Затрачено 143 мс.


        System.out.println("Необходимо составить строки " + Integer.valueOf(times) + " раз, используя StringBulider:");
        start = System.currentTimeMillis();
        createUsingStringsBuilder("+", times);
        System.out.println("Затрачено " + (System.currentTimeMillis() - start) + " мс."); //Затрачено 6 мс.

        times = 10000;
        String testString = createUsingStrings("+", times);

        System.out.println("------------Builder indexof, delete & insert-------");
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(testString);
        int pos;
        while (sb.indexOf("=") > 0) {
            pos = sb.indexOf("=");
            sb.deleteCharAt(pos);
            sb.insert(pos, "равно");
        }
        System.out.println("Затрачено " + (System.currentTimeMillis() - start) + " мс."); //Затрачено 17143 мс.

        //System.out.println(sb.toString());


        System.out.println("----------- String.replace -------------");
        start = System.currentTimeMillis();
        testString = testString.replaceAll("=", "равно");
        System.out.println("Затрачено " + (System.currentTimeMillis() - start) + " мс."); //Затрачено 18 мс.

        //System.out.println(testString);

    }
}
