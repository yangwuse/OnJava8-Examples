package my.ch14stream.generator;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Stream.generate() 创建对象流
public class Duplicator {
    public static void main(String[] args) {
        // limit() 限制流大小
        Stream.generate(()-> new Random().nextInt(10))
            .limit(5)
            .forEach(System.out::println);
        IntStream.range(10, 20)
            .limit(5)
            .forEach(System.out::println);
    }
}
