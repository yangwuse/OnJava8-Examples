package my.functionnal.closure;

import java.util.function.IntSupplier;

public class Closure7 {
    IntSupplier makeFun(int x) {
        Integer i = 0;
        i++;
        return () -> x + i;
    }
}
