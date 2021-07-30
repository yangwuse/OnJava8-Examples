package my.ch14stream.createstream;

import java.util.Arrays;

// Arrays.stream() 创建 IntStream LongStream DoubleStream
public class ArrayStreams {
    public static void main(String[] args) {
        // DoubleStream
        Arrays.stream(new double[] { 3.14159, 2.718, 1.618 })
            .forEach(n -> System.out.format("%f ", n));
        System.out.println();
        Arrays.stream(new int[] { 1, 3, 5})
            .forEach(n -> System.out.format("%d ", n));
        System.err.println();
        // LongStream
        Arrays.stream(new long[] { 11, 22, 33})
            .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        // 选择一个子区间
        Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6, 7, 8}, 2, 5)
            .forEach(n -> System.out.format("%d ", n));
    }
}
