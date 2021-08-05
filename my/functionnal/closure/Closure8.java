package my.functionnal.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> l = new ArrayList<>();
        l.add(1);
        return () -> l;
    }
    public static void main(String[] args) {
        Closure8 c8 = new Closure8();
        List<Integer> l1 = c8.makeFun().get();
        List<Integer> l2 = c8.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(12);
        l2.add(13);
        System.out.println(l1);
        System.out.println(l2);
    }
}
