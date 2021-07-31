package my.ch14stream.intermediateoperation;

import java.util.stream.Stream;

// flatMap() 扁平化输入多个流为一个输出流

public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
            .flatMap(i -> Stream.of("a", "b", "c"))
            .forEach(System.out::println);
    }    
}
