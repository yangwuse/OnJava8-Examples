package my.ch14stream.optional;

import java.util.Optional;


// 使用 Optioanl 流

public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
            .limit(10)
            .forEach(System.out::println);
        System.out.println(" ---");
        Signal.stream()
            .limit(10)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .forEach(System.out::println);
    }    
}
