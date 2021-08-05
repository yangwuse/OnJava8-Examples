package my.functionnal.closure;

import java.util.function.IntSupplier;

// 多余的 final 处理

public class Closure6 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        final int iFinal = i;
        final int xFinal = x;
        return () -> xFinal + iFinal;
    }
}
