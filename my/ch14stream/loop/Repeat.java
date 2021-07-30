package my.ch14stream.loop;
import static java.util.stream.IntStream.*;

// 工具类 替代 for 循环
public class Repeat {
    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i -> action.run());
    }
}
