package my.ch14stream.createstream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// 流的建造者模式
public class FileToWordsBuilder {
    Stream.Builder<String> builder = Stream.builder();
    public FileToWordsBuilder(String filePath) throws Exception {
        Files.lines(Paths.get(filePath))
            .skip(1)
            .forEach(line -> {
                for (String w : line.split("[ .?,]+"))
                    builder.add(w);
            });
    }
    Stream<String> stream() { return builder.build(); }
    public static void main(String[] args) throws Exception {
        new FileToWordsBuilder("/Users/yangwu/vscode-workspace/java-projects/java-base/onjava8-examples/bookcode/streams/Cheese.dat").stream()
            .limit(17)
            .map(w -> w + " ")
            .forEach(System.out::print);
    }
}
