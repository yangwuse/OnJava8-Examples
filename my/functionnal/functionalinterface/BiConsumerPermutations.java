package my.functionnal.functionalinterface;

import java.util.function.BiConsumer;

public class BiConsumerPermutations {
    static BiConsumer<Integer, Double> bcid = (i, d) -> 
        System.out.format("%d, %f%n", i, d);
    static BiConsumer<Double, Integer> bcdi = (d, i) -> 
        System.out.format("%f, %d%n", d, i);
    static BiConsumer<Integer, Long> bcil = (i, l) -> 
        System.out.format("%d, %d%n", i, l);
    public static void main(String[] args) {
        bcid.accept(1, 2.0);
        bcdi.accept(1.0, 2);
        bcil.accept(1, 2l);
    }
 
}
