package my.ch20generics.genericinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

// 斐波拉契数列生成器 实现 Supplier<T>
// 改进版 带缓存 

public class Fibonacci implements Supplier<Long> {
    private int count = 0;
    // 缓存
    private Map<Integer, Long> cache = new HashMap<>();
    @Override public Long get() {
        return fib(count++);
    }
    public long fib(int n) {
        if (n < 3) return 1;
        long a = 0, b = 0, c = 0;

        // 先访问缓存
        if (cache.containsKey(n - 3))
            // 自动解包装
            a = cache.get(n - 3);
        if (cache.containsKey(n - 2))
            b = cache.get(n - 2);
        if (cache.containsKey(n - 1))
            c = cache.get(n - 1);
        
        // 缓存不命中
        if (a == 0) {
            a = fib(n - 3);
            cache.put(n - 3, a);
        }
        if (b == 0) {
            b = fib(n - 2);
            cache.put(n - 2, b);
        }
        if (c == 0) {
            c = fib(n - 1);
            cache.put(n - 1, c);
        }
            
        return a + b + c;
    }
    public static void main(String[] args) {
        Stream.generate(new Fibonacci())
            .limit(70)
            .map(n -> n + " ")
            .forEach(System.out::print);
    }
    
}
