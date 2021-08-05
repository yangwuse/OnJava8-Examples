package my.functionnal.functionalinterface;

// 多参数函数式接口

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
