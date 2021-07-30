package my.ch14stream.generator;

import java.util.stream.Stream;

import bookcode.streams.Bubble;

// 传递方法引用创建对象流
public class Bubbles {
    public static void main(String[] args) {
        Stream.generate(Bubble::bubbler)
            .limit(3)
            .forEach(System.out::println);
    }
}
