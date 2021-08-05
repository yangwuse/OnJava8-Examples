package my.functionnal.highorderfunction;

import java.util.function.Function;

// 高阶函数: 消费一个函数的函数

class One {}
class Two {}

public class ConsumeFunction {
    // 高阶函数
    static Two consume(Function<One, Two> onetwo) {
        return onetwo.apply(new One());
    }
    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
