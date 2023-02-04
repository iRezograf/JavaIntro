package rra.stepik;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TernaryIntPredicateExample {
    @FunctionalInterface
    public interface TernaryIntPredicate {
        Boolean test(Integer i1, Integer i2, Integer i3);
    }
    public static final TernaryIntPredicate allValuesAreDifferentPredicate =
            (i1, i2, i3) -> Stream.of(i1, i2, i3).collect(Collectors.toSet()).size() > 2;

/***    ниже та же конструкция, что наверху, но решенная без стрима: ***/
//    public static final TernaryIntPredicate allValuesAreDifferentPredicate = new TernaryIntPredicate() {
//        @Override
//        public Boolean test(Integer i1, Integer i2, Integer i3) {
//            return Stream.of(i1, i2, i3).collect(Collectors.toSet()).size() >2;
//            Set<Integer> set = new HashSet<>();
//            set.add(i1);
//            set.add(i2);
//            set.add(i3);
//            return set.size() > 2;

// }



    public static void main(String[]args){
        System.out.println(allValuesAreDifferentPredicate.test(1,2,3)?"true":"false");
        }


}




