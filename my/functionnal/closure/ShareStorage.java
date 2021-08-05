package my.functionnal.closure;

import java.util.function.IntSupplier;

// 多次调用闭包 返回多个函数 共享变量

public class ShareStorage {
    public static void main(String[] args) {
        Closure1 c1 = new Closure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
        System.out.println(c1.i);
    }    
}
