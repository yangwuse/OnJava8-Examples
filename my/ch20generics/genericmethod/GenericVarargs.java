package my.ch20generics.genericmethod;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

// 泛型方法和变长参数共存

public class GenericVarargs {
    @SafeVarargs
    public static <T> List<T> makeList(T... args) {
        List<T> res = new ArrayList<>();
        Stream.of(args).forEach(res::add);
        return res;
    }
    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);
        ls = makeList("A", "B", "C");
        System.out.println(ls);
        ls = makeList(
            "ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
