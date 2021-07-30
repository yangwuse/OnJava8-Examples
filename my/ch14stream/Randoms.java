package my.ch14stream;

import java.util.Random;

// 流关注做什么 集合关注怎么做
public class Randoms {
    public static void main(String[] args) {
        // 声明式编程风格 只关注目标 不关注实现细节
        new Random(47)
            .ints(5, 20)
            .distinct()
            .limit(7)
            .sorted()
            .forEach( System.out::println);
    }
}
