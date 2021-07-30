package my.ch14stream;

import java.util.Random;
import java.util.stream.Stream;

// 随机泛型流生成器
public class RandomGenerators {
    public static <T> void show(Stream<T> stream) {
        stream
            .limit(4)
            .forEach(System.out::println);
        System.out.println("++++++++");
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        show(rand.ints().boxed());
        show(rand.longs().boxed());
        show(rand.doubles().boxed());
        // 控制流的上下边界
        show(rand.ints(10, 20).boxed());
        show(rand.longs(50, 100).boxed());
        show(rand.doubles(20, 30).boxed());
        // 控制流的大小
        show(rand.ints(2).boxed());
        show(rand.longs(2).boxed());
        show(rand.doubles(2).boxed());
        // 控制流的大小和上下边界
        show(rand.ints(3, 1, 5).boxed());
        show(rand.longs(3, 20, 30).boxed());
        show(rand.doubles(3, 10, 20).boxed());
    }
}
