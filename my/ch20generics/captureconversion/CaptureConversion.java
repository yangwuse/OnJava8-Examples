package my.ch20generics.captureconversion;

import bookcode.generics.Holder;

// ? 捕获具体参数类型 在方法内部使用

public class CaptureConversion {
    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder) {
        // holder 类型确定了(被捕获了)
        f1(holder); 
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>(1);

        // Holder -> Holder<T>
        f1(raw);

        // Holder -> Holder<?> -> Holder<T>
        f2(raw);

        Holder rawBasic = new Holder();
        rawBasic.set(new Object());

        f2(rawBasic);

        Holder<?> wildcard = new Holder<>(1.0);
        f2(wildcard);

    }
    
}
