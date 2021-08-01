package my.ch20generics.genericmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 泛型方法和变长参数共存

public class GenericVarargs {
   public static <T> List<T> makeList(T... args) {
        return Stream.of(args)
            .collect(Collectors.toList());
   }
   public static void main(String[] args) {
       System.out.println(makeList("A"));
       System.out.println(makeList("A", "B", "C"));
       System.out.println(
           makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""))
       );
   }
}
