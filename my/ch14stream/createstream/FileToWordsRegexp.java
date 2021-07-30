package my.ch14stream.createstream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 正则表达式将字符串转换为单词流
public class FileToWordsRegexp {
    private String all;
    public FileToWordsRegexp(String filePath) throws Exception {
        all = Files.lines(Paths.get(filePath))
            .skip(1)
            .collect(Collectors.joining(" "));
    }
    public Stream<String> stream() {
        // splitAsStream()
        return Pattern
            .compile("[ .?,]+").splitAsStream(all);
    }
    public static void 
    main(String[] args) throws Exception {
        FileToWordsRegexp fw = 
            new FileToWordsRegexp("/Users/yangwu/vscode-workspace/java-projects/java-base/onjava8-examples/bookcode/streams/Cheese.dat");
        fw.stream()
          .limit(7)
          .map(w -> w + " ")
          .forEach(System.out::print);
        fw.stream()
          .skip(7)
          .limit(2)
          .map(w -> w + " ")
          .forEach(System.out::print);
    }
}
