package my.ch14stream;

import static java.util.stream.IntStream.*;

// IntStream.range() 整型序列流
public class Ranges {
    public static void main(String[] args) {
        // 传统方式
        int result = 0;
        for (int i = 10; i < 20; i++)
            result += i;
        System.out.println(result);

        // 有范围的 for-in 
        result = 0;
        for (int i : range(10, 20).toArray())
            result += i;
        System.out.println(result);

        // 使用流
        System.out.println(range(10, 20).sum());
    }

}
