package my.ch14stream.intermediateoperation;
import static java.util.stream.LongStream.*;
import java.util.stream.LongStream;


// 过滤元素
public class Prime {
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long)Math.sqrt(n))
            .noneMatch(i -> n % i == 0);
    }
    public LongStream numbers() {
        // filter() 过滤元素
        return iterate(2, i -> i + 1)
            .filter(Prime::isPrime);
    }
    public static void main(String[] args) {
        new Prime().numbers()
            .limit(10)
            .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        new Prime().numbers()
            .skip(90)
            .limit(10)
            .forEach(n -> System.out.format("%d ", n));
    }

}
