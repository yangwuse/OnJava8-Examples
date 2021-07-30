package my.ch14stream;

import java.util.stream.Stream;
import bookcode.streams.Bubble;

// Stream.of() 将一组普通元素转为流
public class StreamOf {
    public static void main(String[] args) {
        Stream.of(new Bubble(1), new Bubble(2), new Bubble(3))
            .forEach(System.out::println);
        Stream.of("have ", "a ", "good ", "day!")
            .forEach(System.out::print);
        System.out.println();
        Stream.of(1, 2, 3)
            .forEach(System.out::println);
    }
}
