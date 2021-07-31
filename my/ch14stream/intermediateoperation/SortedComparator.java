package my.ch14stream.intermediateoperation;

import java.util.Comparator;

import bookcode.streams.FileToWords;

// 传入比较器
public class SortedComparator {
    public static void main(String[] args) throws Exception {
        FileToWords.stream("/Users/yangwu/vscode-workspace/java-projects/java-base/onjava8-examples/bookcode/streams/Cheese.dat")
            .skip(10)
            .limit(10)
            .sorted(Comparator.reverseOrder())
            .map(w -> w + " ")
            .forEach(System.out::print);
    }
}
