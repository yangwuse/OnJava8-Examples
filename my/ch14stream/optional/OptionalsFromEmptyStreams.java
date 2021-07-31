package my.ch14stream.optional;

import java.util.stream.IntStream;
import java.util.stream.Stream;

// Optional 
// 返回对象包装在 Optional 对象中 防止空流

public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        // 返回空流 Optinal.empty
        
        System.out.println(Stream.<String>empty()
            .findFirst());
        
        System.out.println(Stream.<String>empty()
            .findAny());
        
        System.out.println(Stream.<String>empty()
            .max(String.CASE_INSENSITIVE_ORDER));
        
        System.out.println(Stream.<String>empty()
            .min(String.CASE_INSENSITIVE_ORDER));
        
        System.out.println(Stream.<String>empty()
            .reduce((s1, s2) -> s1 + s2));
        
        System.out.println(IntStream.empty()
            .average());        
        
    }    
}
