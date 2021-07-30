package my.ch14stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import bookcode.streams.Bubble;

// stream() 将集合转换为流
public class CollectionToStream {
    public static void main(String[] args) {
        // list
        List<Bubble> bubbles = Arrays.asList(
            new Bubble(1), new Bubble(2), new Bubble(3));
        System.out.println(
            bubbles.stream()
                .mapToInt(b -> b.i)
                .sum());
        
        // set
        Set<String> set = new HashSet<>(Arrays.asList(
            "have a good day!".split(" ")));
        set.stream()
            .map(x -> x + " ")
            .forEach(System.out::print);
        System.out.println();

        // map
        Map<String, Bubble> map = new HashMap<>();
        map.put("1", new Bubble(1));
        map.put("2", new Bubble(2));
        map.put("3", new Bubble(3));
        map.entrySet().stream()
            .map(e -> e.getKey() + ": " + e.getValue())
            .forEach(System.out::println);
    }
}
