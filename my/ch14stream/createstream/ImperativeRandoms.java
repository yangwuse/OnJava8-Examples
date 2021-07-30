package my.ch14stream.createstream;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

// 命令式编程风格告诉计算机每一步具体该如何做
// 不如函数式(声明式)编程风格简单 
// 它只需要告诉计算机每一步做什么就行了
public class ImperativeRandoms {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> set = new TreeSet<>();
        while (set.size() < 7) {
            int i = rand.nextInt(20);
            if (i < 5)  continue;
            set.add(i);
        }
        System.out.println(set);
    }
}
