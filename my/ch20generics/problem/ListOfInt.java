package my.ch20generics.problem;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 基本类型无法作为类型参数 
// 自动装箱机制

public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(10, 20)
            .boxed() // 装箱
            .collect(Collectors.toList());
        System.out.println(list);
    }
}
