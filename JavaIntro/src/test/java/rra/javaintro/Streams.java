package rra.javaintro;

import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Streams {
    @Test
    public void creation() throws IOException {
        String f = "/Users/rafaelrezyapov/IdeaProjects/JavaIntro/src/test/java/rra/javaintro/Streams.java";
        ArrayList<String> aa = new ArrayList<>();
        ArrayList<String> bb = new ArrayList<>();
        Stream<String> lines = Files.lines(Paths.get(f));
        lines.forEach(aa::add);

        for (String item: aa) {
            String[] w = item.split(" ",0);
            for (String a : w)
                bb.add(a);
        }
        //bb.forEach(n-> System.out.println(n));
        Map<String, Long> wordCount = bb.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder())
                        .thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(wordCount);


        Stream<Path> list = Files.list(Paths.get("./"));
        //list.forEach(s-> System.out.println(s));
        //System.out.println();

        Stream<Path> walk = Files.walk(Paths.get("./"), 3);
        //walk.forEach(s-> System.out.println(s));
        //System.out.println();

        IntStream intStream = IntStream.of(1, 2, 3, 4);
        DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
        IntStream range = IntStream.range(10, 100); // 10 .. 99
        IntStream intStream1 = IntStream.rangeClosed(10, 100); // 10 .. 100

        int[] ints = {1, 2, 3, 4};
        IntStream stream = Arrays.stream(ints);

        Stream<String> stringStream = Stream.of("1", "2", "3");
        Stream<? extends Serializable> stream1 = Stream.of(1, "2", "3");

        Stream<String> build = Stream.<String>builder()
                .add("Mike")
                .add("joe")
                .build();

//        Stream<Employee> stream2 = emps.stream();
//        Stream<Employee> employeeStream = emps.parallelStream();
//
//        Stream<Event> generate = Stream.generate(() ->
//                new Event(UUID.randomUUID(), LocalDateTime.now(), "")
//        );

        Stream<Integer> iterate = Stream.iterate(1950, val -> val + 3);

        Stream<String> concat = Stream.concat(stringStream, build);

    }
}
