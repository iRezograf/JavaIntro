package rra.javaintro;

import org.junit.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;


public class Frequencies {
    @Test
    public void wordsInLine() {
        List<String> frequency = new ArrayList<String>();
        Stream<String> words = Stream.of("gg", "ss", "gg", "boy", "girls", "girls", "gg", "boy", "aa", "aa");

        words.forEach(frequency::add);



        Map<String, Long> wordCount = frequency.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
//        for (String value : wordCount) {
//            System.out.println(value);
//        }
        System.out.println(wordCount);
    }
}
