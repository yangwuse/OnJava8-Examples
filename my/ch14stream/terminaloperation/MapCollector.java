package my.ch14stream.terminaloperation;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// 生成 Map 集合

class Pair {
    public final Character c;
    public final Integer i;
    Pair(Character c, Integer i) {
        this.c = c;
        this.i = i;
    }   
    public Character getC() { return c; }
    public Integer getI() { return i; }
    @Override public String toString() {
        return "Pair(" + c + "," + i + ")";
    }
}

class RandomPair {
    Random rand = new Random(47);
    Iterator<Character> capChars = rand.ints(65, 91)
        .mapToObj(i -> (char)i) // 转化成大写字母
        .iterator();
    public Stream<Pair> stream() {
        return rand.ints(100, 1000).distinct() // 产生不同元素
            .mapToObj(i -> new Pair(capChars.next(), i));

    }
}

public class MapCollector {
    public static void main(String[] args) {
        Map<Integer, Character> map = 
            new RandomPair().stream()
                .limit(10)
                .collect(
                    Collectors.toMap(Pair::getI, Pair::getC));
        System.out.println(map);
    }
}
