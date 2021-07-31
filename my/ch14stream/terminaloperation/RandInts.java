package my.ch14stream.terminaloperation;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// toArray() 生成数组

public class RandInts {
    private static int[] rints = 
        new Random(47).ints(0, 1000).limit(100).toArray();
    public static IntStream rands() {
        return Arrays.stream(rints);
    }
    public static void main(String[] args) {
        RandInts.rands()
            .limit(10)
            .mapToObj(i -> i + " ")
            .forEach(System.out::print);
    }

}
