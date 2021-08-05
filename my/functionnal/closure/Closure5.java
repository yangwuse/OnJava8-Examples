package my.functionnal.closure;

import java.util.function.IntSupplier;

// 局部变量不能在方法中修改

public class Closure5 {
    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        return () -> x + i;
    }    
}
