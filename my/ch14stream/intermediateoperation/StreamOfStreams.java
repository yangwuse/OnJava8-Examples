package my.ch14stream.intermediateoperation;

import java.util.stream.Stream;

// 函数产生元素流 
// flatMap() 将多个元素流 扁平化一个输出流

public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
            .map(i -> Stream.of("a", "b", "c"))
            .map(e -> e.getClass().getName())
            .forEach(System.out::println);
    }
}
