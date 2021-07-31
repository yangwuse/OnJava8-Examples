package my.ch14stream.intermediateoperation;

import java.util.stream.Stream;

// 改变流的数据类型
// 输入流和输出流类型不同

class Numbered {
    final int n;
    Numbered(int n) { this.n = n; }
    @Override public String toString() {
        return "Numbered(" + n + ")";
    }
}
public class FunctionMap2 {
    public static void main(String[] args) {
        Stream.of(1, 5, 7, 9, 11, 13)
            .map(Numbered::new)
            .forEach(System.out::println);
    }
}