package my.ch14stream.random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomWords implements Supplier<String> {
    List<String> words = new ArrayList<>();
    Random rand = new Random(47);
    RandomWords(String fileName) throws IOException {
        List<String> lines = 
            Files.readAllLines(Paths.get(fileName));
        // 跳过首行
        for (String line : lines.subList(1, lines.size())) {
            for (String word : line.split("[ .?,]+"))
                words.add(word.toLowerCase());
        }
    }
    @Override public String get() {
        return words.get(rand.nextInt(words.size()));
    }
    @Override public String toString() {
        return words.stream()
            .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws Exception {
        // bug: 没发读取相对路径
        System.out.println(
            Stream.generate(new RandomWords("/Users/yangwu/vscode-workspace/java-projects/java-base/onjava8-examples/bookcode/streams/Cheese.dat"))
                .limit(10)
                .collect(Collectors.joining(" ")));
    }


    
}
