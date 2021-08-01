package my.ch20generics.genericmethod;

// 尽可能使用泛型方法

public class GenericMethods {
    // 泛型参数列表在返回值前
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f('c');
        gm.f("");
        gm.f(1);
        gm.f(1.0F);
        gm.f(1.0);
        gm.f(gm);
    }
}
