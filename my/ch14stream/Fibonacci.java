package my.ch14stream;

import java.util.stream.Stream;

// 使用 iterator() 计算斐波拉契数列
public class Fibonacci {
    static int x = 1;
    static Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int res = x + i;
            x = i;
            return res;
        });
    }
    public static void main(String[] args) {
        numbers()
        .skip(20)
        .limit(10)
        .forEach(System.out::println);
    }
}
