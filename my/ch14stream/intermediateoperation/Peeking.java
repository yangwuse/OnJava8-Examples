package my.ch14stream.intermediateoperation;

import bookcode.streams.FileToWords;

// 中间操作 peek() 查看元素
public class Peeking {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/Users/yangwu/vscode-workspace/java-projects/java-base/onjava8-examples/bookcode/streams/Cheese.dat")
            .skip(21)
            .limit(4)
            .map(w -> w + " ")
            .peek(System.out::print)
            .map(String::toUpperCase)
            .peek(System.out::print)
            .map(String::toLowerCase)
            .forEach(System.out::print);
    }
}
