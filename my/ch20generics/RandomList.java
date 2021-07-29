package my.ch20generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// 泛型随机列表
public class RandomList<T> extends ArrayList<T> {
    private Random rand = new Random();
    // 随机返回一个元素
    public T select() {
        return get(rand.nextInt(size()));
    }
    public static void main(String[] args) {
        RandomList<String> rl = new RandomList<>();
        Arrays.stream("1 2 3 4 A B C D".split(" "))
            .forEach(rl::add);
        IntStream.range(0, 9).forEach(i -> 
        System.out.println(rl.select() + " "));
    }
}
