package my.functionnal.highorderfunction;

import java.util.function.Function;

// 高阶函数: 产生一个函数的函数

interface FuncSS extends Function<String, String> {}

public class ProduceFunction {
    // 高阶函数
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }
    public static void main(String[] args) {
        FuncSS f = ProduceFunction.produce();
        System.out.println(f.apply("High order function"));
    }
}
