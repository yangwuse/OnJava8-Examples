package my.functionnal.functionalinterface;

import java.util.function.BiConsumer;

// 方法引用 通过调用接口方法来调用绑定方法

class In1 {}
class In2 {}

public class MethodConversion {
    static void accept(In1 i1, In2 i2) {
        System.out.println("accept()");
    }    
    static void someOtherName(In1 i1, In2 i2) {
        System.out.println("someOtherName()");
    }
    public static void main(String[] args) {
        BiConsumer<In1, In2> bic;

        bic = MethodConversion::accept;
        bic.accept(new In1(), new In2());

        // 统一使用函数接口方法 accept()
        bic = MethodConversion::someOtherName;
        bic.accept(new In1(), new In2());

    }
}
