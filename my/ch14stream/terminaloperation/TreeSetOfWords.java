package my.ch14stream.terminaloperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TreeSetOfWords {
    public static void main(String[] args) throws IOException {
        Set<String> words = 
            Files.lines(Paths.get("/Users/yangwu/vscode-workspace/java-projects/java-base/onjava8-examples/my/ch14stream/terminaloperation/TreeSetOfWords.java"))
                .flatMap(s -> Arrays.stream(s.split("\\W+"))) // 非单词
                .filter(s -> !s.matches("\\d+")) // 非数字
                .map(String::trim) // 去除单词两边空格
                .filter(s -> s.length() > 2)
                .limit(100)
                .collect(Collectors.toCollection(TreeSet::new)); // 传入构造器函数
            System.out.println(words);

    }    
}
