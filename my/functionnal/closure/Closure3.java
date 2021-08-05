package my.functionnal.closure;

import java.util.function.IntSupplier;

// 局部变量必须是 final 

public class Closure3 {
    IntSupplier makeFun(int x) {
        int i = 0;
        // x++ 和 i++ 都不行
        return () -> x++ + i++;
    }    
}
