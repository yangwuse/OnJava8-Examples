package my.functionnal.methodreference;

// 未绑定方法与多个参数

class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(This aThis, int i, double d, String s, char c);
}

public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs two = This::two;
        ThreeArgs three = This::three;
        FourArgs four = This::four;
        This aThis = new This();
        two.call2(aThis, 1, 2.1);
        three.call3(aThis, 1, 2.1, "Three");
        four.call4(aThis, 1, 2.1, "Four", 'c');
    }    
}
