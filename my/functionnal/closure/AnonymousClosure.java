package my.functionnal.closure;

import java.util.function.IntSupplier;

public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        return new IntSupplier(){
            public int getAsInt() { return x + i; }
        };
    }    
}
