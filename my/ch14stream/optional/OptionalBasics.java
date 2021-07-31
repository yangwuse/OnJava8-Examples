package my.ch14stream.optional;

import java.util.Optional;
import java.util.stream.Stream;

// Optional 对象基本用法 
// 创建空流
// Stream.<String>empty() or
// Stream<String> s = Stream.empty()

public class OptionalBasics {
    static void test(Optional<String> optString) {
        if (optString.isPresent())
            System.out.println(optString.get());
        else
            System.out.println("Nothing inside!");
    } 
    public static void main(String[] args) {
        test(Stream.of("abcde").findFirst());
        test(Stream.<String>empty().findFirst());
    }   
}
