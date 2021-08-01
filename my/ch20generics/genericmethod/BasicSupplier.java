package my.ch20generics.genericmethod;

import java.util.function.Supplier;

// 泛型 Supplier
// 传入类型的 Class 对象 返回该类型的实例

public class BasicSupplier<T> implements Supplier<T> {
    private Class<T> type;
    public BasicSupplier(Class<T> t) { type = t; }   
    // 实例化类型对象
    @Override public T get() {
        try {
            // 假设类是 public 的
            return type.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // 返回默认 Supplier
    public static <T> Supplier<T> create(Class<T> type) {
        return new BasicSupplier<>(type);
    }
}
