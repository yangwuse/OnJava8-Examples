package my.interfaces.interfaceadapter;

import java.util.Random;

public interface RandonDouble {
    Random RAND = new Random(47);
    default double next() {
        return RAND.nextDouble();
    }
    public static void main(String[] args) {
        RandonDouble rd = new RandonDouble(){};
        for (int i = 0; i < 7; i++)
            System.out.println(rd.next() + " ");
    }
}
