package my.ch14stream.optional;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

// 生成 Optional 流

public class Signal {
    private final String msg;
    public Signal(String s) { msg = s; }
    public String getMsg() { return msg; }
    @Override public String toString() {
        return "Signal(" + msg + ")";
    }    
    static Random rand = new Random(47);
    // 生成对象
    public static Signal morse() {
        switch(rand.nextInt(4)) {
            case 1: return new Signal("dot");
            case 2: return new Signal("dash");
            default: return null;
        }
    }
    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse)
            .map(Optional::ofNullable);
    }
}
