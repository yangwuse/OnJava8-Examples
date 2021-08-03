package my.ch20generics.wildcard;

// 重要练习

public class Wildcards {
    // 原始类型
    static void rawArgs(Holder holder, Object arg) {
        // warning
        // 不指定 T, T 就退化成 Object
        holder.set(arg);

        // 丢失类型信息 只能返回 Object 
        Object obj = holder.get();
    }

    // 无界通配符类型
    static void unboundedArg(Holder<?> holder, Object arg) {
        // error 
        // Object -> ?
        // holder.set(arg);

        // 丢失类型信息
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        return holder.get();
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        return holder.get();
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // error 子不容父
        // T -> <? extends T>
        // holder.set(arg);

        // <? extends T> -> T
        return holder.get();
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        // ok 父容子
        // T -> <? super T>
        holder.set(arg);

        // 丢失类型信息
        // <? super T> -> Object
        Object raw = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<>();
        Holder<?> unbounded = new Holder<>();
        Holder<? extends Long> bounded = new Holder<>();
        Long lng = 1L;

        // 类型系统原则: 子类可向上转型 父类不可向下转型
        // Holder<?> 等价 Holder 

        // (Holder, Long) -> (Holder, Object)
        rawArgs(raw, lng);
        // (Holder<Long>, Long) -> (Holder, Object)
        rawArgs(qualified, lng);
        // (Holder<?>, Long) -> (Holder, Object)
        rawArgs(unbounded, lng);
        // (Holder<? extends Long>, Long) -> (Holder, Object)
        rawArgs(bounded, lng);

        // (Holder, Long) -> (Holder<?>, Object)
        unboundedArg(raw, lng);
        // (Holder<Long>, Long) -> (Holder<?>, Object)
        unboundedArg(qualified, lng);
        // (Holder<?>, Long) -> (Holder<?>, Object)
        unboundedArg(unbounded, lng);
        // (Holder<? extends Long>, Long) -> (Holder<?>, Object)
        unboundedArg(bounded, lng);

        // Holder -> Holder<T> 
        // 丢失类型信息 只能返回 Object
        Object r1 = exact1(raw);

        // Holder<Long> -> Holder<T> 
        // 返回 Long
        Long r2 = exact1(qualified);

        // Holder<?> -> Holder<T>
        // 擦除到第一个边界剩下 <> 即是 Object
        // 只能返回 Object
        Object r3 = exact1(unbounded);

        // Holder<? extends Long> -> Holder<T>
        // <? extends Long> 擦除到第一个边界 剩下 Long
        Long r4 = exact1(bounded);
        
        // (Holder, Long) -> (Holder<T>, T)
        Long r5 = exact2(raw, lng);

        // (Holder<Long>, Long) -> (Holder<T>, T)
        Long r6 = exact2(qualified, lng);

        // (Holder<?>, Long) -> (Holder<T>, T)
        // Long r7 = exact2(unbounded, lng);

        // (Holder<? extends Long>, Long) -> (Holder<T>, T) 
        // Long r8 = exact2(bounded, lng);

        // (Holder, Long) -> (Holder<? extends T>, T)
        // Object -> Long
        Long r9 = wildSubtype(raw, lng);

        // (Holder<Long>, Long) -> (Holder<? extends T>, T)  
        // Long -> Long 及其子类
        Long r10 = wildSubtype(qualified, lng);

        // (Holder<?>, Long) -> (Holder<? extends T>, T)
        // Object -> Long 及其子类
        // 丢失类型信息 只能返回 Object
        Object r11 = wildSubtype(unbounded, lng);

        // (Holder<? extends Long>, Long) -> (Holder<? extends T>, T)
        Long r12 = wildSubtype(bounded, lng);

        // (Holder, Long) -> (Holder<? super T>, T)
        // Object 作为 T 父类
        wildSupertype(raw, lng);

        // (Holder<Long>, Long) -> (Holder<? super T>, T)
        // Long 作为 Long 及其父类
        wildSupertype(qualified, lng);

        // (Holder<?>, Long) -> (Holder<? super T>, T)
        // Object 作为 Long 及其父类
        wildSubtype(unbounded, lng);

        // (Holder<? extends Long>, Long) -> (Holder<? super T>, T)
        // Long 及其子类 作为 Long 及其父类
        // wildSupertype(bounded, lng);
    }

}
