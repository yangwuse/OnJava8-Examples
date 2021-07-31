package my.ch14stream.intermediateoperation;

import java.util.stream.Stream;

// 改变输出流类型为数值类型

public class FunctionMap3 {
    public static void main(String[] args) {
        // String 流 -> int 流
        Stream.of("5", "7", "9")
            .mapToInt(Integer::parseInt)
            .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        // String 流 -> long 流
        Stream.of("17", "19", "23")
            .mapToLong(Long::parseLong)
            .forEach(n -> System.out.format("%d ", n));
        System.out.println();

        // String 流 -> double 流
        Stream.of("17", "1.9", ".23")
            .mapToDouble(Double::parseDouble)
            .forEach(n -> System.out.format("%.2f ", n));
        
    }
}
