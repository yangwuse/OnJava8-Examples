package my.ch14stream.intermediateoperation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// flatMap() 展开多个流为一个输出流
// 将文件转换为单词流 且不需要中间存储

public class FileToWords {
    public static Stream<String> stream(String filePath)
    throws IOException {
        return Files.lines(Paths.get(filePath))
            .skip(1)
            .flatMap(line -> 
                Pattern.compile("\\W+").splitAsStream(line));
    }
}
